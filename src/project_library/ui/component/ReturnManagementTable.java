package project_library.ui.component;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import project_library.dto.RentalManagement;
import project_library.dto.ReturnManagement;
import project_library.ui.frame.ReturnManagementFrame;

@SuppressWarnings("serial")
public class ReturnManagementTable extends JTable {
	
	private CustomTable model;
	private ArrayList<ReturnManagement> returnList;
	
	public ReturnManagementTable() {
		initComponents();
		
		//setModel(new DefaultTableModel(getRows(), getCols()));
	}

	private void initComponents() {
		setBorder(new EmptyBorder(0, 10, 0, 10));
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		/* addMouseListener(this); */
	}

	private class CustomTable extends DefaultTableModel {
		public CustomTable(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}

	private String[] getCols() {
		return new String[] { "도서코드", "도서명", "회원코드", "회원명", "대여일" };
	}

	private Object[][] getRows(ArrayList<ReturnManagement> returnList) {
		Object[][] rows = new Object[returnList.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(returnList.get(i));
		}
		return rows;
	}

	private Object[] toArray(ReturnManagement returnManagement) {
		return new Object[] { 
				returnManagement.getBookCode(),
				returnManagement.getBookName(),
				returnManagement.getMemberCode(),
				returnManagement.getMemberName(),
				returnManagement.getRentalDate()
			};
	}

	public ArrayList<ReturnManagement> getBList() {
		return returnList;
	}

	public void setReturnManagementList(ArrayList<ReturnManagement> returnList) {
		model = new CustomTable(getRows(returnList), getCols());
		setModel(model);

		// column의 폭 설정
		TableColumnModel tcm = getColumnModel();
		tcm.getColumn(0).setPreferredWidth(100);
		tcm.getColumn(1).setPreferredWidth(200);
		tcm.getColumn(2).setPreferredWidth(150);
		tcm.getColumn(3).setPreferredWidth(200);
		tcm.getColumn(4).setPreferredWidth(100);
		tcm.getColumn(5).setPreferredWidth(100);

		// column의 내용 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		tcm.getColumn(2).setCellRenderer(dtcr);
		tcm.getColumn(3).setCellRenderer(dtcr);
		tcm.getColumn(4).setCellRenderer(dtcr);
		tcm.getColumn(5).setCellRenderer(dtcr);

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		setRowSorter(sorter);

}
/*
 * @Override public void mouseClicked(MouseEvent arg0) {
 * ReturnManagementFrame.pRPanel.setEditalbeTableTrueTf();
 * 
 * int idx = ReturnManagementFrame.table.getSelectedRow(); RentalManagement bdt
 * = ReturnManagementFrame.returnManagementList.get(idx);
 * 
 * RentalManagementPanel rp = new RentalManagementPanel();
 * rp.setRentalManagementDto(bdt); }
 * 
 * @Override public void mouseEntered(MouseEvent arg0) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * @Override public void mouseExited(MouseEvent arg0) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * @Override public void mousePressed(MouseEvent arg0) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * @Override public void mouseReleased(MouseEvent arg0) { // TODO Auto-generated
 * method stub
 * 
 * }
 */
}	
