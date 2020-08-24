package project_library.ui.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import project_library.ui.component.SearchBookPanel;
import project_library.ui.component.SearchBookButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Component;

public class SearchBookFrame extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		SearchBookPanel panel_5 = new SearchBookPanel();
		contentPane.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0};
		gbl_panel_5.rowHeights = new int[]{0};
		gbl_panel_5.columnWeights = new double[]{};
		gbl_panel_5.rowWeights = new double[]{};
		panel_5.setLayout(gbl_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0};
		gbl_panel_5.rowHeights = new int[]{0};
		gbl_panel_5.columnWeights = new double[]{};
		gbl_panel_5.rowWeights = new double[]{};
		panel_5.setLayout(gbl_panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0};
		gbl_panel_5.rowHeights = new int[]{0};
		gbl_panel_5.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		SearchBookButton panel_2 = new SearchBookButton();
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
	}

}
