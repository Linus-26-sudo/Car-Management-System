package gui;

import carmanagementsystem.DBOperations;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteCarJFrame extends JFrame {
    DBOperations dbo = new DBOperations();
    
    JPanel jp = new JPanel();
    
    JLabel titleLb;
    JLabel idLb;
    JLabel noteLb;
    
    JTextField idTxt;
    
    JButton deleteBtn;
    JButton clearBtn;
    JButton backBtn;
    
    public DeleteCarJFrame(){
        jp = new JPanel();
        
        // title
        titleLb = new JLabel (" DELETE A CAR ");
        titleLb.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLb.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // Car ID
        idLb = new JLabel("Enter Car ID: ");
        idLb.setFont(new Font("Times New Roman", Font.BOLD, 14));
        idLb.setHorizontalAlignment((int)JPanel.LEFT_ALIGNMENT);
        
        idTxt = new JTextField();
        idTxt.setFont(new Font("Times New Roman", Font.BOLD, 14));
        idTxt.setHorizontalAlignment((int)JPanel.CENTER_ALIGNMENT);
        
        // Note 
        noteLb = new JLabel("Warning: This action cannot be undone.");
        noteLb.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        
        // Buttons
        deleteBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        backBtn = new JButton("Back");
        
        // delete action
        deleteBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    int carId = Integer.parseInt(idTxt.getText());
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete Car ID "+carId+"?",
                            "Confirm Delete", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION){
                        dbo.deleteOperation(carId);
                        JOptionPane.showMessageDialog(null, "Delete request completed.");
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Enter a valid Car ID!");
                }
            }
        });
        
        // Clear Action
        clearBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                idTxt.setText("");
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
        jp.add(noteLb);  
        jp.add(new JLabel(""));
        jp.add(deleteBtn);
        jp.add(clearBtn);
        jp.add(backBtn);
        jp.add(new JLabel(""));
        
        this.add(jp);
        this.setTitle("Delete Car");
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);    
    }
    
    public static void main(String[] args){
        new DeleteCarJFrame();
    }
}
