package com.dsrc.bo;

import com.dsrc.bean.ChangePasswordBean;
import com.dsrc.bean.LoginBean;
import com.dsrc.bean.RegisterBean;
import com.dsrc.dao.ProfileManagementDAO;
import com.dsrc.exceptions.LoginBusinessException;
import com.dsrc.exceptions.LoginException;
import com.dsrc.exceptions.RegistrationBusinessException;
import com.dsrc.exceptions.RegistrationException;

public class ProfileManagementBO 
{
	public boolean validateLogin(LoginBean logBean) throws LoginBusinessException, LoginException, RegistrationException
	{
		// Do the logic for data validations and after  successful validation call the DAO methods for verifying the credentials with DB.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		 if(logBean.getId()==0 || logBean.getPass()==null)
		 {
			throw new LoginBusinessException("fields are empty");
		}
		return new ProfileManagementDAO().validateLogin(logBean);
		
	}
	public boolean registerUser(RegisterBean regBean) throws RegistrationBusinessException, RegistrationException
	{
		
		// Do the logic for data entry validations and after successful validation call the DAO -> registerUser method for saving the records in database.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		if(regBean.getAge()<18)
		{
			throw new RegistrationBusinessException("Invalid Age");
		}
		return new ProfileManagementDAO().registerUser(regBean);
		
	}
	public RegisterBean viewProfile(String loginname)
	{
		
		//Do the logic for calling the DAO -> viewProfile method and return the bean filled with the details of the loginname passed as argument.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		return null;
		
	}
	
	public boolean editUser(RegisterBean regBean)
	{
		
		// Do the logic for data entry validations and after successful validation call the DAO -> editUser method for modifying the records in database.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		
		return false;
		
	}
	public boolean changePassword(ChangePasswordBean cBean)
	{
		
		// Do the logic for data entry validations and after successful validation call the DAO -> changePassword method for modifying the records in database.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		
		return false;
		
	}
	
	
}
