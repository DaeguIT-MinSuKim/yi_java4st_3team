package project_library.ui.component;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import project_library.dto.ReturnManagement;
import project_library.ui.frame.ReturnManagementFrame;

@SuppressWarnings("serial")
public class ReturnManagementPanel extends JPanel {
	private JTextField tfBno;
	private JTextField tfBname;
	private JTextField tfBau;
	private JTextField tfBpu;
	private JTextField tfBpr;
	private JTextField tfBcnt;
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfTel;
	private JTextField tfBDate;
	private JTextField tfRDate;

	/**
	 * Create the panel.
	 */
	public ReturnManagementPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel01 = new JPanel();
		panel01.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel01);
		GridBagLayout gbl_panel01 = new GridBagLayout();
		gbl_panel01.columnWidths = new int[]{102, 102, 0};
		gbl_panel01.rowHeights = new int[]{45, 45, 45, 45, 45, 45, 0};
		gbl_panel01.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel01.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel01.setLayout(gbl_panel01);
		
		JLabel lblBno = new JLabel("도서코드:");
		lblBno.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblBno = new GridBagConstraints();
		gbc_lblBno.fill = GridBagConstraints.BOTH;
		gbc_lblBno.insets = new Insets(0, 0, 5, 5);
		gbc_lblBno.gridx = 0;
		gbc_lblBno.gridy = 0;
		panel01.add(lblBno, gbc_lblBno);
		
		tfBno = new JTextField();
		tfBno.setHorizontalAlignment(SwingConstants.CENTER);
		tfBno.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_tfBno = new GridBagConstraints();
		gbc_tfBno.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBno.insets = new Insets(0, 0, 5, 0);
		gbc_tfBno.gridx = 1;
		gbc_tfBno.gridy = 0;
		panel01.add(tfBno, gbc_tfBno);
		tfBno.setColumns(10);
		
		JLabel lblBname = new JLabel("도 서 명 : ");
		lblBname.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblBname = new GridBagConstraints();
		gbc_lblBname.fill = GridBagConstraints.BOTH;
		gbc_lblBname.insets = new Insets(0, 0, 5, 5);
		gbc_lblBname.gridx = 0;
		gbc_lblBname.gridy = 1;
		panel01.add(lblBname, gbc_lblBname);
		
		tfBname = new JTextField();
		tfBname.setHorizontalAlignment(SwingConstants.CENTER);
		tfBname.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfBname.setColumns(10);
		GridBagConstraints gbc_tfBname = new GridBagConstraints();
		gbc_tfBname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBname.insets = new Insets(0, 0, 5, 0);
		gbc_tfBname.gridx = 1;
		gbc_tfBname.gridy = 1;
		panel01.add(tfBname, gbc_tfBname);
		
		JLabel lblBau = new JLabel("저     자 : ");
		lblBau.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblBau = new GridBagConstraints();
		gbc_lblBau.fill = GridBagConstraints.BOTH;
		gbc_lblBau.insets = new Insets(0, 0, 5, 5);
		gbc_lblBau.gridx = 0;
		gbc_lblBau.gridy = 2;
		panel01.add(lblBau, gbc_lblBau);
		
		tfBau = new JTextField();
		tfBau.setHorizontalAlignment(SwingConstants.CENTER);
		tfBau.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfBau.setColumns(10);
		GridBagConstraints gbc_tfBau = new GridBagConstraints();
		gbc_tfBau.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBau.insets = new Insets(0, 0, 5, 0);
		gbc_tfBau.gridx = 1;
		gbc_tfBau.gridy = 2;
		panel01.add(tfBau, gbc_tfBau);
		
		JLabel lblBpu = new JLabel("출 판 사 : ");
		lblBpu.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblBpu = new GridBagConstraints();
		gbc_lblBpu.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBpu.insets = new Insets(0, 0, 5, 5);
		gbc_lblBpu.gridx = 0;
		gbc_lblBpu.gridy = 3;
		panel01.add(lblBpu, gbc_lblBpu);
		
		tfBpu = new JTextField();
		tfBpu.setHorizontalAlignment(SwingConstants.CENTER);
		tfBpu.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfBpu.setColumns(10);
		GridBagConstraints gbc_tfBpu = new GridBagConstraints();
		gbc_tfBpu.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBpu.insets = new Insets(0, 0, 5, 0);
		gbc_tfBpu.gridx = 1;
		gbc_tfBpu.gridy = 3;
		panel01.add(tfBpu, gbc_tfBpu);
		
		JLabel lblBpr = new JLabel("가     격 : ");
		lblBpr.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblBpr = new GridBagConstraints();
		gbc_lblBpr.fill = GridBagConstraints.BOTH;
		gbc_lblBpr.insets = new Insets(0, 0, 5, 5);
		gbc_lblBpr.gridx = 0;
		gbc_lblBpr.gridy = 4;
		panel01.add(lblBpr, gbc_lblBpr);
		
		tfBpr = new JTextField();
		tfBpr.setHorizontalAlignment(SwingConstants.CENTER);
		tfBpr.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfBpr.setColumns(10);
		GridBagConstraints gbc_tfBpr = new GridBagConstraints();
		gbc_tfBpr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBpr.insets = new Insets(0, 0, 5, 0);
		gbc_tfBpr.gridx = 1;
		gbc_tfBpr.gridy = 4;
		panel01.add(tfBpr, gbc_tfBpr);
		
		JLabel lblBcnt = new JLabel("총대여횟수 : ");
		lblBcnt.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblBcnt = new GridBagConstraints();
		gbc_lblBcnt.fill = GridBagConstraints.BOTH;
		gbc_lblBcnt.insets = new Insets(0, 0, 0, 5);
		gbc_lblBcnt.gridx = 0;
		gbc_lblBcnt.gridy = 5;
		panel01.add(lblBcnt, gbc_lblBcnt);
		
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
		
		JLabel lblBDate = new JLabel("대 여 일 : ");
		lblBDate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblBDate = new GridBagConstraints();
		gbc_lblBDate.fill = GridBagConstraints.BOTH;
		gbc_lblBDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblBDate.gridx = 0;
		gbc_lblBDate.gridy = 3;
		panel02.add(lblBDate, gbc_lblBDate);
		
		tfBDate = new JTextField();
		tfBDate.setHorizontalAlignment(SwingConstants.CENTER);
		tfBDate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfBDate.setColumns(10);
		GridBagConstraints gbc_tfBDate = new GridBagConstraints();
		gbc_tfBDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBDate.insets = new Insets(0, 0, 5, 0);
		gbc_tfBDate.gridx = 1;
		gbc_tfBDate.gridy = 3;
		panel02.add(tfBDate, gbc_tfBDate);
		
		JLabel lblRDate = new JLabel("반 납 일 : ");
		lblRDate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblRDate = new GridBagConstraints();
		gbc_lblRDate.fill = GridBagConstraints.BOTH;
		gbc_lblRDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblRDate.gridx = 0;
		gbc_lblRDate.gridy = 4;
		panel02.add(lblRDate, gbc_lblRDate);
		
		tfRDate = new JTextField();
		tfRDate.setHorizontalAlignment(SwingConstants.CENTER);
		tfRDate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfRDate.setColumns(10);
		GridBagConstraints gbc_tfRDate = new GridBagConstraints();
		gbc_tfRDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfRDate.gridx = 1;
		gbc_tfRDate.gridy = 4;
		panel02.add(tfRDate, gbc_tfRDate);

	}

	protected void setReturnManagementDto(ReturnManagement bdt) {
		ReturnManagementFrame.pRPanel.setItem(bdt);
	}

	private void setItem(ReturnManagement bdt) {
		tfBno.setText(bdt.getBookCode());
		tfBname.setText(bdt.getBookName());
		tfBau.setText(bdt.getAuthor());
		tfBpu.setText(bdt.getPublisher());
		tfBpr.setText(bdt.getPrice() + "");
		tfBcnt.setText(bdt.getTotalRental() + "");
	}

	public void setEditalbeTableTrueTf() {
		// TODO Auto-generated method stub
		tfBno.setEditable(false);
		tfBname.setEditable(false);
		tfBau.setEditable(false);
		tfBpu.setEditable(false);
		tfBpr.setEditable(false);
		tfBcnt.setEditable(false);
		tfNo.setEditable(false);
		tfName.setEditable(false);
		tfTel.setEditable(false);
		tfBDate.setEditable(false);
		tfRDate.setEditable(false);
	}
}
