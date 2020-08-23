package project_library.ui.component;

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

import project_library.dto.BookManagement;
import project_library.dto.RentalManagement;
import project_library.ui.frame.BookManagementFrame;
import project_library.ui.frame.RentalManagementFrame;

import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class RentalManagementPanel extends JPanel implements MouseListener  {
	private JPanel panelBook;
	private JPanel panelMember;
	private JLabel lblBookNo;
	private JTextField tfBookNo;
	private JLabel lblBookName;
	private JTextField tfBookName;
	private JLabel lblAu;
	private JTextField tfAu;
	private JLabel lblPu;
	private JTextField tfPu;
	private JLabel lblPr;
	private JTextField tfPr;
	private JLabel lblTotal;
	private JTextField tfTotal;
	private JLabel lblMemberNo;
	private JTextField tfMemberNo;
	private JLabel lblMemberName;
	private JTextField tfMemberName;
	private JLabel lblEmpty;
	private JTextField tfPhone;
	private JButton btnSearch;
	private JLabel lblPhone;

	public RentalManagementPanel() {
		initComponents();
		
		/*
		 * 프로그램 시작시 동작
		 * */
		// 01. 텍스트필드 비활성화
		setEditalbeFalseTf(); 
	}

	private void initComponents() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(0, 2, 10, 0));
		
		panelBook = new JPanel();
		add(panelBook);
		panelBook.setLayout(new GridLayout(0, 2, 10, 5));
		
		lblBookNo = new JLabel("도서코드 :");
		lblBookNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBook.add(lblBookNo);
		
		tfBookNo = new JTextField();
		panelBook.add(tfBookNo);
		tfBookNo.setColumns(10);
		
		lblBookName = new JLabel("도 서 명 :");
		lblBookName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBook.add(lblBookName);
		
		tfBookName = new JTextField();
		tfBookName.setColumns(10);
		panelBook.add(tfBookName);
		
		lblAu = new JLabel("저 자 :");
		lblAu.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBook.add(lblAu);
		
		tfAu = new JTextField();
		tfAu.setColumns(10);
		panelBook.add(tfAu);
		
		lblPu = new JLabel("출 판 사 :");
		lblPu.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBook.add(lblPu);
		
		tfPu = new JTextField();
		tfPu.setColumns(10);
		panelBook.add(tfPu);
		
		lblPr = new JLabel("가 격 :");
		lblPr.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBook.add(lblPr);
		
		tfPr = new JTextField();
		tfPr.setColumns(10);
		panelBook.add(tfPr);
		
		lblTotal = new JLabel("총대여횟수 :");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBook.add(lblTotal);
		
		tfTotal = new JTextField();
		tfTotal.setColumns(10);
		panelBook.add(tfTotal);
		
		panelMember = new JPanel();
		add(panelMember);
		panelMember.setLayout(new GridLayout(0, 3, 10, 5));
		
		lblMemberNo = new JLabel("회원코드 :");
		lblMemberNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMember.add(lblMemberNo);
		
		tfMemberNo = new JTextField();
		panelMember.add(tfMemberNo);
		tfMemberNo.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addMouseListener(this);
		panelMember.add(btnSearch);
		
		lblMemberName = new JLabel("성 명 :");
		lblMemberName.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMember.add(lblMemberName);
		
		tfMemberName = new JTextField();
		tfMemberName.setColumns(10);
		panelMember.add(tfMemberName);
		
		lblEmpty = new JLabel("");
		panelMember.add(lblEmpty);
		
		lblPhone = new JLabel("전화번호 :");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMember.add(lblPhone);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		panelMember.add(tfPhone);
	}

	// 텍스트필드 수정 불가능
	public void setEditalbeFalseTf() {
		tfBookNo.setEditable(false);
		tfBookName.setEditable(false);
		tfAu.setEditable(false);
		tfPu.setEditable(false);
		tfPr.setEditable(false);
		tfTotal.setEditable(false);
		tfMemberNo.setEditable(false);
		tfMemberName.setEditable(false);
		tfPhone.setEditable(false);
	}
	
	// Table 클릭 시 01. 텍스트필드 활성화/비활성화.
	public void setEditalbeTableTrueTf() {
		tfBookNo.setEditable(false);
		tfBookName.setEditable(false);
		tfAu.setEditable(false);
		tfPu.setEditable(false);
		tfPr.setEditable(false);
		tfTotal.setEditable(false);
		tfMemberNo.setEditable(true);
		tfMemberName.setEditable(false);
		tfPhone.setEditable(false);
	}
	
	// Table 클릭 시 02. 텍스트필드에 클릭한 데이터정보 넣어줌.
	protected void setRentalManagementDto(RentalManagement bdt) {
		RentalManagementFrame.pPanel.setItem(bdt);
	}
	protected void setItem(RentalManagement bdt) {
		tfBookNo.setText(bdt.getBookCode());
		tfBookName.setText(bdt.getBookName());
		tfAu.setText(bdt.getAuthor());
		tfPu.setText(bdt.getPublisher());
		tfPr.setText(bdt.getPrice() + "");
		tfTotal.setText(bdt.getTotalRental() + "");
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btnSearch) {
			do_btnSearch_mouseClicked(e);
		}
	}

	// 검색버튼을 눌렀을 경우
	protected void do_btnSearch_mouseClicked(MouseEvent e) {
		System.out.println("검색");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
