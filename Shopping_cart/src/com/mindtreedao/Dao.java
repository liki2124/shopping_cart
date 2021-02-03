package com.mindtreedao;

import com.mindtreeentity.Item;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mindtreeexception.DatabaseFailedConnection;
import com.mindtreeUtility.DaoUtil;

public class Dao {

	public static void addToDb(Item i) throws DatabaseFailedConnection, SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT into item values(?,?,?,?)";
			con = DaoUtil.createCon();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, i.getId());
			pstmt.setString(2, i.getName());
			pstmt.setDouble(3, i.getPriceperitem());
			pstmt.setInt(4, i.getQuantity());
			
			pstmt.executeUpdate();		
			con.close();
	

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DaoUtil.closeConnection(rs);
			DaoUtil.closeConnection(statement);
			DaoUtil.closeConnection(con);
		}
	}

	public static void updateToDb(int quantity, String name) throws DatabaseFailedConnection, SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			con = DaoUtil.createCon();
			statement = con.createStatement();
			String sql = "update item set quantity=" + quantity + " where name='" + name + "'";
			DaoUtil.closeConnection(rs);
			int row = statement.executeUpdate(sql);
			System.out.println("rows updated:" + row);
			rs = statement.executeQuery("select * from item");

		} finally {
			DaoUtil.closeConnection(rs);
			DaoUtil.closeConnection(statement);
			DaoUtil.closeConnection(con);
		}

	}

	public static void delete(int id) throws DatabaseFailedConnection, SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			con = DaoUtil.createCon();
			statement = con.createStatement();
			String sql = "delete from item where id=" + id;
			int row = statement.executeUpdate(sql);
			System.out.println("rows deleted:" + row);
			rs = statement.executeQuery("select * from item");

		} finally {
			DaoUtil.closeConnection(rs);
			DaoUtil.closeConnection(statement);
			DaoUtil.closeConnection(con);
		}
	}

	public static List<Item> retreive() throws DatabaseFailedConnection, SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		List<Item> s = new ArrayList<Item>();
		try {
			con = DaoUtil.createCon();
			statement = con.createStatement();
			rs = statement.executeQuery("select * from item");
			while (rs.next()) {
				s.add(new Item(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4)));

			}

		} finally {
			DaoUtil.closeConnection(rs);
			DaoUtil.closeConnection(statement);
			DaoUtil.closeConnection(con);
		}

		return s;
	}

}
