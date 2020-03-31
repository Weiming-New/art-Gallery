package client.artwork;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import function.DatabaseConnection;

public class SelectArtworkPrice  extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6975425788556146894L;
	
	JButton jb1, jb2;
	JPanel jp1, jp2, jp3;
	JLabel jl1, jl2,jl3;
	static ResultSet rs2;
	
	public static ResultSet getRs() {
		return rs2;
	}


	public static JTextField jt1,jt2;

	public SelectArtworkPrice() {
		jb1 = new JButton("确定");

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jl1 = new JLabel("艺术品价格查询系统");
		jl2 = new JLabel("最低价");
		jl3 = new JLabel("最高价");

		jt1 = new JTextField(8);
		jt2 = new JTextField(8);

		jb1.addActionListener(this);

		jp1.add(jl1);
		jp2.add(jl2);
		jp2.add(jt1);
		jp2.add(jl3);
		jp2.add(jt2);

		jp3.add(jb1);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);

		this.setVisible(true);
		this.setLayout(new GridLayout(3, 1));
		this.setBounds(720, 350, 510, 280);
		this.setTitle("艺术画廊管理系统");
	}

	public int verify() {
		Connection con = null;
		
		int result = 0;
		try {
			if (!jt1.getText().isEmpty()) {
				con = DatabaseConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from Artwork where AWprice between ? and ?");
				ps.setString(1, jt1.getText());
				ps.setString(2, jt2.getText());
				SelectArtworkPrice.rs2 = ps.executeQuery();
				if (rs2.first()) {
					JOptionPane.showMessageDialog(null, "该区间存在艺术品", "提示消息", JOptionPane.WARNING_MESSAGE);
					result = 1;
				} else {
					JOptionPane.showMessageDialog(null, "该区间不存在艺术品，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "请输入完整信息", "提示消息", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "确定") {
			if (verify() == 1) {
				new SelectArtworkPriceout(); //调用对应Out类
				dispose();

			} else {
				jt1.setText("");
			}
		}
	}

}
