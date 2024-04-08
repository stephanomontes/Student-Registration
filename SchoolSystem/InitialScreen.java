 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InitialScreen {

    private StudentApp studentApp;
    private JFrame frmStudentApp;
    
    public InitialScreen(StudentApp studentApp) {
        this.studentApp = studentApp;
        frmStudentApp = new JFrame();
        frmStudentApp.setTitle("Student App");
        frmStudentApp.setSize(500, 300);
        frmStudentApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmStudentApp.setAlwaysOnTop(true);
        frmStudentApp.setAutoRequestFocus(false);
        frmStudentApp.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Student App");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(150, 38, 196, 48);
        frmStudentApp.getContentPane().add(lblNewLabel);
        
        JButton toRegister = new JButton("Register");
        toRegister.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.out.println("Register Clicked!");
        		RegisterScreen registerScreen = new RegisterScreen(studentApp);
        	}
        });
        toRegister.setBounds(205, 132, 85, 21);
        frmStudentApp.getContentPane().add(toRegister);
        
        JButton toLogin = new JButton("Login");
        toLogin.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.out.println("Login Clicked!");
        		LoginScreen login = new LoginScreen(studentApp);
        	}
        });
        toLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        toLogin.setBounds(205, 174, 85, 21);
        frmStudentApp.getContentPane().add(toLogin);
        frmStudentApp.setVisible(true);
    }
}
