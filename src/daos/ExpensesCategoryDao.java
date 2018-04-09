package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojos.ExpensesCategoryPojo;
import utilities.ConnectionPool;

public class ExpensesCategoryDao {
	public static void create(ExpensesCategoryPojo bp)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="insert into expenses_category(exp_catname,exp_catdetails,userid) values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bp.getExpCatName());
			ps.setString(2, bp.getExpCatDetails());
			ps.setInt(3, bp.getUserId());
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
	public static void edit(ExpensesCategoryPojo bp)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="update expenses_category set exp_catname=?,exp_catdetails=?,userid=? where exp_catid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bp.getExpCatName());
			ps.setString(2, bp.getExpCatDetails());
			ps.setInt(3, bp.getUserId());
			ps.setInt(4, bp.getExpCatId());
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
	public static ExpensesCategoryPojo find(int expCatId)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ExpensesCategoryPojo bp=new ExpensesCategoryPojo();
		try
		{
			String sql="select * from expenses_category where exp_catid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, expCatId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				bp.setExpCatId(rs.getInt(1));
				bp.setExpCatName(rs.getString(2));
				bp.setExpCatDetails(rs.getString(3));
				bp.setUserId(rs.getInt(4));
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
	public final static ArrayList<ExpensesCategoryPojo> findAll()
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ArrayList<ExpensesCategoryPojo> list=new ArrayList<>();
		try
		{
			
			String sql="select * from expenses_category";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ExpensesCategoryPojo bp=new ExpensesCategoryPojo();
				bp.setExpCatId(rs.getInt(1));
				bp.setExpCatName(rs.getString(2));
				bp.setExpCatDetails(rs.getString(3));
				bp.setUserId(rs.getInt(4));
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
	public static ArrayList<ExpensesCategoryPojo> findAll(int userid) 
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ArrayList<ExpensesCategoryPojo> list=new ArrayList<>();
		try
		{
			String sql="select * from expenses_category where userid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ExpensesCategoryPojo bp=new ExpensesCategoryPojo();
				bp.setExpCatId(rs.getInt(1));
				bp.setExpCatName(rs.getString(2));
				bp.setExpCatDetails(rs.getString(3));
				bp.setUserId(rs.getInt(4));
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
	public static void main(String []a)
	{
//		ArrayList<ExpensesCategoryPojo> list=ExpensesCategoryDao.findAll(2);
//		for(ExpensesCategoryPojo p:list)
//			System.out.println(p);
//		ExpensesCategoryPojo bp=new ExpensesCategoryPojo("Clothes","Shirts",2);
//		ExpensesCategoryDao.create(bp);
	}
}
