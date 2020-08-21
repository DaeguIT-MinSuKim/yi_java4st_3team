package project_librery.searchMember.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import project_library.exception.EmptyTfException;
import project_library.exception.InValidationException;
import project_library.member.dto.Member;
import project_library.member.management.MemberManagement;

@SuppressWarnings("serial")
public class MemberResearchPanel extends JPanel implements KeyListener {
	public JTextField tfName;

	public MemberResearchPanel() {
		initComponents();
	}

	private void initComponents() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 150, 150, 150 };
		gridBagLayout.rowHeights = new int[] { 30, 30, 30 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		JLabel lblName = new JLabel("성      명 : ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);

		tfName = new JTextField();
		tfName.addKeyListener(this);
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfName.setColumns(20);
		tfName.setBorder(new EmptyBorder(5, 10, 5, 5));
		tfName.setBorder((Border) (new LineBorder(Color.black, 1)));
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.gridwidth = 3;
		gbc_tfName.insets = new Insets(5, 5, 5, 5);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 1;
		gbc_tfName.gridy = 1;
		add(tfName, gbc_tfName);

	}

	protected void setItem(Member idx) {
//		tfNo.setText(idx.getNo() + "");
		tfName.setText(idx.getName());
//		tfTel.setText(idx.getTel());
	}

	public Member getItem() {
		// 공란
		if (isEmpty()) {
			throw new EmptyTfException("공란 존재");
		}

		// 형식
		if (!isInvalid()) {
			throw new InValidationException("형식이 맞지 않습니다.");
		}

//		String no = tfNo.getText().trim();
		String name = tfName.getText().trim();
//		String tel = tfTel.getText().trim();
		return new Member(/* no, */ name/* , tel */);
	}

	// Clear
	public void clearTf() {
//		tfNo.setText("");
		tfName.setText("");
//		tfTel.setText("");
	}

	public Member getMember() {

		// 공란
		if (isEmpty()) {
			throw new EmptyTfException("공란 존재");
		}

		// 형식
		if (!isInvalid()) {
			throw new InValidationException("형식이 맞지 않습니다.");
		}

//		String no = tfNo.getText().trim();
		String name = tfName.getText().trim();
//		String tel = tfTel.getText().trim();
		return new Member(/* no, */name/* , tel */);
	}

	private boolean isInvalid() {
		// 정규식 표현식
//		String no = tfNo.getText().trim();
		String name = tfName.getText().trim();
//		String tel = tfTel.getText().trim();

		// 정규표현식 적용
//		boolean noCheck = Pattern.matches("[a-zA-Z]{1}\\d{3}", no);
		boolean nameCheck = Pattern.matches("^[가-힣A-Za-z]+$", name);
//		boolean telCheck = Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}", tel);
		return /* noCheck && */nameCheck /* && telCheck */;
	}

	private boolean isEmpty() {
		return /* tfNo.getText().isEmpty() || */tfName.getText().isEmpty() /* || tfTel.getText().isEmpty() */;
	}

	// 수정 시 회원번호 수정 불가능
	public JTextField getTf() {
		return tfName;
	}

	// MemberPanel 수정 불가능
	public void setEditalbeFalseTf() {
//		tfNo.setEditable(false);
		tfName.setEditable(false);
//		tfTel.setEditable(false);
	}

	// MemberPanel 수정 가능
	public void setEditalbeTrueTf() {
//		tfNo.setEditable(true);
		tfName.setEditable(true);
//		tfTel.setEditable(true);

	}

	// Table 클릭 시
	public void setEditalbeTableTrueTf() {
//		tfNo.setEditable(false);
		tfName.setEditable(true);
//		tfTel.setEditable(true);
	}

	public void keyPressed(KeyEvent e) {

	}

//	public void keyReleased(KeyEvent e) {
//		if (tfNo.isEditable()) {// 코드필드 활성화 됐으면
//			if (e.getSource() == tfNo) { // 저장할 경우
//				String no = tfNo.getText().trim();
//				if (no.length() != 0) {
//					MemberManagement.btnAdd.setEnabled(true);
//					// System.out.println(no);
//				} else {
//					MemberManagement.btnSave.setEnabled(false);
//					if (tfNo.getText().trim().length() != 0 || tfName.getText().trim().length() != 0
//							|| tfTel.getText().trim().length() != 0) {
//						return;
//					}
//					MemberManagement.btnSave.setEnabled(false);
//				}
//			} else if (e.getSource() == tfName) {
//				String name = tfName.getText().trim();
//				if (name.length() != 0) {
//					MemberManagement.btnAdd.setEnabled(true);
//					// System.out.println(name);
//				} else {
//					MemberManagement.btnUpdate.setEnabled(false);
//				}
//			} else if (e.getSource() == tfTel) {
//				String tel = tfTel.getText().trim();
//				if (tel.length() != 0) {
//					MemberManagement.btnSave.setEnabled(true);
//					// System.out.println(tel);
//				} else {
//					MemberManagement.btnSave.setEnabled(false);
//					if (tfName.getText().trim().length() != 0 || tfTel.getText().trim().length() != 0) {
//						return;
//					}
//					MemberManagement.btnUpdate.setEnabled(true);
//				}
//			}
//		} else { // 수정할 경우
//			MemberManagement.btnSave.setEnabled(false);
//			if (e.getSource() == tfName) {
//				String name = tfName.getText().trim();
//				if (name.length() != 0) {
//					MemberManagement.btnAdd.setEnabled(true);
//					// System.out.println(name);
//				} else {
//					MemberManagement.btnUpdate.setEnabled(false);
//				}
//			} else if (e.getSource() == tfTel) {
//				String tel = tfTel.getText().trim();
//				if (tel.length() != 0) {
//					// System.out.println(tel);
//				} else {
//					MemberManagement.btnSave.setEnabled(false);
//					if (tfName.getText().trim().length() != 0 || tfTel.getText().trim().length() != 0) {
//						return;
//					}
//					MemberManagement.btnUpdate.setEnabled(true);
//				}
//			}
//		}
//	}

	public void keyTyped(KeyEvent e) {

	}

	protected void keyReleasedTfTel(KeyEvent e) {

	}

	protected void keyReleasedTfName(KeyEvent e) {

	}

	protected void keyReleasedTfNo(KeyEvent e) {

	}

	/*
	 * protected void setMemberDto(Member mdt) {
	 * MemberManagement.pMember.setItem(mdt); }
	 */

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * 첫번째 필드 회원/도서코드 중복 확인 ↓ public Member getCodeNo() { // 공란 if (isEmptyNo()) {
	 * throw new EmptyTfException("공란 존재"); }
	 * 
	 * // 형식 if (!isInvalidNo()) { throw new InValidationException("형식이 맞지 않습니다.");
	 * } // 첫글자 영문 if (!isFristChar()) { throw new
	 * FristCharException("코드의 첫문자는 영문입니다."); }
	 * 
	 * String no = tfNo.getText().trim(); return new Member(no); }
	 * 
	 * private boolean isEmptyNo() { return tfNo.getText().isEmpty(); }
	 * 
	 * private boolean isFristChar() { // 정규식 표현식 String no = tfNo.getText().trim();
	 * String str = no.substring(0, 1);
	 * 
	 * // 정규표현식 적용 boolean noCheck = Pattern.matches("^[a-zA-Z]", str); return
	 * noCheck; }
	 * 
	 * private boolean isInvalidNo() { // 정규식 표현식 String no = tfNo.getText().trim();
	 * 
	 * // 정규표현식 적용 boolean noCheck = Pattern.matches("[M]{1}\\d{3}", no); return
	 * noCheck; }
	 */

}
