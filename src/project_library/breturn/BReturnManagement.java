package project_library.breturn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import project_library.breturn.component.BReturnPanel;
import project_library.breturn.component.BReturnButton;
import project_library.breturn.component.BReturnTable;
import javax.swing.border.TitledBorder;

public class BReturnManagement extends JFrame {

	private JPanel contentPane;
	private BReturnTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BReturnManagement frame = new BReturnManagement();
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
	public BReturnManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		BReturnPanel pRPanel = new BReturnPanel();
		contentPane.add(pRPanel);
		
		BReturnButton pRBtns = new BReturnButton();
		contentPane.add(pRBtns);
		
		JPanel pRTable = new JPanel();
		pRTable.setBorder(new TitledBorder(null, "\uBC18\uB0A9\uD544\uC694 \uB3C4\uC11C\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRTable);
		pRTable.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pRTable.add(scrollPane, BorderLayout.CENTER);
		
		table = new BReturnTable();
		scrollPane.setViewportView(table);
	}

}
