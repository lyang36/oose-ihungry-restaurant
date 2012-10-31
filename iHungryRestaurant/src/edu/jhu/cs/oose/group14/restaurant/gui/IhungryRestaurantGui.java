package edu.jhu.cs.oose.group14.restaurant.gui;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import edu.jhu.cs.oose.fall2012.group14.ihungry.internet.CommunicationProtocol;
import edu.jhu.cs.oose.group14.restaurant.gui.*;
import edu.jhu.cs.oose.group14.restaurant.modelimpl.IhungryRestaurantControl;

public class IhungryRestaurantGui extends JFrame {
	private JPanel panel,panel1, panel2,uploadPanel;
	private JButton loginButton,signupButton;
	private JButton loginButton1,signupButton1;
	private JTextField unameLogin;
	private JPasswordField pwdLogin;
	private JTextField fname, lname, username;
	private JTextField birthday, birthyear, gender, phone, email, location;
	private JComboBox birthmonth;
	private JPasswordField password,confirmPassword;
	private JScrollBar vbar;
	
	
	public IhungryRestaurantGui(){
		initUI();
	}
	
	public final void initUI(){
		
		setTitle("iHungry Restaurant");
		setSize(1000,800);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    loginButton = new JButton("Login");
	    signupButton = new JButton("Signup");
	    loginButton.setBounds(450, 300, 100, 40);
	    signupButton.setBounds(600, 300, 100, 40);
	    panel = new JPanel();
	    panel.setLayout(null);
	    panel.add(loginButton);
	    panel.add(signupButton);
	    getContentPane().add(panel);
	    setVisible(true);
	           
	}
	
	public JButton getLoginButton(){
		return loginButton;
	}
	
	public JButton getSignupButton(){
		return signupButton;
	}
	
	
	public void loginGui(){
		
		panel.setVisible(false);
		JLabel uname = new JLabel("Username:");
		uname.setBounds(100,30,100,30);
		uname.setForeground(new Color(0,0,255));
		unameLogin = new JTextField();
		unameLogin.setBounds(225,30,200,30);
		JLabel pwd = new JLabel("Password:");
		pwd.setBounds(100,70,100,30);
		pwd.setForeground(new Color(0,0,255));
		pwdLogin = new JPasswordField();
		pwdLogin.setBounds(225,70,200,30);
		loginButton1 = new JButton("Login");
		loginButton1.setBounds(150,115,100,30);
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.add(uname);
		panel1.add(unameLogin);
		panel1.add(pwd);
		panel1.add(pwdLogin);
		panel1.add(loginButton1);
		getContentPane().add(panel1);
		unameLogin.requestFocus();
		//panel1.setVisible(true);	
		
	}
	
	public JTextField getUnameLogin(){
		return unameLogin;
	}
	
	public JPasswordField getPwdLogin(){
		return pwdLogin;
	}
	
	public JButton getLoginButton1(){
		return loginButton1;
	}
	
	
	public void signupGui(){
		
		String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				          "Aug", "Sep", "Oct", "Nov", "Dec"};
			
		panel.setVisible(false);
		JLabel name_su = new JLabel("Name");
		name_su.setBounds(100,30,100,30);
		name_su.setForeground(new Color(0,0,255));
		fname = new JTextField();
		fname.setBounds(100,65,200,30);
		lname = new JTextField();
		lname.setBounds(325,65,200,30);
		JLabel username_su = new JLabel("Username");
		username_su.setBounds(100,100,100,30);
		username_su.setForeground(new Color(0,0,255));
		username = new JTextField();
		username.setBounds(100,135,250,30);
		JLabel pwd = new JLabel("Password");
		pwd.setBounds(100,170,100,30);
		pwd.setForeground(new Color(0,0,255));
		password = new JPasswordField();
		password.setBounds(100,205,100,30);
		JLabel cnfmpwd = new JLabel(" Confirm Password");
		cnfmpwd.setBounds(100,240,250,30);
		cnfmpwd.setForeground(new Color(0,0,255));
		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(100,275,100,30);
		JLabel birthday_su = new JLabel(" Birthday");
		birthday_su.setBounds(100,310,100,30);
		birthday_su.setForeground(new Color(0,0,255));
		birthmonth = new JComboBox(month);
		birthmonth.setBounds(100,345,100,30);
		birthday = new JTextField();
		birthday.setBounds(225,345,100,30);
		birthyear = new JTextField();
		birthyear.setBounds(350,345,100,30);
		JLabel gender_su = new JLabel("Gender");
		gender_su.setBounds(100,380,100,30);
		gender_su.setForeground(new Color(0,0,255));
		gender = new JTextField();
		gender.setBounds(100,415,100,30);
		JLabel phone_su = new JLabel("Phone");
		phone_su.setBounds(100,450,100,30);
		phone_su.setForeground(new Color(0,0,255));
		phone = new JTextField();
		phone.setBounds(100,485,100,30);
		JLabel email_su = new JLabel("Email");
		email_su.setBounds(100,520,100,30);
		email_su.setForeground(new Color(0,0,255));
		email = new JTextField();
		email.setBounds(100,555,100,30);
		signupButton1 = new JButton("Signup");
		signupButton1.setBounds(150,610,100,30);
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.add(name_su);
		panel2.add(username_su);
		panel2.add(fname);
		panel2.add(lname);
		panel2.add(username);
		panel2.add(pwd);
		panel2.add(password);
		panel2.add(cnfmpwd);
		panel2.add(confirmPassword);
		panel2.add(birthday_su);
		panel2.add(birthmonth);
		panel2.add(birthday);
		panel2.add(birthyear);
		panel2.add(gender_su);
		panel2.add(gender);
		panel2.add(phone_su);
		panel2.add(phone);
		panel2.add(email_su);
		panel2.add(email);
		panel2.add(signupButton1);
		getContentPane().add(panel2);
		panel2.setBorder(BorderFactory.createTitledBorder("Signup"));
		fname.requestFocus();
		//panel1.setVisible(true);	
		
	}
	
	public JTextField getFnameSignup(){
		return fname;
	}
	
	public JTextField getLnameSignup(){
		return lname;
	}
	
	public JTextField getUsernameSignup(){
		return username;
	}
	
	public JPasswordField getPwdSignup(){
		return password;
	}
	
	public JPasswordField getCnfmPwdSignup(){
		return confirmPassword;
	}
	
	public JTextField getBirthdaySignup(){
		return birthday;
	}
	
	public JTextField getBirthyearSignup(){
		return birthyear;
	}
	
	public JTextField getGenderSignup(){
		return gender;
	}
	
	public JTextField getPhoneSignup(){
		return phone;
	}
	
	public JTextField getEmailSignup(){
		return email;
	}
	
	public JButton getSignupButton1(){
		return signupButton1;
	}
	
	public void uploadMenuGui(){
		panel2.setVisible(false);
		uploadPanel = new JPanel();
		vbar = new JScrollBar(JScrollBar.VERTICAL);
		vbar.setPreferredSize(new Dimension(20,200));
		//vbar.setBounds(970,0,20,780);
		uploadPanel.setBorder(BorderFactory.createTitledBorder("Create Menu"));
		uploadPanel.add(vbar,BorderLayout.EAST);
		uploadPanel.setVisible(true);
		getContentPane().add(uploadPanel);
		
	}
	
	public JScrollBar getVbar(){
		return vbar;
	}
	
	public void orderGui(){
		
	}
	
	/*public class loginActionListener1 implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			String username = new String(unametf.getText());
			String password = new String(pwdpf.getPassword());
			
			if(username.equals("") || password.equals("")){
				login.setEnabled(false);
				JLabel errorFields = new JLabel("<HTML><FONT COLOR = Blue>You must enter a username and password to login.</FONT></HTML>");	
				JOptionPane.showMessageDialog(null,errorFields);
				login.setEnabled(true);
			}
			else{
				
				md.update(username.getBytes());
				String usernamemd5 = new BigInteger(1,md.digest()).toString(16);
				//System.out.println(usernamemd5);
				md.update(password.getBytes());
				String passwordmd5 = new BigInteger(1,md.digest()).toString(16);
				//System.out.println(passwordmd5);
				String cmdString = usernamemd5+passwordmd5+CommunicationProtocol.logIn;
				//System.out.println(cmdString);
				String supplyInfo = "usernamemd5:"+ usernamemd5 + ";" +
								    "username:" + username + ";" +
								    "password:" + password + ";";
				String message = CommunicationProtocol.packMsg(CommunicationProtocol.packStr(cmdString,supplyInfo));
				System.out.println(message);
								    
			}
				
       }
		
	}*/
	

	public static void main(String args[]){
		IhungryRestaurantGui gui = new IhungryRestaurantGui();
		IhungryRestaurantControl control = new IhungryRestaurantControl(gui);  
		
	}
}
