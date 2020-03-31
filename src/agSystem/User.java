package agSystem;

import client.Hall.SelectHall;
import client.HallReserve.*;
import client.artist.SelectArtist;
import client.artwork.SelectArtwork;
import client.ticket.BuyTicket;
import client.ticket.DeleteTicket;
import client.ticket.SelectTicket;
import client.trade.BuyArtWorks;
import client.trade.DeleteTrade;
import client.trade.SelectTIno;

//import com.sun.org.apache.bcel.internal.generic.Select;

import ExhibitionInfo.SelectInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
客户主界面
 */

public class User extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4508697313736701899L;
	JMenuBar jMenuBar;
	JMenu jm1, jm2, jm3, jm4, jm5;
	JMenuItem jmt1, jmt2, jmt3, jmt4, jmt5, jmt6, jmt7, jmt8, jmt9, jmt10, jmt11, jmt12, jmt13, jmt14, jmt15, jmt16;
	JPanel jp1;
	JLabel jl1;

	public User() {

		// 加载图片
		ImageIcon icon = new ImageIcon("client1.jpg");

		// 将图片放入label中
		JLabel label = new JLabel(icon);

		// 设置label的大小
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

		// 获取窗口的第二层，将label放入
		this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));

		// 获取frame的顶层容器,并设置为透明
		JPanel j = (JPanel) this.getContentPane();
		j.setOpaque(false);
		jMenuBar = new JMenuBar();
		jm1 = new JMenu("展厅预约");
		jm1.addSeparator();
		jm2 = new JMenu("艺术展门票");
		jm2.addSeparator();
		jm3 = new JMenu("艺术品购买");
		jm3.addSeparator();
		jm4 = new JMenu("展览信息查询");

		jmt5 = new JMenuItem("预定门票");
		jmt6 = new JMenuItem("查询门票");
		jmt7 = new JMenuItem("取消订单");
		// jmt8 = new JMenuItem("修改门票信息");

		jmt1 = new JMenuItem("预约展厅");
		jmt2 = new JMenuItem("查询预约信息");
		jmt3 = new JMenuItem("取消预约");
		// jmt4 = new JMenuItem("修改预约信息");

		jmt9 = new JMenuItem("艺术品购买");
		jmt10 = new JMenuItem("查询采购信息");
		jmt11 = new JMenuItem("取消订单");
		// jmt12 = new JMenuItem("修改订单信息");

		jmt13 = new JMenuItem("展览信息查询");
		jmt14 = new JMenuItem("展厅查询");
		jmt15 = new JMenuItem("艺术家查询");
		jmt16 = new JMenuItem("艺术品查询");

		jm1.add(jmt1);
		jm1.add(jmt2);
		jm1.add(jmt3);
		// jm1.add(jmt4);

		jm2.add(jmt5);
		jm2.add(jmt6);
		jm2.add(jmt7);
		// jm2.add(jmt8);

		jm3.add(jmt9);
		jm3.add(jmt10);
		jm3.add(jmt11);
		// jm3.add(jmt12);

		jm4.add(jmt13);
		jm4.add(jmt14);
		jm4.add(jmt15);
		jm4.add(jmt16);

		jMenuBar.add(jm1);
		jMenuBar.add(jm2);
		jMenuBar.add(jm3);
		jMenuBar.add(jm4);
		setJMenuBar(jMenuBar);

		click();
		// this.add(jp1);
		this.setVisible(true);
		this.setTitle("艺术画廊管理系统");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setBounds(300, 200, 800, 500);
		this.setBounds(550, 240, icon.getIconWidth(), 590);
	}

	public void click() {
		jmt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InsertReserve();
			}
		});

		jmt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectRno();
			}
		});

		jmt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteReserve();
			}
		});

		jmt5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BuyTicket();
			}
		});

		jmt6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectTicket();
			}
		});

		jmt7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteTicket();
			}
		});

		jmt9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BuyArtWorks();
			}
		});

		jmt10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectTIno();
			}
		});

		jmt11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteTrade();
			}
		});

		jmt13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectInfo();
			}
		});

		jmt14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectHall();
			}
		});

		jmt15.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectArtist();
			}
		});

		jmt16.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectArtwork();
			}
		});
	}
}
