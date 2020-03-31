package agSystem;

import client.Hall.SelectHall;
import client.HallReserve.*;
import client.artist.SelectArtist;
import client.artist.SelectArtistName;
import client.artwork.SelectArtwork;
import client.exhibitionInfo.SelectInfo;

import client.artwork.SelectArtworkKind;
import client.artwork.SelectArtworkPrice;
import client.ticket.BuyTicket;
import client.ticket.DeleteTicket;
import client.ticket.SelectTicket;
import client.trade.BuyArtWorks;
import client.trade.DeleteTrade;
import client.trade.SelectTIno;

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
	JMenu jm1, jm2, jm3, jm4, jm5, jm6;
	JMenuItem jmIt1, jmIt2, jmIt3, jmIt4, jmIt5, jmIt6, jmIt7, jmIt8, jmIt9, jmIt10, jmIt11, jmIt12, jmIt13, jmIt14,
			jmIt15, jmIt18, jmIt16, jmIt17;
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
		jm4 = new JMenu("艺术展信息查询");
		jm4.addSeparator();
		jm5 = new JMenu("艺术家信息查询");
		jm5.addSeparator();
		jm6 = new JMenu("艺术品信息查询");

		jmIt5 = new JMenuItem("预定门票");
		jmIt6 = new JMenuItem("查询门票");
		jmIt7 = new JMenuItem("取消订单");

		jmIt1 = new JMenuItem("预约展厅");
		jmIt2 = new JMenuItem("查询预约信息");
		jmIt3 = new JMenuItem("取消预约");

		jmIt9 = new JMenuItem("艺术品购买");
		jmIt10 = new JMenuItem("查询采购信息");
		jmIt11 = new JMenuItem("取消订单");

		jmIt13 = new JMenuItem("展览信息查询");
		jmIt14 = new JMenuItem("展厅查询");
		jmIt15 = new JMenuItem("所有艺术家查询");
		jmIt17 = new JMenuItem("艺术家姓名查询");

		jmIt16 = new JMenuItem("所有艺术品查询");
		jmIt8 = new JMenuItem("艺术品类别查询");
		jmIt18 = new JMenuItem("艺术品价格查询");

		jm1.add(jmIt1);
		jm1.add(jmIt2);
		jm1.add(jmIt3);

		jm2.add(jmIt5);
		jm2.add(jmIt6);
		jm2.add(jmIt7);

		jm3.add(jmIt9);
		jm3.add(jmIt10);
		jm3.add(jmIt11);

		jm4.add(jmIt13);
		jm4.add(jmIt14);

		// 艺术家
		jm5.add(jmIt15);
		jm5.add(jmIt17);

		// 艺术品
		jm6.add(jmIt16);
		jm6.add(jmIt8);
		jm6.add(jmIt18);

		jMenuBar.add(jm1);
		jMenuBar.add(jm2);
		jMenuBar.add(jm3);
		jMenuBar.add(jm4);
		jMenuBar.add(jm5);
		jMenuBar.add(jm6);
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
		jmIt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InsertReserve();
			}
		});

		jmIt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectRno();
			}
		});

		jmIt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteReserve();
			}
		});

		jmIt5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BuyTicket();
			}
		});

		jmIt6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectTicket();
			}
		});

		jmIt7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteTicket();
			}
		});

		jmIt9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BuyArtWorks();
			}
		});

		jmIt10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectTIno();
			}
		});

		jmIt11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteTrade();
			}
		});

		jmIt13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectInfo();
			}
		});

		jmIt14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectHall();
			}
		});

		jmIt15.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectArtist();
			}
		});

		jmIt17.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectArtistName();
			}
		});

		jmIt16.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectArtwork();
			}
		});
		
		jmIt8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectArtworkKind();
			}
		});
		
		jmIt18.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectArtworkPrice();
			}
		});
		
	}
}
