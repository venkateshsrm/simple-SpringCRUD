package com.venkat.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.venkat.model.Users;

public class UserDAOImpl implements UserDAO {

	private DataSource dataSource;

	public UserDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Users> listUsers() {

		String sql = "select * from testuser";
		Connection conn = null;
		List<Users> listUsers = new ArrayList<Users>();
		try {
			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Users users = new Users(rs.getInt("sno"), rs.getString("name"), rs.getString("email"),
							rs.getString("designation"));
					listUsers.add(users);
				}
				rs.close();
				ps.close();
				return listUsers;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return listUsers;
	}

	public Users addUser(Users user) {
		String insert = "insert into testuser (name,email,designation) values (?,?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getDesignation());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return user;
	}

	public Users updateUser(Users user) {

		String update = "update testuser set name=?, email=?,designation=? where sno=?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getDesignation());
			ps.setInt(4, user.getSno());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	public int deleteUser(int userid) {

		String update = "delete from testuser where sno=?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setInt(1, userid);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return userid;
	}

}
