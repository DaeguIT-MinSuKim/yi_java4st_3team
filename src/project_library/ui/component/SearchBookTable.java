package project_library.ui.component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SearchBookTable extends JTable {
	public SearchBookTable() {
		setModel(new DefaultTableModel(
			getRows(),
			getCols()
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
