package com.venkat.DAO;

import java.util.List;

import com.venkat.model.Users;

public interface UserDAO {

	public List<Users> listUsers();

	public Users addUser(Users user);

	public Users updateUser(Users user);

	public int deleteUser(int userid);

}
