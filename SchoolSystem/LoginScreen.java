 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginScreen {
    private StudentApp studentApp;
    private JFrame frmLoginScreen;
    private JPasswordField passwordField;
    private JTextField textField;
    
    public LoginScreen(StudentApp studentApp) {
    	this.studentApp = studentApp;
    	this.frmLoginScreen = new JFrame();
    	frmLoginScreen.setAlwaysOnTop(true);
    	frmLoginScreen.setSize(386, 300);
    	frmLoginScreen.setTitle("Login Screen");
    	frmLoginScreen.getContentPane().setLayout(null);
    	
    	passwordField = new JPasswordField();
    	passwordField.setBounds(139, 117, 137, 33);
    	frmLoginScreen.getContentPane().add(passwordField);
    	
    	textField = new JTextField();
    	textField.setBounds(139, 74, 137, 33);
    	frmLoginScreen.getContentPane().add(textField);
    	textField.setColumns(10);
    	
    	JLabel lblNewLabel = new JLabel("email:");
    	lblNewLabel.setBounds(84, 84, 45, 13);
    	frmLoginScreen.getContentPane().add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("password:");
    	lblNewLabel_1.setBounds(79, 127, 65, 13);
    	frmLoginScreen.getContentPane().add(lblNewLabel_1);
    	
    	JLabel lblNewLabel_2 = new JLabel("Login");
    	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
    	lblNewLabel_2.setBounds(171, 22, 81, 41);
    	frmLoginScreen.getContentPane().add(lblNewLabel_2);
    	
    	JButton btnNewButton = new JButton("Login");
    	btnNewButton.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			String password = new String(passwordField.getPassword());
    			String email = textField.getText();
    			System.out.println(email);
    			System.out.println(password);
    			Student s = studentApp.loginStudent(email, password);
    			if (s != null) {
    				System.out.println("Successfully Logged in!");
    				JOptionPane.showMessageDialog(frmLoginScreen, "Successfully Logged in!");
    				UserScreen userScreen = new UserScreen(studentApp, s);
    			} else {
    				System.out.println("User was not found!");
    				JOptionPane.showMessageDialog(frmLoginScreen, "User was not found!");
    			}
    		}
    	});
    	btnNewButton.setBounds(157, 173, 85, 21);
    	frmLoginScreen.getContentPane().add(btnNewButton);
    	frmLoginScreen.setVisible(true);
    }
    
}