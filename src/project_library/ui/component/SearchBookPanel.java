package project_library.ui.component;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SearchBookPanel extends JPanel {
	private JTextField tfBook;

	/**
	 * Create the panel.
	 */
	public SearchBookPanel() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{155, 99, 199, 116, 0};
		gridBagLayout.rowHeights = new int[]{23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JRadioButton rdbtnBookName = new JRadioButton("도서명");
		rdbtnBookName.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_rdbtnBookName = new GridBagConstraints();
		gbc_rdbtnBookName.anchor = GridBagConstraints.NORTHEAST;
		gbc_rdbtnBookName.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnBookName.gridx = 0;
		gbc_rdbtnBookName.gridy = 0;
		add(rdbtnBookName, gbc_rdbtnBookName);
		
		JRadioButton rdbtnBookCode = new JRadioButton("도서코드");
		GridBagConstraints gbc_rdbtnBookCode = new GridBagConstraints();
		gbc_rdbtnBookCode.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnBookCode.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnBookCode.gridx = 1;
		gbc_rdbtnBookCode.gridy = 0;
		add(rdbtnBookCode, gbc_rdbtnBookCode);
		
		tfBook = new JTextField();
		GridBagConstraints gbc_tfBook = new GridBagConstraints();
		gbc_tfBook.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBook.insets = new Insets(0, 0, 0, 5);
		gbc_tfBook.gridx = 2;
		gbc_tfBook.gridy = 0;
		add(tfBook, gbc_tfBook);
		tfBook.setColumns(10);

	}

}
