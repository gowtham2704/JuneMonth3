package com.dsrc.dao;

import java.sql.DriverManager;

import com.dsrc.bean.ChangePasswordBean;
import com.dsrc.bean.LoginBean;
import com.dsrc.bean.RegisterBean;
import com.dsrc.exceptions.LoginException;
import com.dsrc.exceptions.RegistrationException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.sun.crypto.provider.RSACipher;

public class ProfileManagementDAO {
	public boolean validateLogin(LoginBean logBean) throws LoginException
	{
		boolean result=false;
		
		// Do the logic for verifying the credentials with DB.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mvcdb", "root","dsrc");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from Registration where ID=? and Password=?");
			ps.setInt(1, logBean.getId());
			ps.setString(2, logBean.getPass());
			ResultSet rs=(ResultSet) ps.executeQuery();
			while(rs.next())
			{
				result= true;
			}
			
		}catch(Exception e){
			throw new LoginException (e.getMessage());
			}
		
		return result;
		
	}
	public boolean registerUser(RegisterBean regBean) throws RegistrationException
	{
		boolean result = false;
		// Do the logic for saving the records in database.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mvcdb", "root", "dsrc");
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into Registration values(?,?,?,?,?,?,?)");
		ps.setInt(1, regBean.getID());
		ps.setString(2, regBean.getName());
		ps.setInt(3, regBean.getAge());
		ps.setString(4, regBean.getGender());
		ps.setString(5, regBean.getContactNumber());
		ps.setString(6, regBean.getPassword());
		ps.setString(7, regBean.getEmail());
		
		
		int res=ps.executeUpdate();
		if(res>0)
		{
			result = true;
		}
	}
	catch(Exception e)
		{
		throw new RegistrationException(e.getMessage());
		}
		
		return result;
		
	}
	public RegisterBean viewProfile(String loginname)
	{
		
		//Do the logic for return the bean filled with the details of the logged in user.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		return null;
		
	}
	
	public boolean editUser(RegisterBean regBean)
	{
		
		// Do the logic for modifying the records in database.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		
		return false;
		
	}
	public boolean changePassword(ChangePasswordBean cBean)
	{
		boolean result=false;
		// Do the logic for  modifying the records in database.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mvcdb", "root", "dsrc");
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from Registration where password='"+oldpass+"'");
		while(rs.next()){
			id=rs.getInt(1);
		}
		
	}
	
}
