package client.exhibition;

import javax.swing.*;

import function.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateExhibition extends JFrame implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3744147829897017589L;
	
	JButton jb1,jb2;
    JPanel jp1,jp2,jp3;
    JLabel jl1,jl2;
    public static JTextField jt1;

    public UpdateExhibition(){
        jb1 = new JButton("确定");
        //jb2 = new JButton("返回");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jl1 = new JLabel("艺术展信息修改系统");
        jl2 = new JLabel("艺术展编号");

        jt1 = new JTextField(8);

        jb1.addActionListener(this);
        //jb2.addActionListener(this);

        jp1.add(jl1);
        jp2.add(jl2);
        jp2.add(jt1);

        jp3.add(jb1);
        //jp3.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setVisible(true);
        this.setLayout(new GridLayout(4,3));
        this.setBounds(720,320,600,400);
        this.setTitle("艺术画廊管理系统");
    }

    public int verify(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            if (!jt1.getText().isEmpty()) {
                con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement("select * from Exhibition where Eno = ?");
                ps.setString(1, jt1.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "该编号存在", "提示消息", JOptionPane.WARNING_MESSAGE);
                    result = 1;
                } else {
                    JOptionPane.showMessageDialog(null, "该编号不存在，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(null, "请输入完整信息", "提示消息", JOptionPane.WARNING_MESSAGE);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "确定") {
            if (verify() == 1) {
                new UpdateExhibitionInformation();
                dispose();
            }else {
                jt1.setText("");
            }
        }
    }
}
