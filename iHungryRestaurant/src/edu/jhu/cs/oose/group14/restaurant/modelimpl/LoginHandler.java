package edu.jhu.cs.oose.group14.restaurant.modelimpl;

import java.security.MessageDigest;

import edu.jhu.cs.oose.fall2012.group14.ihungry.internet.*;
import java.security.MessageDigest;
import java.math.BigInteger;


public class LoginHandler {
	
	private String username;
	private String password;
	private MessageDigest md;
	private InternetUtilImpl internet;
	//Person r;
	
	public LoginHandler(String uname, String pwd){
		
		username = uname;
		password = pwd;
		try{
			md = MessageDigest.getInstance("MD5");
		}
		catch(Exception e){
			System.out.println("An exception occured");
		}
		internet = new InternetUtilImpl();
	}
	
	
	public String attemptLogin(){
		
		String result ="";
		
		md.update(username.getBytes());
		String usernamemd5 = new BigInteger(1,md.digest()).toString(16);
		md.update(password.getBytes());
		String passwordmd5 = new BigInteger(1,md.digest()).toString(16);
		String cmdString = usernamemd5 + passwordmd5 + CommunicationProtocol.LOGIN;
		//System.out.println(cmdString);
		String supplyInfo = "{usernamemd5:" + usernamemd5 + ";" +
						    "username:" + username + ";" +
						    "password:" + password + ";}";
		String message = CommunicationProtocol.packMsg(CommunicationProtocol.packStr(cmdString,supplyInfo));
		System.out.println(message);
		try{
			internet.sendMsg(message);
			result = internet.receiveMessage();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
		}
		
		return result;
	}

}
