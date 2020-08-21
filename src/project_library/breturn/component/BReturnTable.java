package project_library.breturn.component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class BReturnTable extends JTable {
	public BReturnTable() {
		setModel(new DefaultTableModel(getRows(), getCols()));
	}

	private Object[][] getRows() {
		return new Object[][] { { null, null, null, null, null }, };
	}

	private String[] getCols() {
		return new String[] { "도서코드", "도서명", "회원코드", "회원명", "대여일" };
	}

}
