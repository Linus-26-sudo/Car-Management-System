package gui;

import carmanagementsystem.DBOperations;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchCarJFrame extends JFrame {
    DBOperations dbo = new DBOperations();
    
    JPanel jp = new JPanel();
    
    JLabel titleLb;
    JLabel idLb;
    JLabel resultLb;
    
    JTextField idTxt;
    JTextArea resultArea;
    
    JButton searchBtn;
    JButton clearBtn;
    JButton backBtn;
    
    public SearchCarJFrame(){
        jp = new JPanel();
        
        // title
        titleLb = new JLabel (" SEARCH A CAR ");
        titleLb.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLb.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // Car ID
        idLb = new JLabel("Enter Car ID: ");
        idLb.setFont(new Font("Times New Roman", Font.BOLD, 14));
        idLb.setHorizontalAlignment((int)JPanel.LEFT_ALIGNMENT);
        
        idTxt = new JTextField();
        idTxt.setFont(new Font("Times New Roman", Font.BOLD, 14));
        idTxt.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // result
        resultLb = new JLabel("Car Details: ");
        resultLb.setFont(new Font("Times New Roman", Font.BOLD, 14));
        resultLb.setHorizontalAlignment((int)JPanel.LEFT_ALIGNMENT);
        
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
        
        JScrollPane scroll = new JScrollPane(resultArea);
        
        // Buttons
        searchBtn = new JButton("Search");
        clearBtn = new JButton("Clear");
        backBtn = new JButton("Back");
        
        // Search Action
        searchBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    int carId = Integer.parseInt(idTxt.getText());
                    dbo.selectOperation(carId);
                    resultArea.setText("Search completed.");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Enter valid Car ID!");
                }
            }
        });
        
        // Clear Action
        clearBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                idTxt.setText("");
                resultArea.setText("");
            }
        });
        
        // Back Action
        backBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new DashboardJFrame();
                dispose();
            }
        });
        
        GridLayout grid = new GridLayout(5,2,10,10);
        
        jp.setLayout(grid);
        jp.add(titleLb); 
        jp.add(new JLabel(""));
        jp.add(idLb);
        jp.add(idTxt);
        jp.add(resultLb);
        jp.add(scroll);           
        jp.add(searchBtn);
        jp.add(clearBtn);
        jp.add(backBtn);
        jp.add(new JLabel(""));
        
        this.add(jp);
        this.setTitle("Search Car");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args){
        new SearchCarJFrame();
    }
}
