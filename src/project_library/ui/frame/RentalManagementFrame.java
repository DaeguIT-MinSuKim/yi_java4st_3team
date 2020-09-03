package project_library.ui.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import project_library.dto.Rent;
import project_library.service.RentalManagementService;
import project_library.ui.component.RentalManagementButton;
import project_library.ui.component.RentalManagementPanel;
import project_library.ui.component.RentalManagementTable;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class RentalManagementFrame extends JFrame {
	
	private JPanel contentPane;
	public static ArrayList<Rent> rentalManagementList;
	public static RentalManagementPanel pPanel;
	private RentalManagementButton pBtns;
	private JPanel pBTable;
	private JScrollPane scrollPane;
	public static RentalManagementTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentalManagementFrame frame = new RentalManagementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
	}

	public RentalManagementFrame() {
		RentalManagementService bService = new RentalManagementService();
		rentalManagementList = (ArrayList<Rent>) bService.getRentalManagementList();

		initComponents();
		
		table = new RentalManagementTable();
		table.setRentalManagementList(rentalManagementList);
		scrollPane.setViewportView(table);
	}

	private void initComponents() {
		setTitle("대여 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pPanel = new RentalManagementPanel();
		GridLayout gl_pPanel = (GridLayout) pPanel.getLayout();
		gl_pPanel.setVgap(10);
		gl_pPanel.setHgap(5);
		pPanel.setBorder(new EmptyBorder(20, 10, 10, 10));
		contentPane.add(pPanel);
		
		pBtns = new RentalManagementButton();
		contentPane.add(pBtns);
		pBtns.setbFrame(this);
		
		pBTable = new JPanel();
		pBTable.setBorder(new TitledBorder(new EmptyBorder(5, 5, 5, 5), "[ 도서 대여가능 목록 ]", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pBTable);
		pBTable.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pBTable.add(scrollPane, BorderLayout.CENTER);
	}

}
