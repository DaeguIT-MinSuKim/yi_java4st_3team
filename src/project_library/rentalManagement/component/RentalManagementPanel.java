package project_library.rentalManagement.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class RentalManagementPanel extends JPanel {
	private JTextField tfMno;
	private JTextField tfMname;
	private JTextField tfMau;
	private JTextField tfMpu;
	private JTextField tfMpr;
	private JTextField tfBcnt;
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfTel;

	/**
	 * Create the panel.
	 */
	public RentalManagementPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel01 = new JPanel();
		panel01.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel01);
		GridBagLayout gbl_panel01 = new GridBagLayout();
		gbl_panel01.columnWidths = new int[]{102, 102, 0};
		gbl_panel01.rowHeights = new int[]{45, 45, 45, 45, 45, 45, 0};
		gbl_panel01.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel01.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel01.setLayout(gbl_panel01);
		
		JLabel lblMno = new JLabel("도서코드:");
		lblMno.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblMno = new GridBagConstraints();
		gbc_lblMno.fill = GridBagConstraints.BOTH;
		gbc_lblMno.insets = new Insets(0, 0, 5, 5);
		gbc_lblMno.gridx = 0;
		gbc_lblMno.gridy = 0;
		panel01.add(lblMno, gbc_lblMno);
		
		tfMno = new JTextField();
		tfMno.setHorizontalAlignment(SwingConstants.CENTER);
		tfMno.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_tfMno = new GridBagConstraints();
		gbc_tfMno.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMno.insets = new Insets(0, 0, 5, 0);
		gbc_tfMno.gridx = 1;
		gbc_tfMno.gridy = 0;
		panel01.add(tfMno, gbc_tfMno);
		tfMno.setColumns(10);
		
		JLabel lblMname = new JLabel("도 서 명 : ");
		lblMname.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblMname = new GridBagConstraints();
		gbc_lblMname.fill = GridBagConstraints.BOTH;
		gbc_lblMname.insets = new Insets(0, 0, 5, 5);
		gbc_lblMname.gridx = 0;
		gbc_lblMname.gridy = 1;
		panel01.add(lblMname, gbc_lblMname);
		
		tfMname = new JTextField();
		tfMname.setHorizontalAlignment(SwingConstants.CENTER);
		tfMname.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfMname.setColumns(10);
		GridBagConstraints gbc_tfMname = new GridBagConstraints();
		gbc_tfMname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMname.insets = new Insets(0, 0, 5, 0);
		gbc_tfMname.gridx = 1;
		gbc_tfMname.gridy = 1;
		panel01.add(tfMname, gbc_tfMname);
		
		JLabel lblMau = new JLabel("저     자 : ");
		lblMau.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblMau = new GridBagConstraints();
		gbc_lblMau.fill = GridBagConstraints.BOTH;
		gbc_lblMau.insets = new Insets(0, 0, 5, 5);
		gbc_lblMau.gridx = 0;
		gbc_lblMau.gridy = 2;
		panel01.add(lblMau, gbc_lblMau);
		
		tfMau = new JTextField();
		tfMau.setHorizontalAlignment(SwingConstants.CENTER);
		tfMau.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfMau.setColumns(10);
		GridBagConstraints gbc_tfMau = new GridBagConstraints();
		gbc_tfMau.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMau.insets = new Insets(0, 0, 5, 0);
		gbc_tfMau.gridx = 1;
		gbc_tfMau.gridy = 2;
		panel01.add(tfMau, gbc_tfMau);
		
		JLabel lblMpu = new JLabel("출 판 사 : ");
		lblMpu.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblMpu = new GridBagConstraints();
		gbc_lblMpu.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMpu.insets = new Insets(0, 0, 5, 5);
		gbc_lblMpu.gridx = 0;
		gbc_lblMpu.gridy = 3;
		panel01.add(lblMpu, gbc_lblMpu);
		
		tfMpu = new JTextField();
		tfMpu.setHorizontalAlignment(SwingConstants.CENTER);
		tfMpu.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfMpu.setColumns(10);
		GridBagConstraints gbc_tfMpu = new GridBagConstraints();
		gbc_tfMpu.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMpu.insets = new Insets(0, 0, 5, 0);
		gbc_tfMpu.gridx = 1;
		gbc_tfMpu.gridy = 3;
		panel01.add(tfMpu, gbc_tfMpu);
		
		JLabel lblMpr = new JLabel("가     격 : ");
		lblMpr.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblMpr = new GridBagConstraints();
		gbc_lblMpr.fill = GridBagConstraints.BOTH;
		gbc_lblMpr.insets = new Insets(0, 0, 5, 5);
		gbc_lblMpr.gridx = 0;
		gbc_lblMpr.gridy = 4;
		panel01.add(lblMpr, gbc_lblMpr);
		
		tfMpr = new JTextField();
		tfMpr.setHorizontalAlignment(SwingConstants.CENTER);
		tfMpr.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfMpr.setColumns(10);
		GridBagConstraints gbc_tfMpr = new GridBagConstraints();
		gbc_tfMpr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMpr.insets = new Insets(0, 0, 5, 0);
		gbc_tfMpr.gridx = 1;
		gbc_tfMpr.gridy = 4;
		panel01.add(tfMpr, gbc_tfMpr);
		
		JLabel lblMcnt = new JLabel("총대여횟수 : ");
		lblMcnt.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblMcnt = new GridBagConstraints();
		gbc_lblMcnt.fill = GridBagConstraints.BOTH;
		gbc_lblMcnt.insets = new Insets(0, 0, 0, 5);
		gbc_lblMcnt.gridx = 0;
		gbc_lblMcnt.gridy = 5;
		panel01.add(lblMcnt, gbc_lblMcnt);
		
		tfBcnt = new JTextField();
		tfBcnt.setHorizontalAlignment(SwingConstants.CENTER);
		tfBcnt.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfBcnt.setColumns(10);
		GridBagConstraints gbc_tfBcnt = new GridBagConstraints();
		gbc_tfBcnt.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBcnt.gridx = 1;
		gbc_tfBcnt.gridy = 5;
		panel01.add(tfBcnt, gbc_tfBcnt);
		
		JPanel panel02 = new JPanel();
		panel02.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel02);
		GridBagLayout gbl_panel02 = new GridBagLayout();
		gbl_panel02.columnWidths = new int[]{102, 102, 0};
		gbl_panel02.rowHeights = new int[]{54, 54, 54, 54, 54, 0};
		gbl_panel02.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel02.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel02.setLayout(gbl_panel02);
		
		JLabel lblNo = new JLabel("회원코드 :");
		lblNo.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblNo = new GridBagConstraints();
		gbc_lblNo.fill = GridBagConstraints.BOTH;
		gbc_lblNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNo.gridx = 0;
		gbc_lblNo.gridy = 0;
		panel02.add(lblNo, gbc_lblNo);
		
		tfNo = new JTextField();
		tfNo.setHorizontalAlignment(SwingConstants.CENTER);
		tfNo.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_tfNo = new GridBagConstraints();
		gbc_tfNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNo.insets = new Insets(0, 0, 5, 0);
		gbc_tfNo.gridx = 1;
		gbc_tfNo.gridy = 0;
		panel02.add(tfNo, gbc_tfNo);
		tfNo.setColumns(10);
		
		JLabel lblName = new JLabel("성     명 : ");
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.BOTH;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		panel02.add(lblName, gbc_lblName);
		
		tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfName.setColumns(10);
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.insets = new Insets(0, 0, 5, 0);
		gbc_tfName.gridx = 1;
		gbc_tfName.gridy = 1;
		panel02.add(tfName, gbc_tfName);
		
		JLabel lblTel = new JLabel("전화번호  : ");
		lblTel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblTel = new GridBagConstraints();
		gbc_lblTel.fill = GridBagConstraints.BOTH;
		gbc_lblTel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTel.gridx = 0;
		gbc_lblTel.gridy = 2;
		panel02.add(lblTel, gbc_lblTel);
		
		tfTel = new JTextField();
		tfTel.setHorizontalAlignment(SwingConstants.CENTER);
		tfTel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfTel.setColumns(10);
		GridBagConstraints gbc_tfTel = new GridBagConstraints();
		gbc_tfTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTel.insets = new Insets(0, 0, 5, 0);
		gbc_tfTel.gridx = 1;
		gbc_tfTel.gridy = 2;
		panel02.add(tfTel, gbc_tfTel);
		
		JPanel panel03 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel03.getLayout();
		flowLayout.setHgap(0);
		add(panel03);
		
		JButton btnSearch = new JButton("검색");
		panel03.add(btnSearch);

	}

}
