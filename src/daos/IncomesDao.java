package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import pojos.ExpensesPojo;
import pojos.IncomesPojo;
import utilities.ConnectionPool;

public class IncomesDao {
	public static void create(IncomesPojo bp)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="insert into incomes( inc_ac, userid, inc_catid, amount, tran_date, receiveby, remark) values(?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bp.getIncAc());
			ps.setInt(2, bp.getUserId());
			ps.setInt(3, bp.getIncCatid());
			ps.setDouble(4, bp.getAmount());
			java.sql.Date date=new java.sql.Date(bp.getTranDate().getTime());
			ps.setDate(5, date);
			ps.setString(6, bp.getReceiveBy());
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
	public static void edit(IncomesPojo bp)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="update incomes set inc_ac=?,userid=?,inc_catid=?, amount=?, tran_date=?, receiveby=?, remark=? where inc_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bp.getIncAc());
			ps.setInt(2, bp.getUserId());
			ps.setInt(3, bp.getIncId());
			ps.setDouble(4, bp.getAmount());
			java.sql.Date date=new java.sql.Date(bp.getTranDate().getTime());
			ps.setDate(5, date);
			ps.setString(6, bp.getReceiveBy());
			ps.setString(7, bp.getRemark());
			ps.setInt(8, bp.getIncId());
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
	public static void remove(int incCatId)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try {
		String sql="delete from incomes_category where inc_catid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, incCatId);
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
	public static IncomesPojo find(int incId)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		IncomesPojo bp=new IncomesPojo();
		try
		{
			String sql="select * from incomes where inc_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, incId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				bp.setIncId(rs.getInt(1));
				bp.setIncAc(rs.getString(2));
				bp.setUserId(rs.getInt(3));
				bp.setIncCatid(rs.getInt(4));
				bp.setAmount(rs.getDouble(5));
				bp.setTranDate(rs.getDate(6));
				bp.setReceiveBy(rs.getString(7));
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
	public final static ArrayList<IncomesPojo> findAll()
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ArrayList<IncomesPojo> list=new ArrayList<>();
		try
		{
			
			String sql="select * from incomes";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				IncomesPojo bp=new IncomesPojo();
				bp.setIncId(rs.getInt(1));
				bp.setIncAc(rs.getString(2));
				bp.setUserId(rs.getInt(3));
				bp.setIncCatid(rs.getInt(4));
				bp.setAmount(rs.getDouble(5));
				bp.setTranDate(rs.getDate(6));
				bp.setReceiveBy(rs.getString(7));
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
	public static final ArrayList<IncomesPojo> findAllDateWise(String sdate,String edate,int userid)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ArrayList<IncomesPojo> list=new ArrayList<>();
		try
		{
			String sql="select * from incomes where tran_date between ? and ? and userid=?";
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
				IncomesPojo bp=new IncomesPojo();
				bp.setIncId(rs.getInt(1));
				bp.setIncAc(rs.getString(2));
				bp.setUserId(rs.getInt(3));
				bp.setIncCatid(rs.getInt(4));
				bp.setAmount(rs.getDouble(5));
				bp.setTranDate(rs.getDate(6));
				bp.setReceiveBy(rs.getString(7));
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
}
