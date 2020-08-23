package project_library.ui.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import project_library.ui.component.BookConditionPanel;
import java.awt.FlowLayout;

public class BookConditionFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookConditionFrame frame = new BookConditionFrame();
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
	public BookConditionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		BookConditionPanel pTotalRentedBookCount = new BookConditionPanel();
		contentPane.add(pTotalRentedBookCount);
		pTotalRentedBookCount.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel pTRBCasGraph = new JPanel();
		contentPane.add(pTRBCasGraph);
	}

	//jtable morph --> //총 보유 권수 /총 연체권수 //총 대여 횟수 
}
