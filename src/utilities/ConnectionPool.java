package utilities;

import java.util.ArrayList;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class ConnectionPool {
	static ArrayList<Connection> connections=null;
	static ConnectionPool instance=null;
	public synchronized void putConnection(Connection c)
	{
		connections.add(c);
		notifyAll();
	}
	public static synchronized ConnectionPool getInstance()
	{
		if(instance==null)
		{
			instance=new ConnectionPool();
		}
		return instance;
	}
	public synchronized Connection getConnection()
	{
		Connection c=null;
		if(connections==null)
			return null;
		while(true)
		{
			if(connections.size()>0)
			{
				c=connections.get(0);
				connections.remove(0);
				break;
			}
			else
			{
				try
				{
					wait();
				}
				catch(InterruptedException ex)
				{
					ex.printStackTrace();
				}
			}
		}
		return c;
	}
	public synchronized void removeAllConnections()
	{
		try
		{
			if(connections==null)
				return;
			int size=connections.size();
			for(int i=0;i<size;i++)
			{
				Connection c=connections.get(i);
				c.close();
			}
			connections.clear();
			connections=null;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	public synchronized void initialize()
	{
		if(connections==null)
		{
			try
			{
				Properties pro=new Properties();
				InputStream ins=getClass().getResourceAsStream("Connection.properties");
				pro.load(ins);
				String driver=pro.getProperty("driver");
				String url=pro.getProperty("url");
				String userName=pro.getProperty("username");
				String password=pro.getProperty("password");
				int maxConnections=Integer.parseInt(pro.getProperty("maxconnection"));
				Class.forName(driver);
				connections=new ArrayList<>();
				int count=0;
				while(count<maxConnections)
				{
					Connection conn=DriverManager.getConnection(url, userName, password);
					connections.add(conn);
					count++;
				}
			}
			catch(ClassNotFoundException ex)
			{
				ex.printStackTrace();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
