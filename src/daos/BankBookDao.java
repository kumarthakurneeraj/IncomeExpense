package daos;

import pojos.BankBookPojo;
import utilities.ConnectionPool;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class BankBookDao {
	public static void create(BankBookPojo bp)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="insert into bank_book(account,tran_date,amount,userid,operation) values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bp.getAccount());
			java.sql.Date date=new java.sql.Date(bp.getTranDate().getTime());
			ps.setDate(2, date);
			ps.setDouble(3, bp.getAmount());
			ps.setInt(4, bp.getUserId());
			ps.setString(5, bp.getOperation());
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
	public static void edit(BankBookPojo bp)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="update bank_book set account=?,tran_date=?,amount=?,userid=?,operation=? where acid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bp.getAccount());
			java.sql.Date date=new java.sql.Date(bp.getTranDate().getTime());
			ps.setDate(2, date);
			ps.setDouble(3, bp.getAmount());
			ps.setInt(4, bp.getUserId());
			ps.setString(5, bp.getOperation());
			ps.setInt(6, bp.getAcId());
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
	public static void remove(int acId)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try {
		String sql="delete from bank_book where acid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, acId);
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
	public static BankBookPojo find(int acId)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		BankBookPojo bp=new BankBookPojo();
		try
		{
			String sql="select * from bank_book where acid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, acId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				bp.setAcId(acId);
				bp.setAccount(rs.getString(2));
				bp.setTranDate(rs.getDate(3));
				bp.setAmount(rs.getDouble(4));
				bp.setUserId(rs.getInt(5));
				bp.setOperation(rs.getString(6));
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
	public final static ArrayList<BankBookPojo> findAll()
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ArrayList<BankBookPojo> list=new ArrayList<>();
		try
		{
			String sql="select * from bank_book";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				BankBookPojo bp=new BankBookPojo();
				bp.setAcId(rs.getInt(1));
				bp.setAccount(rs.getString(2));
				bp.setTranDate(rs.getDate(3));
				bp.setAmount(rs.getDouble(4));
				bp.setUserId(rs.getInt(5));
				bp.setOperation(rs.getString(6));
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
	public static final ArrayList<BankBookPojo> findAllDateWise(String sdate,String edate,int userid)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ArrayList<BankBookPojo> list=new ArrayList<>();
		try
		{
			String sql="select * from bank_book where tran_date between ? and ? and userid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dt=df.parse(sdate);
			java.sql.Date date=new java.sql.Date(dt.getTime());
			ps.setDate(1, date);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dat=sdf.parse(edate);
			java.sql.Date sqlDate=new java.sql.Date(dat.getTime());
			ps.setDate(2,sqlDate);
			ps.setInt(3, userid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				BankBookPojo bp=new BankBookPojo();
				bp.setAcId(rs.getInt(1));
				bp.setAccount(rs.getString(2));
				bp.setTranDate(rs.getDate(3));
				bp.setAmount(rs.getDouble(4));
				bp.setUserId(rs.getInt(5));
				bp.setOperation(rs.getString(6));
				list.add(bp);
			}
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		finally
		{
			pool.putConnection(conn);
		}
		return list;
	}
	public static double closingBalance(int userid)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		double b=0;
		try
		{
			String sql="select (SELECT sum(amount) as total_payment"
					+ " FROM bank_book b where userid = ? and operation ='receive')"
					+ " - (SELECT sum(amount) as total_receivied FROM bank_book b"
					+ " where userid = ? and operation='pay')"
					+ " as 'Closing Balance' from dual";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, userid);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				b=rs.getDouble("Closing Balance");
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
		return b;
	}
	public static void main(String args[])
	{
//		java.util.Date date=new Date();
//		BankBookPojo bp=new BankBookPojo(3,"20315", date, 50000, 2, "receive");
//		BankBookDao.edit(bp);
		//BankBookDao.remove(2);
		//BankBookPojo bp=BankBookDao.find(1);
		//System.out.println(bp);
		/*ArrayList<BankBookPojo> list=BankBookDao.findAll();
		ListIterator itr=list.listIterator();
		while(itr.hasNext()) {
			
			System.out.println(itr.next());
		}*/
		/*ArrayList<BankBookPojo> list=BankBookDao.findAllDateWise("2018-03-10", "2018-03-10", 2);
		for(BankBookPojo bp:list)
		{
			System.out.println(bp);
		}*/
//		double b=BankBookDao.closingBalance(2);
//		System.out.println(b);
	}
}
