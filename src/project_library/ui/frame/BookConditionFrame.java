package project_library.ui.frame;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import project_library.ui.component.BookConditionPanel;

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
		setBounds(100, 100, 810	, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "\uB3C4\uC11C \uD604\uD669", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		
		JLabel label_2 = new JLabel("");
		
		BookConditionPanel pBookCondition = new BookConditionPanel();
		contentPane.add(pBookCondition);
		
		JPanel pTRBCGraph = new JPanel();
		contentPane.add(pTRBCGraph);
	}

	//jtable morph --> //총 보유 권수 /총 연체권수 //총 대여 횟수 
}
