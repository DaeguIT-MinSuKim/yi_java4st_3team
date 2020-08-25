package project_library.ui.component;

import static project_library.ui.component.BookManagementButton.btnAdd;
import static project_library.ui.component.BookManagementButton.btnSave;
import static project_library.ui.component.BookManagementButton.btnUpdate;
import static project_library.ui.frame.BookManagementFrame.pBPanel;

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
import javax.swing.border.EmptyBorder;

import project_library.dto.Book;
import project_library.exception.EmptyTfException;
import project_library.exception.FristCharException;
import project_library.exception.InValidationException;

@SuppressWarnings("serial")
public class BookManagementPanel extends JPanel implements KeyListener {
	public JTextField tfBno;
	public JTextField tfBname;
	public JTextField tfBau;
	public JTextField tfBpu;
	public JTextField tfBpr;

	public BookManagementPanel() {
		initComponents();
	}

	private void initComponents() {
		setBorder(new EmptyBorder(0, 10, 0, 10));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 150, 150, 150, 150 };
		gridBagLayout.rowHeights = new int[] { 30, 30, 30, 30, 30 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, };
		setLayout(gridBagLayout);

		JLabel lblBno = new JLabel("도서코드 : ");
		lblBno.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblBno = new GridBagConstraints();
		gbc_lblBno.fill = GridBagConstraints.VERTICAL;
		gbc_lblBno.anchor = GridBagConstraints.EAST;
		gbc_lblBno.insets = new Insets(0, 0, 5, 5);
		gbc_lblBno.gridx = 0;
		gbc_lblBno.gridy = 0;
		add(lblBno, gbc_lblBno);

		tfBno = new JTextField();
		tfBno.addKeyListener(this);
		tfBno.setHorizontalAlignment(SwingConstants.CENTER);
		tfBno.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_tfBno = new GridBagConstraints();
		gbc_tfBno.gridwidth = 3;
		gbc_tfBno.fill = GridBagConstraints.BOTH;
		gbc_tfBno.insets = new Insets(0, 0, 5, 5);
		gbc_tfBno.gridx = 1;
		gbc_tfBno.gridy = 0;
		add(tfBno, gbc_tfBno);
		tfBno.setColumns(10);

		JLabel lblBname = new JLabel("도 서 명 : ");
		lblBname.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblBname = new GridBagConstraints();
		gbc_lblBname.fill = GridBagConstraints.VERTICAL;
		gbc_lblBname.anchor = GridBagConstraints.EAST;
		gbc_lblBname.insets = new Insets(0, 0, 5, 5);
		gbc_lblBname.gridx = 0;
		gbc_lblBname.gridy = 1;
		add(lblBname, gbc_lblBname);

		tfBname = new JTextField();
		tfBname.addKeyListener(this);
		tfBname.setHorizontalAlignment(SwingConstants.CENTER);
		tfBname.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfBname.setColumns(10);
		GridBagConstraints gbc_tfBname = new GridBagConstraints();
		gbc_tfBname.gridwidth = 3;
		gbc_tfBname.insets = new Insets(0, 0, 5, 5);
		gbc_tfBname.fill = GridBagConstraints.BOTH;
		gbc_tfBname.gridx = 1;
		gbc_tfBname.gridy = 1;
		add(tfBname, gbc_tfBname);

		JLabel lblBau = new JLabel("저     자 : ");
		lblBau.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblBau = new GridBagConstraints();
		gbc_lblBau.fill = GridBagConstraints.VERTICAL;
		gbc_lblBau.anchor = GridBagConstraints.EAST;
		gbc_lblBau.insets = new Insets(0, 0, 5, 5);
		gbc_lblBau.gridx = 0;
		gbc_lblBau.gridy = 2;
		add(lblBau, gbc_lblBau);

		tfBau = new JTextField();
		tfBau.addKeyListener(this);
		tfBau.setHorizontalAlignment(SwingConstants.CENTER);
		tfBau.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfBau.setColumns(10);
		GridBagConstraints gbc_tfBau = new GridBagConstraints();
		gbc_tfBau.gridwidth = 3;
		gbc_tfBau.insets = new Insets(0, 0, 5, 5);
		gbc_tfBau.fill = GridBagConstraints.BOTH;
		gbc_tfBau.gridx = 1;
		gbc_tfBau.gridy = 2;
		add(tfBau, gbc_tfBau);

		JLabel lblBpu = new JLabel("출 판 사 : ");
		lblBpu.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblBpu = new GridBagConstraints();
		gbc_lblBpu.fill = GridBagConstraints.VERTICAL;
		gbc_lblBpu.anchor = GridBagConstraints.EAST;
		gbc_lblBpu.insets = new Insets(0, 0, 5, 5);
		gbc_lblBpu.gridx = 0;
		gbc_lblBpu.gridy = 3;
		add(lblBpu, gbc_lblBpu);

		tfBpu = new JTextField();
		tfBpu.addKeyListener(this);
		tfBpu.setHorizontalAlignment(SwingConstants.CENTER);
		tfBpu.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfBpu.setColumns(10);
		GridBagConstraints gbc_tfBpu = new GridBagConstraints();
		gbc_tfBpu.gridwidth = 3;
		gbc_tfBpu.insets = new Insets(0, 0, 5, 5);
		gbc_tfBpu.fill = GridBagConstraints.BOTH;
		gbc_tfBpu.gridx = 1;
		gbc_tfBpu.gridy = 3;
		add(tfBpu, gbc_tfBpu);

		JLabel lblBpr = new JLabel("가     격 : ");
		lblBpr.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblBpr = new GridBagConstraints();
		gbc_lblBpr.fill = GridBagConstraints.VERTICAL;
		gbc_lblBpr.anchor = GridBagConstraints.EAST;
		gbc_lblBpr.insets = new Insets(0, 0, 0, 5);
		gbc_lblBpr.gridx = 0;
		gbc_lblBpr.gridy = 4;
		add(lblBpr, gbc_lblBpr);

		tfBpr = new JTextField();
		tfBpr.addKeyListener(this);
		tfBpr.setHorizontalAlignment(SwingConstants.CENTER);
		tfBpr.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfBpr.setColumns(10);
		GridBagConstraints gbc_tfBpr = new GridBagConstraints();
		gbc_tfBpr.gridwidth = 3;
		gbc_tfBpr.insets = new Insets(0, 0, 0, 5);
		gbc_tfBpr.fill = GridBagConstraints.BOTH;
		gbc_tfBpr.gridx = 1;
		gbc_tfBpr.gridy = 4;
		add(tfBpr, gbc_tfBpr);
	}

	protected void setItem(Book idx) {
		tfBno.setText(idx.getNo());
		tfBname.setText(idx.getBookName());
		tfBau.setText(idx.getAuthor());
		tfBpu.setText(idx.getPublisher());
		tfBpr.setText(idx.getPrice() + "");
	}

	public Book getItem() {
		
		// 공란
		if (isEmpty()) {
			throw new EmptyTfException("공란 존재");
		}

		// 형식
		if (!isInvalid()) {
			throw new InValidationException("형식이 맞지 않습니다.");
		}

		String no = tfBno.getText().trim();
		String name = tfBname.getText();
		String aut = tfBau.getText();
		String pub = tfBpu.getText();
		int pri = Integer.parseInt(tfBpr.getText().trim());
		return new Book(no, name, aut, pub, pri);
	}

	// Clear
	public void clearTf() {
		tfBno.setText("");
		tfBname.setText("");
		tfBau.setText("");
		tfBpu.setText("");
		tfBpr.setText("");
	}

	public Book getBook() {

		// 공란
		if (isEmpty()) {
			throw new EmptyTfException("공란 존재");
		}

		// 형식
		if (!isInvalid()) {
			throw new InValidationException("형식이 맞지 않습니다.");
		}

		String no = tfBno.getText().trim();
		String name = tfBname.getText();
		String aut = tfBau.getText();
		String pub = tfBpu.getText();
		int pri = Integer.parseInt(tfBpr.getText().trim());
		return new Book(no, name, aut, pub, pri);
	}

	private boolean isInvalid() {

		// 정규표현식
		String name = tfBname.getText();
		String aut = tfBau.getText();
		String pub = tfBpu.getText();
		String pri = tfBpr.getText();

		// 정규표현식 적용
		boolean nameCheck = Pattern.matches("^[가-힣A-Za-z\\s]+$", name);
		boolean autCheck = Pattern.matches("^[가-힣A-Za-z\\s]+$", aut);
		boolean pubCheck = Pattern.matches("^[가-힣A-Za-z\\s]+$", pub);
		boolean priCheck = Pattern.matches("^[0-9]*$", pri);

		return nameCheck && autCheck && pubCheck && priCheck;
	}

	private boolean isEmpty() {
		return tfBno.getText().isEmpty() || tfBname.getText().isEmpty() || tfBau.getText().isEmpty()
				|| tfBpu.getText().isEmpty() || tfBpr.getText().isEmpty();
	}

	// 수정 시 도서코드 수정 불가능
	public JTextField getTf() {
		return tfBno;
	}

	// BookPanel 수정 불가능
	public void setEditalbeFalseTf() {
		tfBno.setEditable(false);
		tfBname.setEditable(false);
		tfBau.setEditable(false);
		tfBpu.setEditable(false);
		tfBpr.setEditable(false);
	}

	// BookPanel 수정 가능
	public void setEditalbeTrueTf() {
		tfBno.setEditable(true);
		tfBname.setEditable(true);
		tfBau.setEditable(true);
		tfBpu.setEditable(true);
		tfBpr.setEditable(true);
	}

	// Table 클릭 시
	public void setEditalbeTableTrueTf() {
		tfBno.setEditable(false);
		tfBname.setEditable(true);
		tfBau.setEditable(true);
		tfBpu.setEditable(true);
		tfBpr.setEditable(true);
	}

	protected void setBookDto(Book bdt) {
		pBPanel.setItem(bdt);
	}

	/* 첫번째 필드 회원/도서코드 중복 확인 ↓ */
	public Book getCodeNo() {
		
		// 공란
		if (isEmptyNo()) {
			throw new EmptyTfException("공란 존재");
		}

		// 첫글자 영문
		if (!isFristChar()) {
			throw new FristCharException("코드의 첫문자는 영문입니다.");
		} else if (!isInvalidNo()) { // 형식
			throw new InValidationException("형식이 맞지 않습니다.");
		} 

		String no = tfBno.getText().trim();
		return new Book(no);
	}

	private boolean isEmptyNo() {
		return tfBno.getText().isEmpty();
	}

	private boolean isFristChar() {
		
		// 정규표현식
		String no = tfBno.getText().trim();
		String str = no.substring(0, 1);

		// 정규표현식 적용
		boolean noCheck = Pattern.matches("^[a-zA-Z]", str);
		return noCheck;
	}

	private boolean isInvalidNo() {
		
		// 정규식 표현식
		String no = tfBno.getText().trim();

		// 정규표현식 적용
		boolean noCheck = Pattern.matches("^[B]{1}\\d{3}", no);

		return noCheck;
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
		if (tfBno.isEditable()) {// 코드필드 활성화 됐으면
			if (e.getSource() == tfBno) { // 저장할 경우
				String no = tfBno.getText().trim();
				if (no.length() != 0) {
					btnAdd.setEnabled(true);
					// System.out.println(no);
				} else {
					btnSave.setEnabled(false);
					if (tfBno.getText().trim().length() != 0 || tfBname.getText().length() != 0
							|| tfBau.getText().length() != 0 || tfBpu.getText().length() != 0
							|| tfBpr.getText().trim().length() != 0) {
						return;
					}
					btnSave.setEnabled(false);
				}
			} else if (e.getSource() == tfBname) {
				String name = tfBname.getText();
				if (name.length() != 0) {
					btnAdd.setEnabled(true);
					// System.out.println(name);
				} else {
					btnUpdate.setEnabled(false);
				}

			} else if (e.getSource() == tfBau) {
				String bau = tfBau.getText();
				if (bau.length() != 0) {
					btnAdd.setEnabled(true);
					// System.out.println(bau);
				} else {
					btnUpdate.setEnabled(false);
				}

			} else if (e.getSource() == tfBpu) {
				String bpu = tfBpu.getText();
				if (bpu.length() != 0) {
					btnAdd.setEnabled(true);
					// System.out.println(bpu);
				} else {
					btnUpdate.setEnabled(false);
				}

			} else if (e.getSource() == tfBpr) {
				String bpr = tfBpr.getText().trim();
				if (bpr.length() != 0) {
					btnSave.setEnabled(true);
					// System.out.println(bpr);
				} else {
					btnSave.setEnabled(false);
					if (tfBname.getText().length() != 0 || tfBau.getText().length() != 0
							|| tfBpu.getText().length() != 0 || tfBpr.getText().trim().length() != 0) {
						return;
					}
					btnUpdate.setEnabled(true);
				}

			}

		} else { // 수정할 경우
			btnSave.setEnabled(false);
			if (e.getSource() == tfBname) {
				String name = tfBname.getText();
				if (name.length() != 0) {
					btnAdd.setEnabled(true);
					// System.out.println(name);
				} else {
					btnUpdate.setEnabled(false);
				}
			} else if (e.getSource() == tfBau) {
				String bau = tfBau.getText();
				if (bau.length() != 0) {
					btnAdd.setEnabled(true);
					// System.out.println(bau);
				} else {
					btnUpdate.setEnabled(false);
				}

			} else if (e.getSource() == tfBpu) {
				String bpu = tfBpu.getText();
				if (bpu.length() != 0) {
					btnAdd.setEnabled(true);
					// System.out.println(bpu);
				} else {
					btnUpdate.setEnabled(false);
				}
			} else if (e.getSource() == tfBpr) {
				String bpr = tfBpr.getText().trim();
				if (bpr.length() != 0) {
					// System.out.println(bau);
				} else {
					btnSave.setEnabled(false);
					if (tfBname.getText().length() != 0 || tfBau.getText().length() != 0
							|| tfBpu.getText().length() != 0 || tfBpr.getText().trim().length() != 0) {
						return;
					}
					btnUpdate.setEnabled(true);
				}

			}

		}

	}

	public void keyTyped(KeyEvent e) {

	}

	protected void keyReleasedTfBau(KeyEvent e) {

	}

	protected void keyReleasedTfBpu(KeyEvent e) {

	}

	protected void keyReleasedTfBpr(KeyEvent e) {

	}

	protected void keyReleasedTfBno(KeyEvent e) {

	}

	protected void keyReleasedTfBname(KeyEvent e) {

	}

}
