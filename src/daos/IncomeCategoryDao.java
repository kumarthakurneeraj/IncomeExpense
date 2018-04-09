package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojos.IncomeCategoryPojo;
import utilities.ConnectionPool;

public class IncomeCategoryDao {
	public static void create(IncomeCategoryPojo bp)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="insert into income_category(inc_catname,inc_catdetails,userid) values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bp.getIncCatName());
			ps.setString(2, bp.getIncCatDetails());
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
	public static void edit(IncomeCategoryPojo bp)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		try
		{
			String sql="update income_category set inc_catname=?,inc_catdetails=?,userid=? where inc_catid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bp.getIncCatName());
			ps.setString(2, bp.getIncCatDetails());
			ps.setInt(3, bp.getUserId());
			ps.setInt(4, bp.getIncCatId());
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
		String sql="delete from income_category where inc_catid=?";
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
	public static IncomeCategoryPojo find(int incCatId)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		IncomeCategoryPojo bp=new IncomeCategoryPojo();
		try
		{
			String sql="select * from income_category where inc_catid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, incCatId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				bp.setIncCatId(rs.getInt(1));
				bp.setIncCatName(rs.getString(2));
				bp.setIncCatDetails(rs.getString(3));
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
	public final static ArrayList<IncomeCategoryPojo> findAll()
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		pool.initialize();
		Connection conn=pool.getConnection();
		ArrayList<IncomeCategoryPojo> list=new ArrayList<>();
		try
		{
			
			String sql="select * from income_category";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				IncomeCategoryPojo bp=new IncomeCategoryPojo();
				bp.setIncCatId(rs.getInt(1));
				bp.setIncCatName(rs.getString(2));
				bp.setIncCatDetails(rs.getString(3));
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
}
