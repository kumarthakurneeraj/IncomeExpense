package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojos.UsersPojo;
import utilities.ConnectionPool;

public class UsersDao {
	static ArrayList<Connection> connections=null;
	static ConnectionPool instance=null;
public static void create(UsersPojo bp)
{
	ConnectionPool pool=ConnectionPool.getInstance();
	pool.initialize();
	Connection conn=pool.getConnection();
	try
	{
		String sql="insert into users(username, password, name, address, mobile, email) values(?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, bp.getUserName());
		ps.setString(2, bp.getPassword());
		ps.setString(3, bp.getName());
		ps.setString(4, bp.getAddress());
		ps.setString(5, bp.getMobile());
		ps.setString(6, bp.getEmail());
		int ans=ps.executeUpdate();
		if(ans!=0)
			System.out.println("Row inserted successfully");
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		pool.putConnection(conn);
	}
}
public static void edit(UsersPojo bp)
{
	ConnectionPool pool=ConnectionPool.getInstance();
	pool.initialize();
	Connection conn=pool.getConnection();
	try
	{
		String sql="update users set username=?, password=?, name=?, address=?, mobile=?, email=? where uid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, bp.getUserName());
		ps.setString(2, bp.getPassword());
		ps.setString(3, bp.getName());
		ps.setString(4, bp.getAddress());
		ps.setString(5, bp.getMobile());
		ps.setString(6, bp.getEmail());
		ps.setInt(7, bp.getuId());
		int ans=ps.executeUpdate();
		if(ans!=0)
			System.out.println("Updated successfully");
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		pool.putConnection(conn);
	}
}
public static void remove(int uId)
{
	ConnectionPool pool=ConnectionPool.getInstance();
	pool.initialize();
	Connection conn=pool.getConnection();
	try {
	String sql="delete from users where uid=?";
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setInt(1, uId);
	int ans=ps.executeUpdate();
	if(ans!=0)
		System.out.println("Deleted successfully");
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		pool.putConnection(conn);
	}
}
public static UsersPojo find(int uId)
{
	ConnectionPool pool=ConnectionPool.getInstance();
	pool.initialize();
	Connection conn=pool.getConnection();
	UsersPojo bp=new UsersPojo();
	try
	{
		String sql="select * from users where uid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, uId);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			bp.setuId(rs.getInt(1));
			bp.setUserName(rs.getString(2));
			bp.setPassword(rs.getString(3));
			bp.setName(rs.getString(4));
			bp.setAddress(rs.getString(5));
			bp.setMobile(rs.getString(6));
			bp.setEmail(rs.getString(7));
		}
		
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		pool.putConnection(conn);
	}
	return bp;
}
public final static ArrayList<UsersPojo> findAll()
{
	ConnectionPool pool=ConnectionPool.getInstance();
	pool.initialize();
	Connection conn=pool.getConnection();
	ArrayList<UsersPojo> list=new ArrayList<>();
	try
	{
		
		String sql="select * from users";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			UsersPojo bp=new UsersPojo();
			bp.setuId(rs.getInt(1));
			bp.setUserName(rs.getString(2));
			bp.setPassword(rs.getString(3));
			bp.setName(rs.getString(4));
			bp.setAddress(rs.getString(5));
			bp.setMobile(rs.getString(6));
			bp.setEmail(rs.getString(7));
			list.add(bp);
		}
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		pool.putConnection(conn);
	}
	return list;
}
public static int checkAvailablity(String uname) 
{
	ConnectionPool pool=ConnectionPool.getInstance();
	pool.initialize();
	Connection conn=pool.getConnection();
	int ans=0;
	try
	{
		String sql="select username from users where username=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			ans=1;
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		pool.putConnection(conn);
	}
	return ans;
}
public static int checkAvailablity(String uname, String pwd) 
{
	ConnectionPool pool=ConnectionPool.getInstance();
	pool.initialize();
	Connection conn=pool.getConnection();
	int ans=-1;
	try
	{
		String sql="select uid from users where username=? and password=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, pwd);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			ans=rs.getInt("uid");
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		pool.putConnection(conn);
	}
	return ans;
}
public static UsersPojo authenticate(String un, String pwd) 
{
	ConnectionPool pool=ConnectionPool.getInstance();
	pool.initialize();
	Connection conn=pool.getConnection();
	UsersPojo bp=new UsersPojo();
	try
	{
		String sql="select * from users where username=? and password=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, un);
		ps.setString(2, pwd);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			bp.setuId(rs.getInt(1));
			bp.setUserName(rs.getString(2));
			bp.setPassword(rs.getString(3));
			bp.setName(rs.getString(4));
			bp.setAddress(rs.getString(5));
			bp.setMobile(rs.getString(6));
			bp.setEmail(rs.getString(7));
		}
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		pool.putConnection(conn);
	}
	return bp;
}
public static void main(String []args)
{
//	String uid, username, password, name, address, mobile, email;
//	UsersPojo p=new UsersPojo("kumarthakurneeraj","Niraj@123","Niraj Kumar Thakur","Bharatnagar","8358054932","kumarthakurneeraj@gmail.com");
//	UsersDao.create(p);
int ans=UsersDao.checkAvailablity("mitesh","12345");
System.out.println(ans);
//	if(ans!=0)
//		System.out.println("Users existed in database");
//	else
//		System.out.println("Users do not exist in database");
	//UsersPojo up=UsersDao.authenticate("kumarthakurneeraj","Niraj@123");
	//System.out.println(up);
}
}
