package client.artist;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import function.DatabaseConnection;

public class SelectArtistNameout extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2001005362956966446L;
	
	JTable jt;
    JScrollPane js = new JScrollPane();
    Vector<String> columnNames = null;
    Vector<Vector<String>> rowData = null;
    Connection con = null;
    ResultSet rs;

    public SelectArtistNameout(){

    	//显示的属性
        columnNames = new Vector<String>();
        rowData = new Vector<Vector<String>>();
        columnNames.add("艺术家编号");
        columnNames.add("姓名");
        
        columnNames.add("职业");
        columnNames.add("工作单位");
        


        try{
            con = DatabaseConnection.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select Ano,Aname,Amajor,Aworkplace from artist where Aname = ?");
            ps.setString(1,SelectArtistName.jt1.getText()); //将前一个填入的内容直接取过来
            rs = ps.executeQuery();
            while (rs.next()){
                Vector<String> vector = new Vector<String>();
                vector.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
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
