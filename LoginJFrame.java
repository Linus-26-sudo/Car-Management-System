package gui;

import java.awt.*;/*awt (Abstract Window Toolkit) - for colors, fonts and event handling */
import java.awt.event.*; // imports classes for handling button clicks and other user actions.
import javax.swing.*; // java's tooljit for creating desktop applications

public class LoginJFrame extends JFrame{
    
    JPanel jp =new JPanel();
    JLabel titleLb;
    JLabel subtitleLb;
    JLabel UsernameLb; 
    JLabel PasswordLb; 
    JTextField UserTxt; 
    JPasswordField PassTxt; 
    JButton Loginbtn;
    
    public LoginJFrame(){
        jp = new JPanel();
         
        // main title
        titleLb = new JLabel (" CAR MANAGEMENT LOGIN ");
        titleLb.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLb.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // login title
        subtitleLb = new JLabel (" Login ");
        subtitleLb.setFont(new Font("Impact", Font.BOLD, 16));
        subtitleLb.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // username
        UsernameLb = new JLabel (" Enter Username: ");
        UsernameLb.setFont(new Font("Times New Roman", Font.BOLD, 12));
        UsernameLb.setHorizontalAlignment((int)JPanel.LEFT_ALIGNMENT);
        
        UserTxt = new JTextField ();
        UserTxt.setFont(new Font("Times New Roman", Font.BOLD, 12));
        UserTxt.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // password
        PasswordLb = new JLabel("Enter your password");
        PasswordLb.setFont(new Font("Times NewRoman", Font.BOLD, 12));
        PasswordLb.setHorizontalAlignment((int)JPanel.LEFT_ALIGNMENT);
        
        PassTxt = new JPasswordField();
        PassTxt.setFont(new Font("Times NewRoman", Font.BOLD, 12));
        PassTxt.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // button
        Loginbtn = new JButton(" Login ");
        Loginbtn.setFont(new Font("Agency FB", Font.BOLD, 15));
        Loginbtn.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        Loginbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String Username = UserTxt.getText();
                String Password = new String(PassTxt.getPassword());
                
                if (Username.equals("admin") && Password.equals("1234")){
                    JOptionPane.showMessageDialog(null, "Login Successfull");
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            }
        });
        
        GridLayout grid = new GridLayout(4,1);
        
        jp.setLayout(grid);
        jp.add(titleLb);
        jp.add(subtitleLb);
        jp.add(UsernameLb);
        jp.add(UserTxt);
        jp.add(PasswordLb);
        jp.add(PassTxt);
        jp.add(Loginbtn);
        
        this.add(jp);
        this.setTitle(" Car Management Login");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
         
    }
    
    public static void main(String[] args){
        new LoginJFrame();
    }
}
