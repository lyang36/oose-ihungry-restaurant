package edu.jhu.cs.oose.group14.restaurant.modelimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import edu.jhu.cs.oose.fall2012.group14.ihungry.internet.CommunicationProtocol;
import edu.jhu.cs.oose.group14.restaurant.gui.IhungryRestaurantGui;

public class IhungryRestaurantControl {
	
    private IhungryRestaurantGui gui;
	
    /*
     * Constructor takes a gui parameter and adds listeners to login and signup buttons
     */
    
	public IhungryRestaurantControl(IhungryRestaurantGui gui){	
		this.gui = gui;
		gui.getLoginButton().addActionListener(new loginActionListener());
		gui.getSignupButton().addActionListener(new signupActionListener());
	}
	
	/*
	 * Inner class implementing the actionPerformed method for the login button
	 */
	
	public class loginActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
            gui.loginGui();
            gui.getLoginButton1().addActionListener(new login1ActionListener());
       }

	}
	
	/*
	 * Inner class implementing the actionPerformed method for the signup button
	 */
	public class signupActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) { 
			gui.signupGui();
			gui.getSignupButton1().addActionListener(new signup1ActionListener());
			         
       }

	}
	
	/*
	 * Inner class implementing the actionPerformed method for the login1 button
	 */
	public class login1ActionListener implements ActionListener{
		
		JTextField unameLogin;
		JPasswordField pwdLogin;
		JButton loginButton1;
		
		
		public boolean checkForEmptyFields(){
			
			if(unameLogin.getText().equals("") || new String(pwdLogin.getPassword()).equals("")){
				
				loginButton1.setEnabled(false);
				JLabel errorFields = new JLabel("<HTML><FONT COLOR = Blue>You must enter a username and password to login.</FONT></HTML>");	
				JOptionPane.showMessageDialog(null,errorFields);
				loginButton1.setEnabled(true);
				unameLogin.setText("");
				unameLogin.requestFocus();
				pwdLogin.setText("");
				
				return false;
			}
			else
				return true;	
		}
		
		
		public void sendDetails(){
			
			LoginHandler loginHandle = new LoginHandler(unameLogin.getText(),new String(pwdLogin.getPassword()));
			String result = loginHandle.attemptLogin();
			
			if (result==CommunicationProtocol.LOGIN_SUCCESS)
			{
				gui.orderGui();
				System.out.println("successLogin");
			}
			
			else if (result==CommunicationProtocol.LOGIN_ERROR)
			{
				
				loginButton1.setEnabled(false);
				JLabel errorFields = new JLabel("<HTML><FONT COLOR = Blue>Username or password you entered is incorrect.</FONT></HTML>");	
				JOptionPane.showMessageDialog(null,errorFields);
				loginButton1.setEnabled(true);
				pwdLogin.setText("");
				pwdLogin.requestFocus();
			}
			
		}
		
		
		public void actionPerformed(ActionEvent event) {
			
			unameLogin = gui.getUnameLogin();
			pwdLogin = gui.getPwdLogin();
			loginButton1 = gui.getLoginButton1();
			
			//System.out.println(unameLogin.getText() + pwdLogin.getPassword());
			
			if (checkForEmptyFields()==true)
			{	
				sendDetails();
			}
            
		}

	}
	
	/*
	 * Inner class implementing the actionPerformed method for the signup1 button
	 */
	public class signup1ActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			 
			gui.uploadMenuGui();
			gui.getVbar().addAdjustmentListener(new vbarAdjustmentListener());
			         
      }

	}
	
	/*
	 * Inner class implementing the actionPerformed method for the vbar scrollbar
	 */
	public class vbarAdjustmentListener implements AdjustmentListener{
		
		 public void adjustmentValueChanged(AdjustmentEvent e) {
			 	System.out.println("Adjusted: " + e.getValue());
		    }

	}
	
}
