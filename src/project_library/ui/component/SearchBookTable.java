package project_library.ui.component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

public class SearchBookTable extends JTable {
	public SearchBookTable() {
		setBorder(new TitledBorder(null, "\uB300\uC5EC\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\uD68C\uC6D0\uCF54\uB4DC", "\uC131\uBA85", "\uB300\uC5EC\uC77C", "\uBC18\uB0A9\uC77C", "\uC5F0\uCCB4\uC5EC\uBD80"
			}
		));
	}

	private Object[][] getRows() {
		return new Object[][] {
			{null, null, null, null, null},
		};
	}

	private String[] getCols() {
		return new String[] {
			"회원코드", "성명", "대여일", "반납일", "연체여부"
		};
	}

}
