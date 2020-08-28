package project_library.ui.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project_library.dto.Rent;
import project_library.service.SearchBookManagementService;
import project_library.ui.component.SearchBookButton;
import project_library.ui.component.SearchBookPanel;
import project_library.ui.component.SearchBookTable;
import project_library.ui.component.SearchBookTotalCountPanel;

@SuppressWarnings("serial")
public class SearchBookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfBook;
	private SearchBookTable table;
	private JPanel pInput;
	private GridBagLayout gbl_pInput;
	private JRadioButton rdbtnBookName;
	private GridBagConstraints gbc_rdbtnBookName;
	private JRadioButton rdbtnBookCode;
	private GridBagConstraints gbc_pBtns;
	private GridBagConstraints gbc_rdbtnBookCode;
	private GridBagConstraints gbc_tfBook;
	private JPanel pRentInfo;
	private SearchBookButton pBtns;
	private SearchBookPanel pBookInfo;
	private SearchBookTotalCountPanel pRentInfoTotal;
	private ArrayList<Rent> SearchBookList;
	private JScrollPane scrollPane;
	private SearchBookManagementService bService;
	private ButtonGroup radioGroup;


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

	public SearchBookFrame() {
		
		  bService = new SearchBookManagementService(); 
		  SearchBookList = (ArrayList<Rent>) bService.getSearchBookManagementList();
		 

		initComponents();

		/*
		 * table = new SearchBookTable();
		 * table.setBookSearchManagementList(SearchBookList);
		 * scrollPane.setViewportView(table);
		 */
		 
		radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnBookName);
		radioGroup.add(rdbtnBookCode);
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pInput = new JPanel();
		contentPane.add(pInput);
		gbl_pInput = new GridBagLayout();
		gbl_pInput.columnWidths = new int[] {60, 60, 450, 100};
		gbl_pInput.rowHeights = new int[] { 23, 0 };
		gbl_pInput.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gbl_pInput.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pInput.setLayout(gbl_pInput);
		
		rdbtnBookName = new JRadioButton("도서명");
		gbc_rdbtnBookName = new GridBagConstraints();
		gbc_rdbtnBookName.fill = GridBagConstraints.BOTH;
		gbc_rdbtnBookName.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnBookName.gridx = 0;
		gbc_rdbtnBookName.gridy = 0;
		pInput.add(rdbtnBookName, gbc_rdbtnBookName);

		rdbtnBookCode = new JRadioButton("도서코드");
		gbc_rdbtnBookCode = new GridBagConstraints();
		gbc_rdbtnBookCode.fill = GridBagConstraints.BOTH;
		gbc_rdbtnBookCode.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnBookCode.gridx = 1;
		gbc_rdbtnBookCode.gridy = 0;
		pInput.add(rdbtnBookCode, gbc_rdbtnBookCode);

		tfBook = new JTextField();
		gbc_tfBook = new GridBagConstraints();
		gbc_tfBook.insets = new Insets(0, 0, 0, 5);
		gbc_tfBook.fill = GridBagConstraints.BOTH;
		gbc_tfBook.gridx = 2;
		gbc_tfBook.gridy = 0;
		pInput.add(tfBook, gbc_tfBook);
		tfBook.setColumns(10);

		pBtns = new SearchBookButton();
		gbc_pBtns = new GridBagConstraints();
		gbc_pBtns.fill = GridBagConstraints.BOTH;
		gbc_pBtns.gridx = 3;
		gbc_pBtns.gridy = 0;
		pInput.add(pBtns, gbc_pBtns);
		
		pBookInfo = new SearchBookPanel();
		contentPane.add(pBookInfo);

		pRentInfo = new JPanel();
		contentPane.add(pRentInfo);
		pRentInfo.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		pRentInfo.add(scrollPane, BorderLayout.CENTER);

		
		table = new SearchBookTable(); 
		table.setBookSearchManagementList(SearchBookList);
		scrollPane.setViewportView(table);
		 

		pRentInfoTotal = new SearchBookTotalCountPanel();
		contentPane.add(pRentInfoTotal);
	}

}
