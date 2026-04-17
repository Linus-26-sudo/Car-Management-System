package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DashboardJFrame extends JFrame {
    
    JPanel jp = new JPanel();
    JLabel titleLb;
    
    JButton SearchCarBtn;
    JButton AddCarBtn;
    JButton DeleteCarBtn;
    JButton UpdateCarBtn;
    JButton ViewCarBtn;
    JButton LogOutBtn;
    
    public DashboardJFrame(){
        jp = new JPanel();
        
        // title
        titleLb = new JLabel(" CAR MANAGEMENT DASHBOARD");
        titleLb.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLb.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // buttons
        SearchCarBtn = new JButton("Search Car");
        AddCarBtn = new JButton("Add Car");
        DeleteCarBtn = new JButton("Delete Car");
        UpdateCarBtn = new JButton("Update Car");
        ViewCarBtn = new JButton("View Car");
        LogOutBtn = new JButton("Logout");
        
        
        SearchCarBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Search a Car");
            }
        });
        
        AddCarBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Add a Car");
            }
        });
        
        DeleteCarBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Delete a Car");
            }
        });
        
        UpdateCarBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Update a Car");
            }
        });
        
        ViewCarBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "View all Cars");
            }
        });
        
        LogOutBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Logout");
                new LoginJFrame();
                dispose();
            }
        });
        
        GridLayout grid = new GridLayout(4,1);
        
        jp.setLayout(grid);
        jp.add(titleLb);
        jp.add(SearchCarBtn);
        jp.add(AddCarBtn);
        jp.add(DeleteCarBtn);
        jp.add(UpdateCarBtn);
        jp.add(ViewCarBtn);
        jp.add(LogOutBtn);
        
        this.add(jp);
        this.setTitle("Dashboard");
        this.setSize(420, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args){
        new DashboardJFrame();
    }
    
}
