package project_library.ui.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project_library.ui.component.SearchBookButton;
import project_library.ui.component.SearchBookPanel;
import project_library.ui.component.SearchBookTable;
import project_library.ui.component.SearchBookTotalCountPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class SearchBookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfBook;
	private SearchBookTable table;
	private JPanel pInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBookFrame frame = new SearchBookFrame();
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
	public SearchBookFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pInput = new JPanel();
		contentPane.add(pInput);
		GridBagLayout gbl_pInput = new GridBagLayout();
		gbl_pInput.columnWidths = new int[]{44, 61, 73, 495, 0};
		gbl_pInput.rowHeights = new int[]{23, 0};
		gbl_pInput.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pInput.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pInput.setLayout(gbl_pInput);
		
		JRadioButton rdbtnBookName = new JRadioButton("도서명");
		GridBagConstraints gbc_rdbtnBookName = new GridBagConstraints();
		gbc_rdbtnBookName.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnBookName.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnBookName.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnBookName.gridx = 1;
		gbc_rdbtnBookName.gridy = 0;
		pInput.add(rdbtnBookName, gbc_rdbtnBookName);
		
		JRadioButton rdbtnBookCode = new JRadioButton("도서코드");
		GridBagConstraints gbc_rdbtnBookCode = new GridBagConstraints();
		gbc_rdbtnBookCode.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnBookCode.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnBookCode.gridx = 2;
		gbc_rdbtnBookCode.gridy = 0;
		pInput.add(rdbtnBookCode, gbc_rdbtnBookCode);
		
		tfBook = new JTextField();
		GridBagConstraints gbc_tfBook = new GridBagConstraints();
		gbc_tfBook.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBook.gridx = 3;
		gbc_tfBook.gridy = 0;
		pInput.add(tfBook, gbc_tfBook);
		tfBook.setColumns(10);
		
		SearchBookButton pBtns = new SearchBookButton();
		contentPane.add(pBtns);
		SearchBookPanel pBookInfo = new SearchBookPanel();
		contentPane.add(pBookInfo);
		
		JPanel pRentInfo = new JPanel();
		contentPane.add(pRentInfo);
		pRentInfo.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pRentInfo.add(scrollPane, BorderLayout.CENTER);
		
		table = new SearchBookTable();
		table.setBorder(null);
		scrollPane.setViewportView(table);
		
		SearchBookTotalCountPanel pRentInfoTotal = new SearchBookTotalCountPanel();
		contentPane.add(pRentInfoTotal);
	}

}
