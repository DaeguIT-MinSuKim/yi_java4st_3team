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

@SuppressWarnings("serial")
public class SearchMemberPanel_onlyname extends JPanel  {
	public JTextField tfName;

	public SearchMemberPanel_onlyname() {
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

		JLabel lblName = new JLabel("성      명 : ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);

		tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tfName.setColumns(20);
		tfName.setBorder(new EmptyBorder(5, 10, 5, 5));
		tfName.setBorder((Border) (new LineBorder(Color.black, 1)));
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.gridwidth = 3;
		gbc_tfName.insets = new Insets(5, 5, 5, 5);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 1;
		gbc_tfName.gridy = 1;
		add(tfName, gbc_tfName);

	}

	protected void setItem(Member idx) {
		tfName.setText(idx.getName());
	}


	// Clear
	public void clearTf() {
		tfName.setText("");
	}




	// Table 클릭 시



}
