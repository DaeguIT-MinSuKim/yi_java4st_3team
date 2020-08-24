package project_library.ui.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import project_library.dto.Rent;
import project_library.service.ReturnManagementService;
import project_library.ui.component.ReturnManagementButton;
import project_library.ui.component.ReturnManagementPanel;
import project_library.ui.component.ReturnManagementTable;

@SuppressWarnings("serial")
public class ReturnManagementFrame extends JFrame {

	private JPanel contentPane;
	public static ReturnManagementTable table;
	public static ReturnManagementPanel pRPanel;
	private ReturnManagementButton pRBtns;
	private JPanel pRTable;
	private JScrollPane scrollPane;
	public static ArrayList<Rent> returnManagementList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnManagementFrame frame = new ReturnManagementFrame();
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
	public ReturnManagementFrame() {
		ReturnManagementService bService = new ReturnManagementService();
		returnManagementList = (ArrayList<Rent>) bService.getReturnManagementList();
		
		initComponents();
		
		
		table = new ReturnManagementTable();
		//table.setReturnManagementList(returnManagementList);
		scrollPane.setViewportView(table);
	}

	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pRPanel = new ReturnManagementPanel();
		contentPane.add(pRPanel);
		
		pRBtns = new ReturnManagementButton();
		contentPane.add(pRBtns);
		
		pRTable = new JPanel();
		pRTable.setBorder(new TitledBorder(null, "\uBC18\uB0A9\uD544\uC694 \uB3C4\uC11C\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRTable);
		pRTable.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pRTable.add(scrollPane, BorderLayout.CENTER);
		
	}
}
