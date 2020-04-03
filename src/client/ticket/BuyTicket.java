package client.ticket;

import entity.TicketInformation;
import function.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyTicket extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 193079251155291697L;
	
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6 = null;
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7 = null;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8 = null;
    JButton jb1, jb2;

    public BuyTicket() {

        jl7 = new JLabel(" 艺术画廊购票系统");
        jl1 = new JLabel(" 取票码：");
        jl2 = new JLabel(" 姓名：");
        jl3 = new JLabel(" 性别：");
        jl4 = new JLabel(" 职业：");
        jl6 = new JLabel(" 价格：");
        jl5 = new JLabel(" 艺术展编号：");
        

        jb1 = new JButton("购票");
        //jb2 = new JButton("返回");

        jb1.addActionListener(this);
        //jb2.addActionListener(this);

        jtf1 = new JTextField(6);
        jtf2 = new JTextField(6);
        jtf3 = new JTextField(6);
        jtf4 = new JTextField(6);
        jtf5 = new JTextField(6);
        jtf6 = new JTextField(6);

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

        jp3.add(jl5);
        jp3.add(jtf5);
        jp3.add(jl6);
        jp3.add(jtf6);

        jp5.add(jb1);
        //jp5.add(jb2);

        jp6.add(jl7);

        this.add(jp6);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp5);

        this.setVisible(true);
//        this.setResizable(false);
        this.setTitle("艺术画廊管理系统");
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(700,300,600,400);
    }

    public int verify1(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Exhibition where Eno = ?");
            ps.setString(1,jtf5.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null,"该展览存在","提示消息",JOptionPane.WARNING_MESSAGE);
                result = 1;
            }else {
                JOptionPane.showMessageDialog(null,"该展览不存在，请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
                result = 0;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void insertinformation() {
        Connection con = null;
        int result = 0;
        try {
            if (!jtf1.getText().isEmpty() && !jtf2.getText().isEmpty() && !jtf3.getText().isEmpty() && !jtf4.getText().isEmpty() && !jtf5.getText().isEmpty()&& !jtf6.getText().isEmpty()) {
                con = DatabaseConnection.getConnection();
                String sql = "insert into Ticket values(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                TicketInformation mi = new TicketInformation();

                if (verify1() == 1) {
                    mi.setT_no(jtf1.getText());
                    mi.setT_name(jtf2.getText());
                    mi.setT_sex(jtf3.getText());
                    mi.setT_work(jtf4.getText());
                    mi.setE_no(jtf5.getText());
                    mi.setT_price(jtf6.getText());


                    ps.setString(1, mi.getT_no());
                    ps.setString(2, mi.getT_name());
                    ps.setString(3, mi.getT_sex());
                    ps.setString(4, mi.getT_work());
                    ps.setString(5, mi.getE_no());
                    ps.setString(6,mi.getT_price());

                    result = ps.executeUpdate();
                }
            }else {
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
        if (result == 1){
            JOptionPane.showMessageDialog(null,"购票成功","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("购票成功");
            clear();
        }else if (result == 0) {
            JOptionPane.showMessageDialog(null, "购票失败", "提示消息", JOptionPane.WARNING_MESSAGE);
            System.out.println("购票失败");
        }
    }

    public void clear(){
        jtf1.setText("");
        jtf2.setText("");
        jtf3.setText("");
        jtf4.setText("");
        jtf5.setText("");
        //jtf6.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回") {

        } else if (e.getActionCommand() == "购票") {
            insertinformation();
        }
    }
}
