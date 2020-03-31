package ExhibitionInfo;

import client.ticket.BuyTicket;
import function.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SelectInfo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5683897398789016711L;

	JTable jt;
	JScrollPane js = new JScrollPane();
	Vector<String> columnNames = null;
	Vector<Vector<String>> rowData = null;
	Connection con = null;
	ResultSet rs;

	JButton jb;
	JPanel jp;

	public SelectInfo() {

		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		columnNames.add("展会编号");
		columnNames.add("展会名称");
		columnNames.add("艺术品名称");
		columnNames.add("艺术家姓名");
		columnNames.add("地址");
		columnNames.add("时间");
		columnNames.add("类别");
		columnNames.add("门票价格");

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps;
			String sql = "select EIno,Exhibitino.Ename,Artwork.Tname,Artist.Aname,Place.Hname,Mtime,Artwork.Tkind,Mprice from Meeting,Artwork,Place,Artist where Meeting.AWno = Artwork.AWno and Meeting.Hno = Place.Hno and Meeting.Ano = Artist.Ano";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				vector.add(rs.getString(6));
				vector.add(rs.getString(7));
				vector.add(rs.getString(8));
				rowData.add(vector);
			}
			System.out.println("OK");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		jb = new JButton("购票");
		jb.addActionListener(this);
		jp = new JPanel();
		jp.add(jb);
		jp.setLocation(100, 100);

		jt = new JTable(rowData, columnNames);
		js = new JScrollPane(jt);

		this.add(js);
		this.add(jp);
		this.setTitle("查询");
		this.setLayout(new GridLayout(2, 1));
		this.setBounds(450, 300, 1200, 600);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "购票") {
			new BuyTicket();
			dispose();
		}
	}
}
