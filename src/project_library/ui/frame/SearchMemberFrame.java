package project_library.ui.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import project_library.ui.component.SearchMemberButton;
import project_library.ui.component.SearchMemberInfoShowPanel;
import project_library.ui.component.SearchMemberInputPanel;
import project_library.ui.component.SearchMemberTable_young;
import project_library.ui.component.SearchMemberTotalCountPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SearchMemberFrame extends JFrame {

	private JPanel contentPane;
	public static SearchMemberInputPanel pInput;
	public static SearchMemberTable_young table;
	public static JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMemberFrame frame = new SearchMemberFrame();
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
	public SearchMemberFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810	, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pInput = new SearchMemberInputPanel();
		pInput.tfCode.setHorizontalAlignment(SwingConstants.LEFT);
		pInput.setBorder(new EmptyBorder(0, 20, 0, 20));
		contentPane.add(pInput);
		
		SearchMemberButton pBtns = new SearchMemberButton();
		contentPane.add(pBtns);
		pBtns.setbFrame(this);
		
		SearchMemberInfoShowPanel pMemberInfo =  new SearchMemberInfoShowPanel();
		contentPane.add(pMemberInfo);
		
		JPanel pRentInfo = new JPanel();
		contentPane.add(pRentInfo);
		pRentInfo.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pRentInfo.add(scrollPane, BorderLayout.CENTER);
		
		table = new SearchMemberTable_young();
		scrollPane.setViewportView(table);
		
		SearchMemberTotalCountPanel pRentInfoTotal = new SearchMemberTotalCountPanel();
		contentPane.add(pRentInfoTotal);
		
		//table에 가지고 온 회원의 대여정보 + 총계를 가지고 오기 
	}

}
