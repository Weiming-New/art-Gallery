package client.trade;

import javax.swing.*;

import function.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteTrade extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6966931113394085856L;
	
	JButton jb1,jb2;
    JPanel jp1,jp2,jp3;
    JTextField jt1;
    JLabel jl1,jl2;

    public DeleteTrade(){
        jb1 = new JButton("确定");
        //jb2 = new JButton("返回");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jt1 = new JTextField(8);
        jl1 = new JLabel("购买订单编号");
        jl2 = new JLabel("艺术品采购系统");

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

    
 // 设置该艺术品的状态
 	public void nosold() {
 		Connection con = null;
 		try {
 			con = DatabaseConnection.getConnection();
 			String sql = "update ArtWork set AWsold = '0' where AWno = (select AWno from TradeInfo where TIno = ?)";
 			PreparedStatement ps = con.prepareStatement(sql);
 			ps.setString(1, jt1.getText());
 			ps.executeUpdate();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 	}
 	
    public int verify(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from TradeInfo where TIno = ?");
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
            PreparedStatement ps = con.prepareStatement("delete from TradeInfo where TIno = ?");
            ps.setString(1,jt1.getText());
            ps.executeUpdate();
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
            	nosold();
                delete();
            }else {
                JOptionPane.showMessageDialog(null,"该订单编号不存在，请重新输入","提示消息",JOptionPane.WARNING_MESSAGE);
                jt1.setText("");
            }
        }
    }
}
