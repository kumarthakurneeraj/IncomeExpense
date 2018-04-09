package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pojos.ExpensesPojo;
import utilities.ConnectionPool;

public class ExpensesDao {
	public static void create(ExpensesPojo bp)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="insert into expenses( exp_ac, userid, exp_catid, amount, tran_date, payby, remark) values(?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bp.getExpAc());
			ps.setInt(2, bp.getUserId());
			ps.setInt(3, bp.getExpCatId());
			ps.setDouble(4, bp.getAmount());
			java.sql.Date date=new java.sql.Date(bp.getTranDate().getTime());
			ps.setDate(5, date);
			ps.setString(6, bp.getPayBy());
			ps.setString(7, bp.getRemark());
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
	public static void edit(ExpensesPojo bp)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="update expenses set exp_ac=?,userid=?,exp_catid=?, amount=?, tran_date=?, payby=?, remark=? where exp_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bp.getExpAc());
			ps.setInt(2, bp.getUserId());
			ps.setInt(3, bp.getExpId());
			ps.setDouble(4, bp.getAmount());
			java.sql.Date date=new java.sql.Date(bp.getTranDate().getTime());
			ps.setDate(5, date);
			ps.setString(6, bp.getPayBy());
			ps.setString(7, bp.getRemark());
			ps.setInt(8, bp.getExpId());
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
	public static void remove(int expCatId)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try {
		String sql="delete from expenses_category where exp_catid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, expCatId);
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
	public static ExpensesPojo find(int expId)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ExpensesPojo bp=new ExpensesPojo();
		try
		{
			String sql="select * from expenses where exp_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, expId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				bp.setExpId(rs.getInt(1));
				bp.setExpAc(rs.getString(2));
				bp.setUserId(rs.getInt(3));
				bp.setExpCatId(rs.getInt(4));
				bp.setAmount(rs.getDouble(5));
				bp.setTranDate(rs.getDate(6));
				bp.setPayBy(rs.getString(7));
				bp.setRemark(rs.getString(8));
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
	public final static ArrayList<ExpensesPojo> findAll()
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ArrayList<ExpensesPojo> list=new ArrayList<>();
		try
		{
			
			String sql="select * from expenses";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ExpensesPojo bp=new ExpensesPojo();
				bp.setExpId(rs.getInt(1));
				bp.setExpAc(rs.getString(2));
				bp.setUserId(rs.getInt(3));
				bp.setExpCatId(rs.getInt(4));
				bp.setAmount(rs.getDouble(5));
				bp.setTranDate(rs.getDate(6));
				bp.setPayBy(rs.getString(7));
				bp.setRemark(rs.getString(8));
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
	public static ArrayList<ExpensesPojo> findAll(int userid) 
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ArrayList<ExpensesPojo> list=new ArrayList<>();
		try
		{
			String sql="select * from expenses where userid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ExpensesPojo bp=new ExpensesPojo();
				bp.setExpId(rs.getInt(1));
				bp.setExpAc(rs.getString(2));
				bp.setUserId(rs.getInt(3));
				bp.setExpCatId(rs.getInt(4));
				bp.setAmount(rs.getDouble(5));
				bp.setTranDate(rs.getDate(6));
				bp.setPayBy(rs.getString(7));
				bp.setRemark(rs.getString(8));
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
	public static final ArrayList<ExpensesPojo> findAllDateWise(String sdate,String edate,int userid)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ArrayList<ExpensesPojo> list=new ArrayList<>();
		try
		{
			String sql="select * from expenses where tran_date between ? and ? and userid=?";
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
				ExpensesPojo bp=new ExpensesPojo();
				bp.setExpId(rs.getInt(1));
				bp.setExpAc(rs.getString(2));
				bp.setUserId(rs.getInt(3));
				bp.setExpCatId(rs.getInt(4));
				bp.setAmount(rs.getDouble(5));
				bp.setTranDate(rs.getDate(6));
				bp.setPayBy(rs.getString(7));
				bp.setRemark(rs.getString(8));
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
	public static void main(String []args)
	{
		//java.util.Date date=new java.util.Date();
		//ExpensesPojo p=new ExpensesPojo("20415", 2, 1, 16000, date, "Abhijeet", "This product is nice");
		//ExpensesDao.create(p);
		//ExpensesDao.edit(p);
		//ExpensesDao.remove(1);
		//ExpensesPojo p=ExpensesDao.find(1);
		//System.out.println(p);
//		ArrayList<ExpensesPojo> list=ExpensesDao.findAll();
//		for(ExpensesPojo p:list)
//			System.out.println(p);
	}
}
