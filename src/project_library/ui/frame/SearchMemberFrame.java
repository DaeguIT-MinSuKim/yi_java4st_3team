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
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SearchMemberFrame extends JFrame {

	private JPanel contentPane;
	public static SearchMemberInputPanel pInput;
	public static SearchMemberTable_young stable;
	public static JScrollPane scrollPane;

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

	public SearchMemberFrame() {
		setTitle("회원 검색");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		pRentInfo.setBorder(new TitledBorder(null, "\uB300\uC5EC\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRentInfo);
		pRentInfo.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pRentInfo.add(scrollPane, BorderLayout.CENTER);
		
		stable = new SearchMemberTable_young();
		stable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"도서코드", "도서명", "대여일자", "반납일자", "연체여부"
			}
		));
		scrollPane.setViewportView(stable);
		
		SearchMemberTotalCountPanel pRentInfoTotal = new SearchMemberTotalCountPanel();
		contentPane.add(pRentInfoTotal);
		
		//table에 가지고 온 회원의 대여정보 + 총계를 가지고 오기 
	}

}
