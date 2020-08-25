package project_library.ui.component;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BookStatusPanel extends JPanel {
	private JTextField tfTBook;
	private JTextField tfOBook;
	private JTextField tfRBook;

	public BookStatusPanel() {
		setBorder(new TitledBorder(null, "[ 도서 현황 ]", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 20, 10));
		
		JLabel lblTBook = new JLabel("총 보유 권수");
		lblTBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblTBook.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(lblTBook);
		
		tfTBook = new JTextField();
		add(tfTBook);
		tfTBook.setColumns(10);
		
		JLabel lblOBook = new JLabel("총 연체 권수");
		lblOBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblOBook.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(lblOBook);
		
		tfOBook = new JTextField();
		add(tfOBook);
		tfOBook.setColumns(10);
		
		JLabel lblRBook = new JLabel("총 대여 권수");
		lblRBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblRBook.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		add(lblRBook);
		
		tfRBook = new JTextField();
		add(tfRBook);
		tfRBook.setColumns(10);
	}

}
