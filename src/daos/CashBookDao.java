package daos;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pojos.CashBookPojo;
import utilities.ConnectionPool;
public class CashBookDao {
	public static void create(CashBookPojo p)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="insert into cash_book(account,tran_date,amount,userid,operation) values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, p.getAccount());
			java.sql.Date date=new java.sql.Date(p.getTranDate().getTime());
			ps.setDate(2, date);
			ps.setDouble(3, p.getAmount());
			ps.setInt(4, p.getUserId());
			ps.setString(5, p.getOperation());
			int result=ps.executeUpdate();
			if(result!=0)
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
	public static final ArrayList<CashBookPojo> findAllDateWise(String sdate,String edate,int userid)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ArrayList<CashBookPojo> list=new ArrayList<>();
		try
		{
			String sql="select * from cash_book where tran_date between ? and ? and userid=?";
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
				CashBookPojo p=new CashBookPojo();
				p.setAcId(rs.getInt(1));
				p.setAccount(rs.getString(2));
				p.setTranDate(rs.getDate(3));
				p.setAmount(rs.getDouble(4));
				p.setUserId(rs.getInt(5));
				p.setOperation(rs.getString(6));
				list.add(p);
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
					+ " FROM cash_book b where userid = ? and operation ='receive')"
					+ " - (SELECT sum(amount) as total_receivied FROM cash_book b"
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
	public static void edit(CashBookPojo p)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="update cash_book set account=?, tran_date=? ,amount=? ,userid=? ,operation=?"
					+ "where acid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, p.getAccount());
			java.sql.Date date=new java.sql.Date(p.getTranDate().getTime());
			ps.setDate(2, date);
			ps.setDouble(3, p.getAmount());
			ps.setInt(4, p.getUserId());
			ps.setString(5, p.getOperation());
			ps.setInt(6, p.getAcId());
			int result=ps.executeUpdate();
			if(result!=0)
				System.out.println("Row updated successfully");
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
	public static void remove(int acId) {
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="delete from cash_book where acid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, acId);
			int result=ps.executeUpdate();
			if(result!=0)
				System.out.println("Row deleted successfully");
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
	public static CashBookPojo find(int acId)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		CashBookPojo p=new CashBookPojo();
		try
		{
			String sql="select * from cash_book where acid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, acId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				p.setAcId(rs.getInt(1));
				p.setAccount(rs.getString(2));
				p.setTranDate(rs.getDate(3));
				p.setAmount(rs.getDouble(4));
				p.setUserId(rs.getInt(5));
				p.setOperation(rs.getString(6));
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
		return p;
	}
	public static ArrayList<CashBookPojo> findAll()
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ArrayList<CashBookPojo> list=new ArrayList<>();
		try
		{
			String sql="select * from cash_book";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				CashBookPojo p=new CashBookPojo();
				p.setAcId(rs.getInt(1));
				p.setAccount(rs.getString(2));
				p.setTranDate(rs.getDate(3));
				p.setAmount(rs.getDouble(4));
				p.setUserId(rs.getInt(5));
				p.setOperation(rs.getString(6));
				list.add(p);
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
	public static void main(String []args)
	{
//		java.util.Date date=new java.util.Date();
//		CashBookPojo p=new CashBookPojo(2,"20315", date, 500, 2, "pay");
//	CashBookDao.create(p);
//		CashBookDao.edit(p);
		//CashBookDao.remove(1);
		//CashBookPojo p=CashBookDao.find(1);
		//System.out.println(p);
	/*ArrayList<CashBookPojo> list=CashBookDao.findAllDateWise("2018-03-11", "2018-03-11", 2);
		for(CashBookPojo p:list)
			System.out.println(p);*/
//		double b=CashBookDao.closingBalance(2);
//		System.out.println(b);
		
	}
}
