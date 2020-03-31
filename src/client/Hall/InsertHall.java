package client.Hall;

import entity.Hall;
import function.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertHall extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2332549319017710645L;
	
	JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7;
    JButton jb1, jb2;
    JTextField jt1, jt2, jt3, jt4, jt5, jt6;


    public InsertHall() {

        jb1 = new JButton("开放展厅");
        //jb2 = new JButton("返回");

        jb1.addActionListener(this);
        //jb2.addActionListener(this);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();


        JLabel jl1 = new JLabel("展厅信息管理");
        JLabel jl2 = new JLabel("展厅编号");
        JLabel jl3 = new JLabel("展厅名称");
        JLabel jl4 = new JLabel("面积");
        JLabel jl5 = new JLabel("地址");
        JLabel jl6 = new JLabel("负责人");
        JLabel jl7 = new JLabel("展位数");

        jt1 = new JTextField(8);
        jt2 = new JTextField(8);
        jt3 = new JTextField(8);
        jt4 = new JTextField(8);
        jt5 = new JTextField(8);
        jt6 = new JTextField(8);


        jp1.add(jl1);
        jp2.add(jl2);
        jp2.add(jt1);

        jp2.add(jl3);
        jp2.add(jt2);

        jp3.add(jl4);
        jp3.add(jt3);

        jp3.add(jl5);
        jp3.add(jt4);

        jp4.add(jl6);
        jp4.add(jt5);

        jp4.add(jl7);
        jp4.add(jt6);

        jp5.add(jb1);
        //jp5.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);

        this.setVisible(true);
//        this.setResizable(false);
        this.setTitle("艺术画廊管理系统");
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(660, 280, 700, 500);
    }

    public void clear() {
        jt1.setText("");
        jt2.setText("");
        jt3.setText("");
        jt4.setText("");
        jt5.setText("");
        jt6.setText("");
    }


    public void insert() {
        Connection con = null;
        int result = 0;

        try {
            if (!jt1.getText().isEmpty() && !jt2.getText().isEmpty() && !jt3.getText().isEmpty() && !jt4.getText().isEmpty() && !jt5.getText().isEmpty() && !jt6.getText().isEmpty()) {
                    con = DatabaseConnection.getConnection();
                    PreparedStatement ps = con.prepareStatement("insert into Hall values(?,?,?,?,?,?)");
                    Hall b = new Hall();
                    b.setH_no(jt1.getText());
                    b.setH_name(jt2.getText());
                    b.setH_area(jt3.getText());
                    b.setH_address(jt4.getText());
                    b.setPerson_in_charge(jt5.getText());
                    b.setH_num(jt6.getText());

                    ps.setString(1, b.getH_no());
                    ps.setString(2, b.getH_name());
                    ps.setString(3, b.getH_area());
                    ps.setString(4, b.getH_address());
                    ps.setString(5, b.getPerson_in_charge());
                    ps.setString(6, b.getH_num());
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
            JOptionPane.showMessageDialog(null, "添加成功", "提示消息", JOptionPane.WARNING_MESSAGE);
            clear();
        }else if (result == 0) {
        JOptionPane.showMessageDialog(null, "添加失败", "提示消息", JOptionPane.WARNING_MESSAGE);
        System.out.println("添加失败");
    }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "开放展厅") {
            insert();
        }
    }
}