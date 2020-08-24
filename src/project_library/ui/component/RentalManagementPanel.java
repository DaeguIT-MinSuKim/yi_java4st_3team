package project_library.ui.component;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import project_library.dto.Member;
import project_library.dto.Rent;
import project_library.exception.EmptyTfException;
import project_library.exception.InValidationException;
import project_library.service.MemberManagementService;
import project_library.ui.frame.MemberManagementFrame;
import project_library.ui.frame.RentalManagementFrame;

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
	private MemberManagementService mService;
	public static ArrayList<Member> memberDtoList;
	
	public RentalManagementPanel() {
		initComponents();
		
		/*
		 * 프로그램 시작시 동작
		 * */
		// 01. 텍스트필드 비활성화
		setEditalbeFalseTf(); 
		
		//02. [대여]버튼 비활성화 > Button.java 파일안에 작성됨.
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
	protected void setRentalManagementDto(Rent bdt) {
		RentalManagementFrame.pPanel.setItem(bdt);
	}
	protected void setItem(Rent bdt) {
		tfBookNo.setText(bdt.getBookCode());
		tfBookName.setText(bdt.getBookName());
		tfAu.setText(bdt.getAuthor());
		tfPu.setText(bdt.getPublisher());
		tfPr.setText(bdt.getPrice() + "");
		tfTotal.setText(bdt.getTotalRental() + "");
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btnSearch) {
			btnSearch_mouseClicked(e);
		}
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

	
	protected void btnSearch_mouseClicked(MouseEvent e) {

		//01. 텍스트필드에 입력된 회원코드 값 가져옴
		String getTfMemberNo = tfMemberNo.getText();
		
		//02. MemberImpl에서 던져진 DB 값 가져옴
		mService = new MemberManagementService();
		memberDtoList = (ArrayList<Member>) mService.getMemberDtoList();
		
		//03. 회원코드를 기준으로 회원이 있는지 먼저 체크
		boolean memberChk = false;
		String memberName = "";
		String memberTel = "";
		
		for (Member M : memberDtoList) {
			if ( getTfMemberNo.equalsIgnoreCase(M.getNo()) ) { // 대소문자 구분없이 검색
				memberChk = true; // 하나라도 일치하면 여기에 들어와서 true로 바꾸기 때문에... 
				memberName = M.getName(); // 일치된 회원의 이름을 넣음. 일치한 회원의 이름 하나만 넣기때문에, 일치된 인덱스를 읽는 귀찮은 짓을 안해도 된다. 굳 !
				memberTel = M.getTel(); // 일치된 회원의 번호를 넣음
			}
		}

		//04. 체크된 값을 기준으로 구분처리
		if( memberChk == true ) { // 멤버가 있으면
			//System.out.println("검색됨");
			
			//01. 성명, 전화번호 텍스트필드에 입력
			tfMemberName.setText(memberName);
			tfPhone.setText(memberTel);
			//02. [대여]버튼 활성화
			RentalManagementButton.btnRent.setEnabled(true);
			
		}else { // 멤버가 없으면
			JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			clearMemberTf(); // 알림창 띄운후 멤버이름,전화번호에 텍스트필드 비우기
		}
		
	}
	
	public void clearMemberTf() {
		tfMemberName.setText("");
		tfPhone.setText("");
	}

	// Tf All Clear
	public void clearTf() {
		tfBookNo.setText("");
		tfBookName.setText("");
		tfAu.setText("");
		tfPu.setText("");
		tfPr.setText("");
		tfTotal.setText("");
		tfMemberNo.setText("");
		tfMemberName.setText("");
		tfPhone.setText("");
	}

	public Rent getItem() {
		// 공란
		if (isEmpty()) {
			throw new EmptyTfException("공란 존재");
		}
		// 형식
		if (!isInvalid()) {
			throw new InValidationException("형식이 맞지 않습니다.");
		}
		String bNo = tfBookNo.getText().trim();
		String mNo = tfMemberNo.getText().trim();
		return new Rent(bNo, mNo);
	}
	
	private boolean isInvalid() {
		// 정규식 표현식
		String bNo = tfBookNo.getText().trim();
		String mNo = tfMemberNo.getText().trim();

		// 정규표현식 적용
		boolean noCheck1 = Pattern.matches("[a-zA-Z]{1}\\d{3}", bNo);
		boolean noCheck2 = Pattern.matches("[a-zA-Z]{1}\\d{3}", mNo);
		return noCheck1 && noCheck2;
	}

	private boolean isEmpty() {
		boolean bNo = tfBookNo.getText().isEmpty();
		boolean mNo = tfMemberNo.getText().isEmpty();
		return bNo && mNo;
	}
	
	protected void setRentDto(Rent mdt) {
		RentalManagementFrame.pPanel.setItem(mdt);
	}

}
