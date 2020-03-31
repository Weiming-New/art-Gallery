package client.HallReserve;

import javax.swing.*;

import function.DatabaseConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SelectReserve extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5839113492045560425L;
	
	JTable jt;
    JScrollPane js = new JScrollPane();
    Vector<String> columnNames = null;
    Vector<Vector<String>> rowData = null;
    Connection con = null;
    ResultSet rs;

    public SelectReserve(){

        columnNames = new Vector<String>();
        rowData = new Vector<Vector<String>>();
        columnNames.add("订单编号");
        columnNames.add("展厅名称");
        columnNames.add("姓名");
        columnNames.add("时间");
        columnNames.add("展位数");


        try{
            con = DatabaseConnection.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select * from v_reserve where no = ?");
            ps.setString(1,SelectRno.jt1.getText());
            rs = ps.executeQuery();
            while (rs.next()){
                Vector<String> vector = new Vector<String>();
                vector.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
                vector.add(rs.getString(5));
                //vector.add(rs.getString(6));
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
