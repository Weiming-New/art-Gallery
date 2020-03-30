package client.exhibition;

import javax.swing.*;

import function.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateExhibitionInformation extends JFrame implements ActionListener {


    /**
	 * 
	 */
	private static final long serialVersionUID = 3211693917468550190L;
	
	JTextField jt1, jt2, jt3, jt4, jt5, jt6;
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8;
    JButton jb1, jb2;
    JLabel jLabel;

    public UpdateExhibitionInformation() {

        jt1 = new JTextField(8);
        jt2 = new JTextField(8);
        jt3 = new JTextField(8);

        jl1 = new JLabel("艺术家信息修改系统");
        jl2 = new JLabel("展会编号");
        jl3 = new JLabel("展会名称");
        jl4 = new JLabel("展会时间");
        jLabel = new JLabel(UpdateExhibition.jt1.getText());

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();


        jb1 = new JButton("确定");
        jb2 = new JButton("返回");
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jp1.add(jl1);

        jp2.add(jl2);
        jp2.add(jLabel);
        
        jp3.add(jl3);
        jp3.add(jt2);

        jp4.add(jl4);
        jp4.add(jt3);

        jp5.add(jb1);
        jp5.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);

        this.setVisible(true);
        this.setTitle("艺术画廊管理系统");
        this.setBounds(720, 320, 600, 400);
        this.setLayout(new GridLayout(6, 4));
    }

    private void update() {
        Connection con = null;
//        ResultSet rs;
//        int result = 0;
        try {
            if (!jt2.getText().isEmpty() && !jt3.getText().isEmpty() && !jt4.getText().isEmpty()) {
                con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement("update Exhibition set Ename = ?,Etime = ? where Eno = " + UpdateExhibition.jt1.getText());
                ps.setString(1, jt2.getText());
                ps.setString(2, jt3.getText());


                ps.executeUpdate();
                System.out.println("信息修改成功");
                JOptionPane.showMessageDialog(null, "信息修改成功", "提示消息", JOptionPane.WARNING_MESSAGE);
                jt1.setText("");
                jt2.setText("");
                jt3.setText("");
                jt4.setText("");
                jt5.setText("");
                jt6.setText("");
                con.close();
                System.out.println("数据库关闭");
            }else {
                JOptionPane.showMessageDialog(null, "请输入完整信息", "提示消息", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回") {
            new UpdateExhibition();
            dispose();

        } else if (e.getActionCommand() == "确定") {
            update();
        } else {
            JOptionPane.showMessageDialog(null, "该编号不存在，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);
            jt1.setText("");
        }
    }
}

