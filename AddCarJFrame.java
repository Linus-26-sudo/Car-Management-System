package gui;

import carmanagementsystem.DBOperations;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddCarJFrame extends JFrame {
    
    DBOperations dbo = new DBOperations();
    
    JPanel jp =new JPanel();
    
    JLabel titleLb;
    JLabel brandLb;
    JLabel modelLb;
    JLabel yearLb;
    JLabel priceLb;
    JLabel availableLb;
    
    JTextField brandTxt;
    JTextField modelTxt;
    JTextField yearTxt;
    JTextField priceTxt;
    
    JComboBox<String> availableBox;
    
    JButton saveBtn;
    JButton clearBtn;
    JButton backBtn;
    
    public AddCarJFrame(){
        jp = new JPanel();
        
        // title
        titleLb = new JLabel (" ADD NEW CAR ");
        titleLb.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLb.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // brand
        brandLb = new JLabel("Brand");
        brandLb.setFont(new Font("Times New Roman", Font.BOLD, 14));
        brandLb.setHorizontalAlignment((int)JPanel.LEFT_ALIGNMENT);
        
        brandTxt = new JTextField();
        brandTxt.setFont(new Font("Times New Roman", Font.BOLD, 12));
        brandTxt.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // model
        modelLb = new JLabel("Model");
        modelLb.setFont(new Font("Times New Roman", Font.BOLD, 14));
        modelLb.setHorizontalAlignment((int)JPanel.LEFT_ALIGNMENT);
        
        modelTxt = new JTextField();
        modelTxt.setFont(new Font("Times New Roman", Font.BOLD, 12));
        modelTxt.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // year
        yearLb = new JLabel("Year");
        yearLb.setFont(new Font("Times New Roman", Font.BOLD, 14));
        yearLb.setHorizontalAlignment((int)JPanel.LEFT_ALIGNMENT);
        
        yearTxt = new JTextField();
        yearTxt.setFont(new Font("Times New Roman", Font.BOLD, 12));
        yearTxt.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // price
        priceLb = new JLabel("Price");
        priceLb.setFont(new Font("Times New Roman", Font.BOLD, 14));
        priceLb.setHorizontalAlignment((int)JPanel.LEFT_ALIGNMENT);
        
        priceTxt = new JTextField();
        priceTxt.setFont(new Font("Times New Roman", Font.BOLD, 12));
        priceTxt.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // available
        availableLb = new JLabel("Available");
        availableBox = new JComboBox<>(new String[]{"Yes", "No"});
        
        // Buttons
        saveBtn = new JButton("Save");
        clearBtn = new JButton("Clear");
        backBtn = new JButton("Back");
        
        saveBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String brand = brandTxt.getText();
                    String model = modelTxt.getText();
                    int year = Integer.parseInt(yearTxt.getText());
                    double price = Double.parseDouble(priceTxt.getText());
                    boolean available = availableBox.getSelectedItem().equals("Yes");
                    dbo.insertOperation(brand, model, year, price, available);
                    JOptionPane.showMessageDialog(null, "Car Added Successfully!");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "!! Invalid Input !!");
                }
            }
        });
        
        clearBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                brandTxt.setText("");
                modelTxt.setText("");
                yearTxt.setText("");
                priceTxt.setText("");
                availableBox.setSelectedIndex(0);
            }
        });
        
        backBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new DashboardJFrame();
                dispose();
            }
        });
        
        
        GridLayout grid = new GridLayout(8,2, 10, 10);
        
        jp.setLayout(grid);
        jp.add(titleLb);       
        jp.add(brandLb);
        jp.add(brandTxt);
        jp.add(modelLb);
        jp.add(modelTxt);       
        jp.add(yearLb);
        jp.add(yearTxt);       
        jp.add(priceLb);
        jp.add(priceTxt);       
        jp.add(availableLb);
        jp.add(availableBox);       
        jp.add(saveBtn);
        jp.add(clearBtn);
        jp.add(backBtn);
        
        this.add(jp);
        this.setTitle("Car Information");
        this.setSize(450, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args){
        new AddCarJFrame();
    }
    
}
