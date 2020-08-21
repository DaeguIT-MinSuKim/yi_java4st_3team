package project_librery.searchMember.management;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project_library.member.component.MemberPanel;
import project_library.searchMember.component.MemberSearchButton;
import project_librery.searchMember.component.MemberResearchPanel;

public class MemberResearchManagement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberResearchManagement frame = new MemberResearchManagement();
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
	public MemberResearchManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810	, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		MemberResearchPanel pInput = new MemberResearchPanel();
		pInput.setBorder(new EmptyBorder(0, 20, 0, 20));
		contentPane.add(pInput);
		
		MemberSearchButton pBtns = new MemberSearchButton();
		contentPane.add(pBtns);
		
		MemberPanel pMemberInfo = new MemberPanel();
		contentPane.add(pMemberInfo);
		
		JPanel pRentInfo = new JPanel();
		contentPane.add(pRentInfo);
	}

}
