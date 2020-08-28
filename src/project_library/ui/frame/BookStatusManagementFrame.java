package project_library.ui.frame;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project_library.ui.component.BookStatusPanel;

@SuppressWarnings("serial")
public class BookStatusManagementFrame extends JFrame {

	private JPanel contentPane;
	private BookStatusPanel pBStatus;
	private JPanel pBGraph;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookStatusManagementFrame frame = new BookStatusManagementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

	}

	public BookStatusManagementFrame() {
		
		initComponents();
		
	//	pBStatus.setEditalbeFalseTf();
	}

	private void initComponents() {
		setTitle("도서 현황");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pBStatus = new BookStatusPanel();
		contentPane.add(pBStatus);

		pBGraph = new JPanel();
		contentPane.add(pBGraph);

	}

}
