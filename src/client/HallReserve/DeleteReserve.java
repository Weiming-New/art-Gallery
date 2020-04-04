package client.HallReserve;

import javax.swing.*;

import function.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteReserve extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6796897621259538149L;
	
	JButton jb1,jb2;
    JPanel jp1,jp2,jp3;
    JTextField jt1;
    JLabel jl1,jl2;

    public int n;

    public DeleteReserve(){
        jb1 = new JButton("确定");
        //jb2 = new JButton("返回");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jt1 = new JTextField(8);
        jl1 = new JLabel("预约编号");
        jl2 = new JLabel("展厅预约系统");

        jb1.addActionListener(this);
        //jb2.addActionListener(this);

        jp1.add(jl2);
        jp2.add(jl1);
        jp2.add(jt1);
        jp3.add(jb1);
        //jp3.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setVisible(true);
        this.setBounds(700,300,600,400);
        this.setTitle("艺术画廊管理系统");
        this.setLayout(new GridLayout(6,4));
    }

    public int verify(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Reserve where RNO = ?");
            ps.setString(1,jt1.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                result = 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void delete(){
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from Reserve where RNO = ?");
            ps.setString(1,jt1.getText());
            ps.executeUpdate();
            //n = JOptionPane.showConfirmDialog(null, "确认删除", "标题",JOptionPane.YES_NO_OPTION);//返回的是按钮
            System.out.println("数据删除成功");
            JOptionPane.showMessageDialog(null,"取消成功","提示消息",JOptionPane.WARNING_MESSAGE);
            jt1.setText("");
            con.close();
            System.out.println("数据库关闭成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getActionCommand() == "确定"){
            if (verify() == 1) {
                delete();
            }else {
                JOptionPane.showMessageDialog(null,"该编号不存在，请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
                jt1.setText("");
            }
        }
    }
}
