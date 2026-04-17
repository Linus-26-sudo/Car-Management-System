package gui;

import carmanagementsystem.DBOperations;
import carmanagementsystem.Car;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewALLCarsJFrame extends JFrame{
    
    DBOperations dbo = new DBOperations();
    JTable carTable;
    DefaultTableModel tableModel;
    JButton backBtn;
    JLabel titleLb;

    public ViewALLCarsJFrame() {
        
        // title
        titleLb = new JLabel (" ALL REGISTERED CARS ");
        titleLb.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLb.setHorizontalAlignment(SwingConstants.CENTER);
        
        String[] columns = {
            "ID",
            "Brand",
            "Model",
            "Year",
            "Price/Day",
            "Available"
        };
        
        tableModel = new DefaultTableModel(columns, 0);
        carTable = new JTable(tableModel);
        
        // Table Design
        carTable.setRowHeight(25);
        carTable.setFont(new Font("Arial", Font.PLAIN, 14));
        carTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        
        carTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        carTable.setAutoCreateRowSorter(true);
        
        carTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        carTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        carTable.getColumnModel().getColumn(2).setPreferredWidth(120);
       
        JScrollPane scrollPane = new JScrollPane(carTable);
        
        loadCarData();
        
        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.BOLD,14));
        
        backBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new DashboardJFrame();
                dispose();
            }
        });
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.add(backBtn);
        
        setLayout(new BorderLayout(10, 10));
        
        add(titleLb, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        setTitle("All Cars");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void loadCarData(){
        tableModel.setRowCount(0);
        List<Car> cars = dbo.getAllCars();
        for (Car car : cars){
            tableModel.addRow(new Object[]{
                car.getCarId(),
                car.getBrand(),
                car.getModel(),
                car.getYear(),
                car.getPrice(),
                car.isAvailable() ? "Yes" : "No"
            });
        }
    }
       
    public static void main(String[] args){
        SwingUtilities.invokeLater(ViewALLCarsJFrame::new);
    }
}
