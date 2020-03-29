package view;


import javax.swing.*;

import function.Verify;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
登录主界面
 */

public class MainView extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6498329542920525856L;
	
	private ButtonGroup group;
    //门面模式对象
    Verify fcd = new Verify();

    //定义登录界面的组件
    JButton jb1, jb2, jb3 = null;
    JRadioButton jrb1, jrb2 = null;
    JPanel jp1, jp2, jp3, jp4, jp5 = null;
    JTextField jtf = null;
    JLabel jlb1, jlb2, jlb3 = null;
    JPasswordField jpf = null;

    String managername = "\\w{3,6}";
    String username = "\\w{7,11}";

    public static void main(String[] args) {
        //InitGloalFont.InitglobalFont(new Font("alias", Font.PLAIN, 22));
        @SuppressWarnings("unused")
		MainView mainView = new MainView();
    }

    public MainView() {

        Font font = new Font("alias", Font.PLAIN, 22);

        //加载图片
        //ImageIcon icon = new ImageIcon("image5.png");
        ImageIcon icon = new ImageIcon("lfg_main.jpg");
//
//        //将图片放入label中
        JLabel label = new JLabel(icon);
//
//        //设置label的大小
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
//
//        //获取窗口的第二层，将label放入
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
//
//        //获取frame的顶层容器,并设置为透明
        JPanel j = (JPanel) this.getContentPane();
        j.setOpaque(false);


        //创建组件
        jb1 = new JButton("登录");
        jb1.setFont(font);
        //jb1.setBounds(150,230,70,22);
        jb1.setBackground(Color.WHITE);
        jb2 = new JButton("注册");
        jb2.setFont(font);
        //jb1.setBounds(150,230,70,22);
        jb2.setBackground(Color.white);
        jb3 = new JButton("退出");
        jb3.setFont(font);
        //jb1.setBounds(150,230,70,22);
        jb3.setBackground(Color.white);

        //设置监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        jlb3 = new JLabel("欢迎使用艺术画廊管理系统");
        jlb3.setFont(font);
        jlb3.setForeground(new Color(255,255,100));

        Font font2 = new Font("楷体", Font.PLAIN, 20);
        jrb1 = new JRadioButton("管理员");
        jrb1.setFont(font2);
        jrb2 = new JRadioButton("客户");
        jrb2.setFont(font2);

        group = new ButtonGroup();
        group.add(jrb1);
        group.add(jrb2);

        jlb1 = new JLabel("用户名：");
        //jlb1.setBounds(100,120,200,30);
        jtf = new JTextField(10);
        //jtf.setBounds(150,120,150,30);
        jlb1.setFont(font);
        jlb1.setForeground(new Color(255,255,0));
        jtf.setFont(font);

        jlb2 = new JLabel("密    码：");
        //jlb2.setBounds(100,180,200,30);
        jlb2.setFont(font);
        jlb2.setForeground(new Color(255,255,0));
        jpf = new JPasswordField(10);
        //jpf.setBounds(150,180,150,30);
        jpf.setFont(font);


        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();

        jp4.add(jlb3);
        jp1.add(jlb1);
        jp1.add(jtf);

        jp2.add(jlb2);
        jp2.add(jpf);


        jp3.add(jp4);
        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);

        jp5.add(jrb1);
        jp5.add(jrb2);

        //必须设置为透明的。否则看不到图片
        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        jp4.setOpaque(false);
        jp5.setOpaque(false);


        this.add(jp4);
        this.add(jp1);
        this.add(jp2);
        this.add(jp5);
        this.add(jp3);

        this.setVisible(true);
        this.setTitle("艺术画廊管理系统");
        this.setLayout(new GridLayout(5, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(600,280,icon.getIconWidth(),icon.getIconHeight());
    }

    @SuppressWarnings("deprecation")
	@Override
    public void actionPerformed(ActionEvent e) {

        //监听各个按钮
        if (e.getActionCommand() == "退出") {
            System.exit(0);
        } else if (e.getActionCommand() == "登录") {
            //进行判断，为空则不进行登录操作。
            if (jtf.getText().isEmpty() || jpf.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "请输入用户名和密码", "提示信息", JOptionPane.WARNING_MESSAGE);
            else {
                //调用登录方法
                if (jrb1.isSelected()) {
                    boolean name = jtf.getText().matches(managername);
                    if (name == true) {
                        login1();
                    }else {
                        JOptionPane.showMessageDialog(null,"用户名长度在3-6位之间","提示消息",JOptionPane.WARNING_MESSAGE);
                    }
                } else if (jrb2.isSelected()) {
                    boolean name = jtf.getText().matches(username);
                    if (name == true) {
                        login2();
                    }else {
                        JOptionPane.showMessageDialog(null,"用户名长度在7-11位之间","提示消息",JOptionPane.WARNING_MESSAGE);
                   }
                }
            }
        } else if (e.getActionCommand() == "注册") {
            //调用注册方法
            this.Regis();
        }

    }

    //注册方法
    public void Regis() {
        new RegisterView();   //打开新界面
        this.dispose();  //关闭当前界面

    }

    //管理员登录方法
    @SuppressWarnings("deprecation")
	public void login1() {//DatabaseConnection.getConnection();
        fcd.SQLverify1(jtf.getText(), jpf.getText());
        jtf.setText("");
        jpf.setText("");
        //this.dispose();
    }

    //客户登录方法
    @SuppressWarnings("deprecation")
	public void login2() {

        fcd.SQLverify2(jtf.getText(), jpf.getText());
        jtf.setText("");
        jpf.setText("");
        //this.dispose();
    }
}