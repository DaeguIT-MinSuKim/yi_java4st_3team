package project_librery.searchMember_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import project_library.member.component.MemberPanel;
import project_librery.searchMember.component.MemberSearchPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import project_librery.searchMember.component.MemberSearchButton;

public class MemberSearchManagement extends JFrame {

	private JPanel contentPane;
	public static MemberSearchPanel pInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSearchManagement frame = new MemberSearchManagement();
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
	public MemberSearchManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810	, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pInput = new MemberSearchPanel();
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
