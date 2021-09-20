package com.nehal;

import java.util.ResourceBundle;

public class App1 {
	public int userLogin(String user1,String pwd1)
	{
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String username = rb.getString("username");
		String password = rb.getString("password");
		if(user1.equals(username) && pwd1.equals(password))
			return 1;
		else
			return 0;
	}

}
