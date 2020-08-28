package project_library;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import project_library.ui.frame.BookManagementFrame;

public class index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 10));
		
		JPanel pTitle = new JPanel();
		contentPane.add(pTitle);
		pTitle.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("영고대 도서관");
		lblNewLabel.setFont(new Font("휴먼엑스포", Font.PLAIN, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pTitle.add(lblNewLabel);
		
		JPanel pDepth1 = new JPanel();
		contentPane.add(pDepth1);
		pDepth1.setLayout(new GridLayout(0, 3, 20, 0));
		
		JPanel panel_2 = new JPanel();
		pDepth1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("기초 자료 관리");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		pDepth1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("도서 출납 관리");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		pDepth1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("도서 출납 통계");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_3);
		
		JPanel pDepth2_1 = new JPanel();
		contentPane.add(pDepth2_1);
		pDepth2_1.setLayout(new GridLayout(0, 3, 20, 0));
		
		JPanel panel_7 = new JPanel();
		pDepth2_1.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnBook = new JButton("도서 관리");
		btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookManagementFrame f = new BookManagementFrame();
				
				if(f.isVisible()){
					f.setVisible(false);
				}else {
					f.setVisible(true);
				}
			}
		});
		panel_7.add(btnBook);
		
		JPanel panel_6 = new JPanel();
		pDepth2_1.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnRental = new JButton("대여 관리");
		btnRental.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_6.add(btnRental);
		
		JPanel panel_8 = new JPanel();
		pDepth2_1.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnSearchMember = new JButton("회원 검색");
		btnSearchMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_8.add(btnSearchMember);
		
		JPanel pDepth2_2 = new JPanel();
		contentPane.add(pDepth2_2);
		pDepth2_2.setLayout(new GridLayout(0, 3, 20, 0));
		
		JPanel panel_14 = new JPanel();
		pDepth2_2.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnMember = new JButton("회원 관리");
		btnMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_14.add(btnMember);
		
		JPanel panel_11 = new JPanel();
		pDepth2_2.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnReturn = new JButton("반납 관리");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_11.add(btnReturn);
		
		JPanel panel_10 = new JPanel();
		pDepth2_2.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnSearchBook = new JButton("도서 검색");
		btnSearchBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_10.add(btnSearchBook);
		
		JPanel pDepth2_3 = new JPanel();
		contentPane.add(pDepth2_3);
		pDepth2_3.setLayout(new GridLayout(0, 3, 20, 0));
		
		JPanel panel_15 = new JPanel();
		pDepth2_3.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		pDepth2_3.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		pDepth2_3.add(panel_17);
		panel_17.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnBookInfo = new JButton("도서 현황");
		btnBookInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		panel_17.add(btnBookInfo);
	}

}
