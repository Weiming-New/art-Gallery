package client.trade;

import entity.Trade;
import function.DatabaseConnection;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuyArtWorks extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4154065579756517915L;

//	JTextField jt1, jt2, jt3, jt4, jt5, jt6;
	JTextField jt1, jt2, jt3;
//	JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7;
	JLabel jl1, jl2, jl3, jl4;
	JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8;
	JButton jb1, jb2;

	public BuyArtWorks() {

		jt1 = new JTextField(8);
		jt2 = new JTextField(8);
		jt3 = new JTextField(8);
//		jt4 = new JTextField(8);
//        jt5 = new JTextField(8);
		// jt6 = new JTextField(8);

		jl1 = new JLabel("艺术品采购");
		jl2 = new JLabel("购买订单编号：");
		jl3 = new JLabel("姓名：");
		jl4 = new JLabel("艺术品编号：");
//		jl5 = new JLabel("采购时间：");

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp7 = new JPanel();
		jp8 = new JPanel();

		jb1 = new JButton("购买");
		// jb2 = new JButton("返回");
		jb1.addActionListener(this);
		// jb2.addActionListener(this);

		jp1.add(jl1);

		jp2.add(jl2);
		jp2.add(jt1);
		jp2.add(jl3);
		jp2.add(jt2);

		jp3.add(jl4);
		jp3.add(jt3);
//		jp3.add(jl5);
//		jp3.add(jt4);

		jp4.add(jb1);
		// jp5.add(jb2);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
//        this.add(jp5);

		this.setVisible(true);
		this.setTitle("艺术画廊管理系统");
		this.setBounds(700, 300, 600, 400);
		this.setLayout(new GridLayout(6, 4));
	}

	public void clear() {
		jt1.setText("");
		jt2.setText("");
		jt3.setText("");
//		jt4.setText("");
//        jt5.setText("");
		// jt6.setText("");
	}

	// 判断艺术品编号是否存在 是否售出
	public int verify() {
		Connection con = null;
		Connection con1 = null;
		ResultSet rs, rs2;
		int result = 0;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from ArtWork where AWno = ?");
			ps.setString(1, jt3.getText());
			rs = ps.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "该编号存在", "提示消息", JOptionPane.WARNING_MESSAGE);
				result = 1;
			} else {
				JOptionPane.showMessageDialog(null, "该编号不存在，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);
				result = 0;
			}
			con1 = DatabaseConnection.getConnection();
			PreparedStatement ps2 = con1.prepareStatement("select AWsold from ArtWork where AWno = ?");
			ps2.setString(1, jt3.getText());
			rs2 = ps2.executeQuery();
			if (rs2.next()) {
				String a = rs2.getString(1);
				System.out.println(a);
				if (Integer.parseInt(a)==1) {
					JOptionPane.showMessageDialog(null, "购买失败，该艺术品已售出", "提示消息", JOptionPane.WARNING_MESSAGE);
					result = 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 设置该艺术品的状态
	public void sold() {
		Connection con = null;
		try {
			con = DatabaseConnection.getConnection();
			String sql = "update ArtWork set AWsold = '1' where AWno = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, jt3.getText());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void buyArtworks() {
		Connection con = null;

		int result = 0;
		try {
			if (!jt1.getText().isEmpty() && !jt2.getText().isEmpty() && !jt3.getText().isEmpty()) {
				con = DatabaseConnection.getConnection();
				String sql = "insert into TradeInfo values (?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				Trade trade = new Trade();
				trade.setTi_no(jt1.getText());
				trade.setTi_name(jt2.getText());
				trade.setAw_no(jt3.getText());
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String curDate = dateFormat.format(new Date());
				trade.setTi_time(curDate);
//					pi.setTi_time(jt4.getText());
				ps.setString(1, trade.getTi_no());
				ps.setString(2, trade.getTi_name());
				ps.setString(3, trade.getTi_time());
				ps.setString(4, trade.getAw_no());
				result = ps.executeUpdate();
			} else {
				JOptionPane.showMessageDialog(null, "请输入完整信息", "提示消息", JOptionPane.WARNING_MESSAGE);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (result == 1) {
			sold();
			JOptionPane.showMessageDialog(null, "购买成功", "提示消息", JOptionPane.WARNING_MESSAGE);
			System.out.println("购买成功");
			clear();
		} else if (result == 0) {
			JOptionPane.showMessageDialog(null, "购买失败", "提示消息", JOptionPane.WARNING_MESSAGE);
			System.out.println("购买失败");
			clear();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "购买") {
			if (verify() == 1) {
				buyArtworks();
			} else {
				clear();
			}
		}
	}
}
