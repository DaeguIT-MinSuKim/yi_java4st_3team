package project_library.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import project_library.dto.SearchMember;
import project_library.exception.EmptyTfException;
import project_library.exception.FristCharException;
import project_library.exception.InValidationException;
import project_library.service.MemberManagementService;
import project_library.ui.SearchMemberPanel;
import project_library.ui.SearchMemberTable;

@SuppressWarnings("serial")
public class MemberManagementMain extends JFrame implements ActionListener {
	private JPanel contentPane;
	public static SearchMemberPanel pMember;
	public static JPanel pBtns;
	public static JButton btnAdd;
	public static JButton btnSave;
	public static JButton btnUpdate;
	public static JButton btnDelete;
	public static JButton btnExit;
	public static ArrayList<SearchMember> memberDtoList;
	private JPanel pMemberl;
	private JScrollPane scrollPane;
	public static SearchMemberTable memberTable;
	private MemberManagementService mService;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManagementMain frame = new MemberManagementMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MemberManagementMain() {
		mService = new MemberManagementService();
		memberDtoList = (ArrayList<SearchMember>) mService.getMemberDtoList();

		/*		mList = new ArrayList<MemberDto>();
				mList.add(new MemberDto("M001", "김자바", "010-1234-1234", 0));
				mList.add(new MemberDto("M002", "이자바", "010-2341-2341", 0));
				mList.add(new MemberDto("M003", "박자바", "010-3412-3412", 0));
				mList.add(new MemberDto("M004", "김바자", "010-4123-4123", 0));
				mList.add(new MemberDto("M005", "이바자", "010-5678-5678", 0));
				mList.add(new MemberDto("M006", "박바자", "010-6785-6785", 0));
				mList.add(new MemberDto("M007", "김자자", "010-7856-7856", 0));
				mList.add(new MemberDto("M008", "이자자", "010-8567-8567", 0));
				mList.add(new MemberDto("M009", "박자자", "010-0000-0000", 0));*/

		initComponents();

		pMemberl = new JPanel();
		pMemberl.setBorder(new TitledBorder(new EmptyBorder(10, 10, 10, 10), "[ 회원 목록 ]", TitledBorder.LEFT,
				TitledBorder.TOP, null, Color.BLACK));
		contentPane.add(pMemberl);
		pMemberl.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		pMemberl.add(scrollPane, BorderLayout.CENTER);

		memberTable = new SearchMemberTable();
		memberTable.setMemberList(memberDtoList);
		scrollPane.setViewportView(memberTable);

		pMember.setEditalbeFalseTf();
	}

	private void initComponents() {
		setTitle("회원 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pMember = new SearchMemberPanel();
		pMember.getTf().setForeground(Color.BLACK);
		contentPane.add(pMember);

		pBtns = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pBtns.getLayout();
		flowLayout.setHgap(50);
		flowLayout.setVgap(10);
		contentPane.add(pBtns);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pBtns.add(btnAdd);

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		btnSave.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pBtns.add(btnSave);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pBtns.add(btnUpdate);

		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pBtns.add(btnDelete);

		btnExit = new JButton("닫기");
		btnExit.addActionListener(this);
		btnExit.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pBtns.add(btnExit);

		btnSave.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {

		try {

			if (e.getSource() == btnExit) {
				actionPerformedBtnExit();
			}

			if (e.getSource() == btnDelete) {
				actionPerformedBtnDelete();
			}

			if (e.getSource() == btnUpdate) {
				actionPerformedBtnUpdate();
			}

			if (e.getSource() == btnSave) {
				actionPerformedBtnSave();
			}

			if (e.getSource() == btnAdd) {
				actionPerformedBtnAdd();
			}

		} catch (EmptyTfException ee) {
			JOptionPane.showMessageDialog(null, "공란 존재", "오류", JOptionPane.ERROR_MESSAGE);
			return;

		} catch (FristCharException ee) {
			JOptionPane.showMessageDialog(null, "회원코드는 M으로 시작해야 됩니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (InValidationException ee) {
			JOptionPane.showMessageDialog(null, "형식이 맞지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	public void checkNo() {

	}

	protected void actionPerformedBtnAdd() {
		// 입력창 활성화
		pMember.setEditalbeTrueTf();

		// Clear
		pMember.clearTf();

		// 저장, 수정, 삭제 버튼 비활성화
		btnSave.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	}

	protected void actionPerformedBtnSave() {

		// pMember 에서 getMember()를 이용해서 newMto
		SearchMember newMto = pMember.getMember();

		// pMember 에서 getCodeNo()를 이용해서 newMto2
		SearchMember newMto2 = pMember.getCodeNo();

		// 테이블에 있는 모든 회원코드 체크
		for (SearchMember m : memberDtoList) {
			if (newMto2.getNo().equals(m.getNo())) {
				JOptionPane.showMessageDialog(null, "회원코드가 중복입니다.", "오류", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
		String message = String.format("%s 회원님이 저장 되었습니다.", newMto.getName());
		JOptionPane.showMessageDialog(null, message);

		mService.insertMember(newMto);

		// newMto를 Member에 add
		memberTable.addMemberDto(newMto);

		// mList add
		memberDtoList.add(newMto);

		// pMember clear
		pMember.clearTf();

		// 저장 성공 - 수정, 삭제 버튼 활성화
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);

		// 저장 버튼 비활성화
		btnSave.setEnabled(false);

		// 회원 코드 비활성화
		pMember.getTf().setEditable(false);

		int idx = memberDtoList.indexOf(newMto);
		memberTable.setRowSelectionInterval(0, idx);

	}

	protected void actionPerformedBtnUpdate() {
		SearchMember uptatedMem = pMember.getItem();
		
		mService.modifyMember(uptatedMem);
		
		int idx = memberDtoList.indexOf(uptatedMem);
		memberTable.updateRow(idx, uptatedMem);
		memberTable.setRowSelectionInterval(0, idx);
		pMember.clearTf();
		JOptionPane.showMessageDialog(null, "수정 되었습니다.");
	}

	protected void actionPerformedBtnDelete() {
		// 선택된 인덱스
		int idx = memberTable.getSelectedRow();
		
		SearchMember deleteMem = pMember.getItem();
		
		mService.removeMember(deleteMem);

		// 삭제 여부 메시지
		int result = JOptionPane.showConfirmDialog(null, "정말 삭제 하시겠습니까?", "경고", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			// table 에서 삭제
			memberTable.delMemberDto(idx);

			// pMember clear
			pMember.clearTf();

			// 삭제 성공 - 수정, 삭제 버튼 비활성화
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);

		} else {
			// 삭제 취소 - 수정, 삭제 버튼 활성화
			btnUpdate.setEnabled(true);
			btnDelete.setEnabled(true);
		}

	}

	protected void actionPerformedBtnExit() {
		System.exit(0);
	}

}
