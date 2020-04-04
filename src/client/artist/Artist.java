package client.artist;

import javax.swing.*;

import agSystem.AdminRoot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Artist extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7582317366900809626L;
	
	JButton jb1, jb2, jb3, jb4, jb5;
	JLabel jl1;
	JPanel jp1, jp2, jp3, jp4 = null;

	public Artist() {

		Font font = new Font("alias", Font.PLAIN, 22);

		// 加载图片
		ImageIcon icon = new ImageIcon("lfg_main.png");
		Image icon2 =  Toolkit.getDefaultToolkit().getImage("huabi.jpg");
		this.setIconImage(icon2);
//
//        //将图片放入label中
		JLabel label = new JLabel(icon);
//
//        //设置label的大小
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
//
//        //获取窗口的第二层，将label放入
		this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
//
//        //获取frame的顶层容器,并设置为透明
		JPanel j = (JPanel) this.getContentPane();
		j.setOpaque(false);

		jb1 = new JButton("添加艺术家");
		jb1.setBackground(Color.WHITE);
		jb1.setFont(font);
		jb2 = new JButton("删除艺术家");
		jb2.setBackground(Color.WHITE);
		jb2.setFont(font);
		jb3 = new JButton("查询艺术家信息");
		jb3.setBackground(Color.WHITE);
		jb3.setFont(font);
		jb4 = new JButton("修改艺术家信息");
		jb4.setBackground(Color.WHITE);
		jb4.setFont(font);
		jb5 = new JButton("返回");
		jb5.setBackground(Color.WHITE);
		jb5.setFont(font);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);

		jl1 = new JLabel("                 ");
		jl1.setFont(font);
		jp4 = new JPanel();

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp3.add(jb5);
		jp4.add(jl1);

		jp1.setOpaque(false);
		jp2.setOpaque(false);
		jp3.setOpaque(false);
		jp4.setOpaque(false);

		this.add(jp4);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);

		this.setTitle("Art Gallery管理系统");
		this.setVisible(true);
		this.setLayout(new GridLayout(5, 4));
		this.setBounds(628, 260, 752, 471);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "添加艺术家") {
			// dispose();
			new InsertArtist();
		} else if (e.getActionCommand() == "删除艺术家") {
			// dispose();
			new DeleteArtist();
		} else if (e.getActionCommand() == "修改艺术家信息") {
			// dispose();
			new UpdateArtist();
		} else if (e.getActionCommand() == "查询艺术家信息") {
			new SelectArtist();
		} else if (e.getActionCommand() == "返回") {
			new AdminRoot();
			dispose();
		}
	}
}
