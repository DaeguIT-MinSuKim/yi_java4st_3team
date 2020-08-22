package project_library.ui.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import project_library.dto.BookManagement;
import project_library.dto.RentalManagement;

@SuppressWarnings("serial")
public class RentalManagementTable extends JTable implements MouseListener {
	private CustomTable model;
	private ArrayList<RentalManagement> rentalList;
	
	public RentalManagementTable() {
		initComponents();
	}

	private void initComponents() {
		setBorder(new EmptyBorder(0, 10, 0, 10));
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addMouseListener(this);
	}
	private Object[][] getRows(ArrayList<RentalManagement> rentalList) {
		Object[][] rows = new Object[rentalList.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(rentalList.get(i));
		}
		return rows;
	}
	private Object[] toArray(RentalManagement rentalManagement) {
		return new Object[] { 
			rentalManagement.getBookCode(), 
			rentalManagement.getBookName(), 
			rentalManagement.getAuthor(), 
			rentalManagement.getPublisher(), 
			rentalManagement.getPrice(), 
			rentalManagement.getTotalRental()
		};
	}
	private String[] getCols() {
		return new String[] { "도서코드", "도서명", "저자", "출판사", "가격", "총대여 횟수" };
	}
	
	public ArrayList<RentalManagement> getBList() {
		return rentalList;
	}
	
	public void setRentalManagementList(ArrayList<RentalManagement> rentalList) {
		model = new CustomTable(getRows(rentalList), getCols());
		setModel(model);

		// column의 폭 설정
		TableColumnModel tcm = getColumnModel();
		tcm.getColumn(0).setPreferredWidth(100);
		tcm.getColumn(1).setPreferredWidth(450);
		tcm.getColumn(2).setPreferredWidth(150);
		tcm.getColumn(3).setPreferredWidth(200);
		tcm.getColumn(4).setPreferredWidth(100);

		// column의 내용 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		tcm.getColumn(2).setCellRenderer(dtcr);
		tcm.getColumn(3).setCellRenderer(dtcr);
		tcm.getColumn(4).setCellRenderer(dtcr);

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		setRowSorter(sorter);

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



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
  