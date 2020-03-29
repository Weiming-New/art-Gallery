package client.ticket;

import javax.swing.*;

import function.DatabaseConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SelectTicketAll extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7302623150339552008L;
	
	JTable jt;
    JScrollPane js = new JScrollPane();
    Vector<String> columnNames = null;
    Vector<Vector<String>> rowData = null;
    Connection con = null;
    ResultSet rs;

    public SelectTicketAll(){

        columnNames = new Vector<String>();
        rowData = new Vector<Vector<String>>();
        columnNames.add("订单编号");
        columnNames.add("姓名");
        columnNames.add("性别");
        columnNames.add("职业");
        columnNames.add("艺术展名称");
        columnNames.add("展厅名称");
        columnNames.add("门票价格");


        try{
            con = DatabaseConnection.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select no,t_name,sex,work,e_name,H_name,price from v_ticket");
            rs = ps.executeQuery();
            while (rs.next()){
                Vector<String> vector = new Vector<String>();
                vector.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
                vector.add(rs.getString(5));
                vector.add(rs.getString(6));
                vector.add(rs.getString(7));
                rowData.add(vector);
            }
            System.out.println("OK");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                rs.close();
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        jt = new JTable(rowData,columnNames);
        js = new JScrollPane(jt);

        this.add(js);
        this.setTitle("查询");
        this.setLayout(new GridLayout(2,2));
        this.setBounds(644,300,850,500);
        this.setVisible(true);
        //this.setResizable(false);
    }
}
