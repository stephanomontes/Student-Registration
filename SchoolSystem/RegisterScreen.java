 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterScreen {
    private StudentApp studentApp;
    private JFrame frmRegisterScreen;
    private JPasswordField passwordField;
    private JTextField textField;
    private JTextField emailfield;
    private JPasswordField passwordfield;
    private JTextField firstnamefield;
    private JTextField lastnamefield;
    private JTextField addressfield;
    private JTextField dateofbirthfield;
    private JTextField phonenumberfield;
    
    public RegisterScreen(StudentApp studentApp) {
    	this.studentApp = studentApp;
    	frmRegisterScreen = new JFrame();
    	frmRegisterScreen.setResizable(false);
    	frmRegisterScreen.setAlwaysOnTop(true);
    	frmRegisterScreen.getContentPane().setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("email");
    	lblNewLabel.setBounds(64, 53, 71, 13);
    	frmRegisterScreen.getContentPane().add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("password");
    	lblNewLabel_1.setBounds(64, 76, 71, 13);
    	frmRegisterScreen.getContentPane().add(lblNewLabel_1);
    	
    	JLabel lblNewLabel_2 = new JLabel("First Name");
    	lblNewLabel_2.setBounds(64, 99, 71, 13);
    	frmRegisterScreen.getContentPane().add(lblNewLabel_2);
    	
    	JLabel lblNewLabel_3 = new JLabel("Last Name");
    	lblNewLabel_3.setBounds(64, 122, 71, 13);
    	frmRegisterScreen.getContentPane().add(lblNewLabel_3);
    	
    	JLabel lblNewLabel_4 = new JLabel("address");
    	lblNewLabel_4.setBounds(64, 145, 71, 13);
    	frmRegisterScreen.getContentPane().add(lblNewLabel_4);
    	
    	JLabel lblNewLabel_5 = new JLabel("date of birth");
    	lblNewLabel_5.setBounds(64, 173, 71, 13);
    	frmRegisterScreen.getContentPane().add(lblNewLabel_5);
    	
    	JLabel lblNewLabel_6 = new JLabel("phone number");
    	lblNewLabel_6.setBounds(64, 196, 71, 13);
    	frmRegisterScreen.getContentPane().add(lblNewLabel_6);
    	
    	JLabel lblNewLabel_7 = new JLabel("Register");
    	lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 24));
    	lblNewLabel_7.setBounds(155, 10, 112, 29);
    	frmRegisterScreen.getContentPane().add(lblNewLabel_7);
    	
    	emailfield = new JTextField();
    	emailfield.setBounds(160, 50, 96, 19);
    	frmRegisterScreen.getContentPane().add(emailfield);
    	emailfield.setColumns(10);
    	
    	passwordfield = new JPasswordField();
    	passwordfield.setBounds(160, 73, 96, 19);
    	frmRegisterScreen.getContentPane().add(passwordfield);
    	
    	firstnamefield = new JTextField();
    	firstnamefield.setBounds(160, 96, 96, 19);
    	frmRegisterScreen.getContentPane().add(firstnamefield);
    	firstnamefield.setColumns(10);
    	
    	lastnamefield = new JTextField();
    	lastnamefield.setBounds(160, 119, 96, 19);
    	frmRegisterScreen.getContentPane().add(lastnamefield);
    	lastnamefield.setColumns(10);
    	
    	addressfield = new JTextField();
    	addressfield.setBounds(160, 145, 96, 19);
    	frmRegisterScreen.getContentPane().add(addressfield);
    	addressfield.setColumns(10);
    	
    	dateofbirthfield = new JTextField();
    	dateofbirthfield.setBounds(160, 170, 96, 19);
    	frmRegisterScreen.getContentPane().add(dateofbirthfield);
    	dateofbirthfield.setColumns(10);
    	
    	phonenumberfield = new JTextField();
    	phonenumberfield.setBounds(160, 193, 96, 19);
    	frmRegisterScreen.getContentPane().add(phonenumberfield);
    	phonenumberfield.setColumns(10);
    	frmRegisterScreen.setSize(427, 298);
    	
    	JButton registerbutton = new JButton("Register");
    	registerbutton.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			String firstName = firstnamefield.getText();
    			String lastName = lastnamefield.getText();
    			String email = emailfield.getText();
				String password = new String(passwordfield.getPassword());
				System.out.println("Password is: " + password);
    			String address = addressfield.getText();
    			String phoneNumber = phonenumberfield.getText();
    			String dateOfBirth = dateofbirthfield.getText();
    			Student newStudent = new Student(0, firstName, lastName, address, phoneNumber, email, dateOfBirth, password);
    			studentApp.insertStudent(newStudent);
    		}
    	});
    	registerbutton.setBounds(156, 230, 85, 21);
    	frmRegisterScreen.getContentPane().add(registerbutton);
    	frmRegisterScreen.setVisible(true);
    }
    
    
}
