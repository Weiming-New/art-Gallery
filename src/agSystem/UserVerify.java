package agSystem;

import function.DatabaseConnection;

import javax.swing.*;

//import client.Hall.UpdateHall;

import java.sql.*;

/*
采用单例模式
 */

public class UserVerify {

	Connection ct;
	PreparedStatement ps;
	ResultSet rs;
	String user, pwd;

	String a, b, c, d, ee, f;

	public UserVerify() {
	}

	// 注册用户的方法
	public void UserRegis(String a, String b) {
		try {
			ct = DatabaseConnection.getConnection();
			ps = ct.prepareStatement("insert into user values(?,?)");
			ps.setString(1, a);
			ps.setString(2, b);

			// 执行
			int i = ps.executeUpdate();
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "注册成功", "提示消息", JOptionPane.WARNING_MESSAGE);
				System.out.println("注册成功");
			} else {
				JOptionPane.showMessageDialog(null, "注册失败", "提示消息", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 管理员登录验证方法
	public void verifyRootWithSQL(String a, String b) {
		try {
			ct = DatabaseConnection.getConnection();
			ps = ct.prepareStatement("select * from user where Sacc=? and Spwd=?");
			ps.setString(1, a);
			ps.setString(2, b);

			// ResultSet结果集,把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();

			if (rs.next()) {
				user = rs.getString(1);
				pwd = rs.getString(2);
				JOptionPane.showMessageDialog(null, "登录成功！！！", "提示消息", JOptionPane.WARNING_MESSAGE);
				System.out.println("登录成功");
				new AdminRoot();
				SystemMain m = new SystemMain();
				m.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 客户登录验证方法
	public void verifyUserWithSQL(String a, String b) {
		try {
			ct = DatabaseConnection.getConnection();
			ps = ct.prepareStatement("select * from user where Sacc=? and Spwd=?");
			ps.setString(1, a);
			ps.setString(2, b);

			// ResultSet结果集,把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();

			if (rs.next()) {
				user = rs.getString(1);
				pwd = rs.getString(2);
				JOptionPane.showMessageDialog(null, "登录成功！！！", "提示消息", JOptionPane.WARNING_MESSAGE);
				System.out.println("登录成功");
				new User();
				SystemMain m = new SystemMain();
				m.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 注册验证方法，判断用户名是否已经存在
	public void verifyRegisterWithSQL(String a) {
		try {
			ct = DatabaseConnection.getConnection();
			ps = ct.prepareStatement("select * from user where Sacc=?");
			ps.setString(1, a);

			rs = ps.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "该用户名已经存在", "提示信息", JOptionPane.WARNING_MESSAGE);
			} else {
				this.UserRegis(RegistRoot.jtf1.getText(), RegistRoot.jtf2.getText());
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}