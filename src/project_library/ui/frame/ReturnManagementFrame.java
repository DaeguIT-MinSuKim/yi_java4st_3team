package project_library.ui.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import project_library.ui.component.ReturnManagementButton;
import project_library.ui.component.ReturnManagementPanel;
import project_library.ui.component.ReturnManagementTable;

import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class ReturnManagementFrame extends JFrame {

	private JPanel contentPane;
	private ReturnManagementTable table;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		ReturnManagementPanel pRPanel = new ReturnManagementPanel();
		contentPane.add(pRPanel);
		
		ReturnManagementButton pRBtns = new ReturnManagementButton();
		contentPane.add(pRBtns);
		
		JPanel pRTable = new JPanel();
		pRTable.setBorder(new TitledBorder(null, "\uBC18\uB0A9\uD544\uC694 \uB3C4\uC11C\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRTable);
		pRTable.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pRTable.add(scrollPane, BorderLayout.CENTER);
		
		table = new ReturnManagementTable();
		scrollPane.setViewportView(table);
	}

}
