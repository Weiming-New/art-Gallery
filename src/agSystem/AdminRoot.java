package agSystem;

import client.Hall.Hall;
import client.artist.Artist;
import client.artwork.Artwork;
import client.exhibition.Exhibition;
import client.exhibitionInfo.Info;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
管理员主界面
 */

public class AdminRoot extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6227226956418602689L;
	
	JButton jb1, jb2, jb3 ,jb4,jb5,jb6;
    JPanel jp1,jp2,jp3,jp4,jp5;
    JLabel jl1;

    public AdminRoot(){

        Font font = new Font("alias", Font.PLAIN, 22);
        Font font1 = new Font("alias", Font.PLAIN, 30);


        //加载图片
        ImageIcon icon=new ImageIcon("manage.jpg");
        Image icon2 =  Toolkit.getDefaultToolkit().getImage("huabi.jpg");
		this.setIconImage(icon2);

    //将图片放入label中
        JLabel label=new JLabel(icon);

      //设置label的大小
        label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
//
//        //获取窗口的第二层，将label放入
        this.getLayeredPane().add(label,Integer.valueOf(Integer.MIN_VALUE));
//
//        //获取frame的顶层容器,并设置为透明
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);

        jb1 = new JButton("艺术展信息管理");
        jb1.setBackground(Color.WHITE);
        jb1.setFont(font);
        jb2 = new JButton("艺术家管理");
        jb2.setBackground(Color.WHITE);
        jb2.setFont(font);
        jb3 = new JButton("展厅管理");
        jb3.setBackground(Color.WHITE);
        jb3.setFont(font);
        jb4 = new JButton("艺术品管理");
        jb4.setBackground(Color.WHITE);
        jb4.setFont(font);
        jb5 = new JButton("退出");
        jb5.setBackground(Color.WHITE);
        jb5.setFont(font);
        jb6 = new JButton("艺术展管理");
        jb6.setBackground(Color.WHITE);
        jb6.setFont(font);

        jl1 = new JLabel("管理员菜单");
        jl1.setFont(font1);
        jl1.setForeground(new Color(255,255,0));

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();


        jp1.add(jb1);
        jp1.add(jb2);
        jp1.add(jb6);
        jp2.add(jb3);
        jp2.add(jb4);
        jp4.add(jb5);
        jp3.add(jl1);

        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        jp4.setOpaque(false);

        this.add(jp3);
        this.add(jp1);
        this.add(jp2);
        this.add(jp4);

        this.setVisible(true);
        this.setTitle("艺术画廊管理系统");
        this.setLayout(new GridLayout(4, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(530, 200, icon.getIconWidth(), icon.getIconHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "退出"){
            System.exit(0);
        }else if (e.getActionCommand() == "艺术展信息管理"){
            new Info();
            this.dispose();
        }else if (e.getActionCommand() == "艺术家管理"){
            new Artist();
            this.dispose();
        }else if (e.getActionCommand() == "艺术品管理"){
            new Artwork();
            this.dispose();
        }else if (e.getActionCommand() == "展厅管理"){
            new Hall();
            this.dispose();
        }else if (e.getActionCommand() == "艺术展管理"){
            new Exhibition();
            this.dispose();
        }
    }
}
