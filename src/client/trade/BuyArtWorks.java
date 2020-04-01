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


public class BuyArtWorks extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4154065579756517915L;
	
	JTextField jt1,jt2,jt3,jt4,jt5,jt6;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
    JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8;
    JButton jb1,jb2;
    

    public BuyArtWorks(){


        jt1 = new JTextField(8);
        jt2 = new JTextField(8);
        jt3 = new JTextField(8);
        //jt4 = new JTextField(8);
        jt5 = new JTextField(8);
        //jt6 = new JTextField(8);

        jl1 = new JLabel("艺术品采购");
        jl2 = new JLabel("取票码");
        jl3 = new JLabel("姓名");
        jl4 = new JLabel("艺术品编号");
        jl6 = new JLabel("采购时间");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();


        jb1 = new JButton("购买");
        //jb2 = new JButton("返回");
        jb1.addActionListener(this);
        //jb2.addActionListener(this);

        jp1.add(jl1);

        jp2.add(jl2);
        jp2.add(jt1);
        jp2.add(jl3);
        jp2.add(jt2);

        jp3.add(jl4);
        jp3.add(jt3);
        //jp3.add(jl5);
        //jp3.add(jt4);

        jp3.add(jl6);
        jp3.add(jt5);
        //jp4.add(jl7);
        //jp4.add(jt6);

        jp5.add(jb1);
        //jp5.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        //this.add(jp4);
        this.add(jp5);

        this.setVisible(true);
        this.setTitle("艺术画廊管理系统");
        this.setBounds(700,300,600,400);
        this.setLayout(new GridLayout(6,4));
    }


    public void clear(){
        jt1.setText("");
        jt2.setText("");
        jt3.setText("");
//        jt4.setText("");
        jt5.setText("");
        //jt6.setText("");
    }

    //判断艺术品编号是否存在
    public int verify2(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from ArtWork where AWno = ?");
            ps.setString(1,jt3.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null,"该编号存在","提示消息",JOptionPane.WARNING_MESSAGE);
                result = 1;
            }else {
                JOptionPane.showMessageDialog(null,"该编号不存在，请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
                result = 0;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    //设置该艺术品的状态
    public void isBuy(){
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            String sql = "update ArtWork set AWsold = '1' where AWno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,jt3.getText());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void buyArtworks() {
        Connection con = null;
        
        int result = 0;
        try{
            if (!jt1.getText().isEmpty() && !jt2.getText().isEmpty() && !jt3.getText().isEmpty() && !jt5.getText().isEmpty()) {
                con = DatabaseConnection.getConnection();
                String sql = "insert into TradeInfo values (?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                Trade pi = new Trade();
                if ((verify2() == 1)) {
                    pi.setTi_no(jt1.getText());
                    pi.setTi_name(jt2.getText());
                    pi.setAw_no(jt3.getText());
                    pi.setTime(jt5.getText());
                    ps.setString(1, pi.getTi_no());
                    ps.setString(2, pi.getTi_name());
                    ps.setString(3, pi.getAw_no());
                    ps.setString(4, pi.getTi_time());
                    result = ps.executeUpdate();
                }
            }else {
                JOptionPane.showMessageDialog(null, "请输入完整信息", "提示消息", JOptionPane.WARNING_MESSAGE);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }if (result == 1){
            isBuy();
            JOptionPane.showMessageDialog(null,"购买成功","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("购买成功");
            clear();
        }else if (result == 0){
            JOptionPane.showMessageDialog(null,"购买失败，艺术品已售出","提示消息",JOptionPane.WARNING_MESSAGE);
            System.out.println("购买失败");
            clear();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "返回"){

        }else if (e.getActionCommand() == "购买") {
            if (verify2() == 1) {
                buyArtworks();
            }else {
                clear();
            }
        }
    }
}
