package project_library.ui.component;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.border.TitledBorder;

public class SearchBookPanel extends JPanel {
	private JTextField tfBno;
	private JTextField tfBpr;
	private JTextField tfBname;
	private JTextField tfBPu;
	private JTextField tfBau;

	
	
	public SearchBookPanel() {
		

		initComponents();
		
		//텍스트필드 비활성화
		setEditableFalseTf();
	}


	public void setEditableFalseTf() {
		tfBno.setEditable(false);
		tfBname.setEditable(false);
		tfBPu.setEditable(false);
		tfBau.setEditable(false);
		tfBpr.setEditable(false);
	}
	
	private void initComponents() {
		
		setBorder(new TitledBorder(null, "\uB3C4\uC11C\uC815\uBCF4", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{44, 57, 116, 170, 294, 0};
		gridBagLayout.rowHeights = new int[]{21, 21, 21, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblBno = new JLabel("도서코드 :");
		GridBagConstraints gbc_lblBno = new GridBagConstraints();
		gbc_lblBno.gridwidth = 2;
		gbc_lblBno.insets = new Insets(0, 0, 5, 5);
		gbc_lblBno.gridx = 0;
		gbc_lblBno.gridy = 0;
		add(lblBno, gbc_lblBno);
		
		tfBno = new JTextField();
		GridBagConstraints gbc_tfBno = new GridBagConstraints();
		gbc_tfBno.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBno.gridwidth = 3;
		gbc_tfBno.anchor = GridBagConstraints.NORTH;
		gbc_tfBno.insets = new Insets(0, 0, 5, 0);
		gbc_tfBno.gridx = 2;
		gbc_tfBno.gridy = 0;
		add(tfBno, gbc_tfBno);
		tfBno.setColumns(10);
		
		JLabel lblBname = new JLabel("도  서 명:");
		GridBagConstraints gbc_lblBname = new GridBagConstraints();
		gbc_lblBname.gridwidth = 2;
		gbc_lblBname.insets = new Insets(0, 0, 5, 5);
		gbc_lblBname.gridx = 0;
		gbc_lblBname.gridy = 1;
		add(lblBname, gbc_lblBname);
		
		tfBname = new JTextField();
		tfBname.setColumns(10);
		GridBagConstraints gbc_tfBname = new GridBagConstraints();
		gbc_tfBname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBname.gridwidth = 3;
		gbc_tfBname.anchor = GridBagConstraints.NORTH;
		gbc_tfBname.insets = new Insets(0, 0, 5, 0);
		gbc_tfBname.gridx = 2;
		gbc_tfBname.gridy = 1;
		add(tfBname, gbc_tfBname);
		
		JLabel lblBpu = new JLabel("출  판 사:");
		GridBagConstraints gbc_lblBpu = new GridBagConstraints();
		gbc_lblBpu.gridwidth = 2;
		gbc_lblBpu.insets = new Insets(0, 0, 5, 5);
		gbc_lblBpu.gridx = 0;
		gbc_lblBpu.gridy = 2;
		add(lblBpu, gbc_lblBpu);
		
		tfBPu = new JTextField();
		tfBPu.setColumns(10);
		GridBagConstraints gbc_tfBPu = new GridBagConstraints();
		gbc_tfBPu.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBPu.gridwidth = 3;
		gbc_tfBPu.anchor = GridBagConstraints.NORTH;
		gbc_tfBPu.insets = new Insets(0, 0, 5, 0);
		gbc_tfBPu.gridx = 2;
		gbc_tfBPu.gridy = 2;
		add(tfBPu, gbc_tfBPu);
		
		JLabel lblBau = new JLabel("저      자:");
		GridBagConstraints gbc_lblBau = new GridBagConstraints();
		gbc_lblBau.gridwidth = 2;
		gbc_lblBau.insets = new Insets(0, 0, 5, 5);
		gbc_lblBau.gridx = 0;
		gbc_lblBau.gridy = 3;
		add(lblBau, gbc_lblBau);
		
		tfBau = new JTextField();
		tfBau.setColumns(10);
		GridBagConstraints gbc_tfBau = new GridBagConstraints();
		gbc_tfBau.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBau.gridwidth = 3;
		gbc_tfBau.insets = new Insets(0, 0, 5, 0);
		gbc_tfBau.anchor = GridBagConstraints.NORTH;
		gbc_tfBau.gridx = 2;
		gbc_tfBau.gridy = 3;
		add(tfBau, gbc_tfBau);
		
		JLabel lblBpr = new JLabel("가      격:");
		GridBagConstraints gbc_lblBpr = new GridBagConstraints();
		gbc_lblBpr.gridwidth = 2;
		gbc_lblBpr.insets = new Insets(0, 0, 0, 5);
		gbc_lblBpr.gridx = 0;
		gbc_lblBpr.gridy = 4;
		add(lblBpr, gbc_lblBpr);
		
		tfBpr = new JTextField();
		tfBpr.setColumns(10);
		GridBagConstraints gbc_tfBpr = new GridBagConstraints();
		gbc_tfBpr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBpr.gridwidth = 3;
		gbc_tfBpr.anchor = GridBagConstraints.NORTH;
		gbc_tfBpr.gridx = 2;
		gbc_tfBpr.gridy = 4;
		add(tfBpr, gbc_tfBpr);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tfBpr, lblBno, tfBno, lblBname, tfBname, lblBau, lblBpu, tfBPu, tfBau, lblBpr}));
	}

	

	
}
