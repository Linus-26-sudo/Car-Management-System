package gui;

import carmanagementsystem.DBOperations;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateCarJFrame extends JFrame {
    DBOperations dbo = new DBOperations();
    
    JPanel jp = new JPanel();
    
    JLabel titleLb;
    JLabel idLb;
    JLabel brandLb;
    JLabel modelLb;
    JLabel yearLb;
    JLabel priceLb;
    JLabel availableLb;
    
    JTextField idTxt;
    JTextField brandTxt;
    JTextField modelTxt;
    JTextField yearTxt;
    JTextField priceTxt;
    JComboBox<String> availableBox;
    
    JButton updateBtn;
    JButton clearBtn;
    JButton backBtn;
    
    public UpdateCarJFrame(){
        jp = new JPanel();
        
        // title
        titleLb = new JLabel (" UPDATE CAR ");
        titleLb.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLb.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // Car ID
        idLb = new JLabel("Car ID: ");
        idLb.setFont(new Font("Times New Roman", Font.BOLD, 14));
        idLb.setHorizontalAlignment((int)JPanel.LEFT_ALIGNMENT);
        
        idTxt = new JTextField();
        idTxt.setFont(new Font("Times New Roman", Font.BOLD, 14));
        idTxt.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
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
        updateBtn = new JButton("Update");
        clearBtn = new JButton("Clear");
        backBtn = new JButton("Back");
        
        updateBtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                int id = Integer.parseInt(idTxt.getText());
                String brand = brandTxt.getText();
                String model = modelTxt.getText();
                int year = Integer.parseInt(yearTxt.getText());
                double price = Double.parseDouble(priceTxt.getText());
                boolean available = availableBox.getSelectedItem().equals("Yes");
                dbo.updateOperation(id, brand, model, year, price, available);
                JOptionPane.showMessageDialog(null, "Car Updated Successfully!");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "!! Invalid Input !!");
            }
        }
    });
    
    clearBtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            idTxt.setText("");
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
    jp.add(new JLabel(""));
    jp.add(idLb);
    jp.add(idTxt);
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
    jp.add(updateBtn);
    jp.add(clearBtn);
    jp.add(backBtn);
    jp.add(new JLabel(""));

    this.add(jp);
    this.setTitle("Update Car");
    this.setSize(500, 420);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
    }
    
    public static void main(String[] args){
        new UpdateCarJFrame();
    }
    
}
