package client.exhibitionInfo;

import entity.ExhibitionInformation;
import function.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/*
添加艺术展信息
 */
public class InsertInfo extends JFrame implements ActionListener {

    JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8, jtf9 = null;
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9 = null;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8 = null;
    JButton jb1, jb2;

    public InsertInfo() {

        jl1 = new JLabel(" 展会编号：");
        jl2 = new JLabel(" 展会名称：");
        jl3 = new JLabel(" 艺术家编号：");
        jl4 = new JLabel(" 艺术品编号：");
        jl6 = new JLabel(" 展厅编号：");
        jl7 = new JLabel(" 时间：");
        jl9 = new JLabel(" 门票价格");

        jb1 = new JButton("发布");
        jb1.addActionListener(this);

        jtf1 = new JTextField(6);
        jtf2 = new JTextField(6);
        jtf3 = new JTextField(6);
        jtf4 = new JTextField(6);
        jtf6 = new JTextField(6);
        jtf7 = new JTextField(6);
        jtf9 = new JTextField(6);


        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();

        jp1.add(jl1);
        jp1.add(jtf1);
        jp1.add(jl2);
        jp1.add(jtf2);

        jp2.add(jl3);
        jp2.add(jtf3);
        jp2.add(jl4);
        jp2.add(jtf4);

        jp3.add(jl6);
        jp3.add(jtf6);

        jp3.add(jl7);
        jp3.add(jtf7);

        jp4.add(jl9);
        jp4.add(jtf9);

        jp5.add(jb1);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);

        this.setVisible(true);
        this.setTitle("艺术画廊管理系统");
        this.setLayout(new GridLayout(6, 4));
        this.setBounds(700, 300, 752, 471);
    }

    //展厅编号验证
    public int verifyHno() {
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Place where Hno = ?");
            ps.setString(1, jtf6.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                result = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //艺术家编号验证
    public int verifyAno() {
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Artist where Ano = ?");
            ps.setString(1, jtf3.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                result = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //艺术品编号验证
    public int verifyAWno() {
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Artwork where AWno = ?");
            ps.setString(1, jtf4.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                result = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void insertinformation() {
        Connection con = null;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            String sql = "insert into ExhibitionInfo values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ExhibitionInformation mi = new ExhibitionInformation();

            if (!jtf1.getText().isEmpty() && !jtf2.getText().isEmpty() && !jtf3.getText().isEmpty() && !jtf4.getText().isEmpty() && !jtf6.getText().isEmpty() && !jtf7.getText().isEmpty() && !jtf9.getText().isEmpty()) {
                if ((verifyAno() == 1) && (verifyHno() == 1) && (verifyAWno() == 1)) {
                    mi.setE_id(jtf1.getText());
                    mi.setE_name(jtf2.getText());
                    mi.setA_id(jtf3.getText());
                    mi.setAw_id(jtf4.getText());
                    //mi.setT_name(jtf5.getText());
                    mi.setAddress(jtf6.getText());
                    mi.setTime(jtf7.getText());
                    //mi.setKind(jtf8.getText());

                    ps.setString(1, mi.getE_id());
                    ps.setString(2, mi.getE_name());
                    ps.setString(3, mi.getA_id());
                    ps.setString(4, mi.getAw_id());
                    //ps.setString(5,mi.getT_name());
                    ps.setString(5, mi.getAddress());
                    ps.setString(6, mi.getTime());
                    //ps.setString(8,mi.getKind());
                    result = ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "发布成功", "提示消息", JOptionPane.WARNING_MESSAGE);
                    System.out.println("插入数据成功");
                    clear();
                } else {
                    JOptionPane.showMessageDialog(null, "发布失败", "提示消息", JOptionPane.WARNING_MESSAGE);
                    System.out.println("插入数据失败");
                    clear();
                }
            } else{
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
    }


    public void clear() {
        jtf1.setText("");
        jtf2.setText("");
        jtf3.setText("");
        jtf4.setText("");
        //jtf5.setText("");
        jtf6.setText("");
        jtf7.setText("");
        //jtf8.setText("");
        jtf9.setText("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "发布") {
            insertinformation();
        }
    }
}