package project_library.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import project_library.dto.Member;
import project_library.exception.EmptyTfException;
import project_library.exception.FristCharException;
import project_library.exception.InValidationException;
import project_library.ui.frame.MemberManagementFrame;
import project_library.ui.component.SearchMemberButton;

@SuppressWarnings("serial")
public class SearchMemberInfoShowPanel extends JPanel  {
	private JLabel lblGetNo;
	private JLabel lblGetName;
	private JLabel lblGetTel;

	public SearchMemberInfoShowPanel() {
		initComponents();
	}

	private void initComponents() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 150, 150, 150 };
		gridBagLayout.rowHeights = new int[] { 30, 30, 30 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		JLabel lblNo = new JLabel("회원코드 : ");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNo.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblNo = new GridBagConstraints();
		gbc_lblNo.anchor = GridBagConstraints.EAST;
		gbc_lblNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNo.gridx = 0;
		gbc_lblNo.gridy = 0;
		add(lblNo, gbc_lblNo);
		
		lblGetNo = new JLabel("");
		GridBagConstraints gbc_lblGetNo = new GridBagConstraints();
		gbc_lblGetNo.gridwidth = 3;
		gbc_lblGetNo.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetNo.gridx = 1;
		gbc_lblGetNo.gridy = 0;
		add(lblGetNo, gbc_lblGetNo);

		JLabel lblName = new JLabel("성      명 : ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);
		
		lblGetName = new JLabel("");
		GridBagConstraints gbc_lblGetName = new GridBagConstraints();
		gbc_lblGetName.gridwidth = 3;
		gbc_lblGetName.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetName.gridx = 1;
		gbc_lblGetName.gridy = 1;
		add(lblGetName, gbc_lblGetName);

		JLabel lblTel = new JLabel("전화번호 : ");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblTel = new GridBagConstraints();
		gbc_lblTel.anchor = GridBagConstraints.EAST;
		gbc_lblTel.insets = new Insets(0, 0, 0, 5);
		gbc_lblTel.gridx = 0;
		gbc_lblTel.gridy = 2;
		add(lblTel, gbc_lblTel);
		
		lblGetTel = new JLabel("");
		GridBagConstraints gbc_lblGetTel = new GridBagConstraints();
		gbc_lblGetTel.insets = new Insets(0, 0, 0, 5);
		gbc_lblGetTel.gridx = 1;
		gbc_lblGetTel.gridy = 2;
		add(lblGetTel, gbc_lblGetTel);

	}


	public JLabel getLblGetNo() {
		return lblGetNo;
	}

	public void setLblGetNo(JLabel lblGetNo) {
		this.lblGetNo = lblGetNo;
	}

	public JLabel getLblGetName() {
		return lblGetName;
	}

	public void setLblGetName(JLabel lblGetName) {
		this.lblGetName = lblGetName;
	}

	public JLabel getLblGetTel() {
		return lblGetTel;
	}

	public void setLblGetTel(JLabel lblGetTel) {
		this.lblGetTel = lblGetTel;
	}

	public void setItem(SearchMemberButton btn) {
		lblGetNo.setText(btn.getMemberCode);
		lblGetName.setText(btn.getMemberName);
		lblGetTel.setText(btn.getMemberTel);
	}
	// Clear
	public void clearTf() {
		lblGetNo.setText("");
		lblGetName.setText("");
		lblGetTel.setText("");
	}
}
