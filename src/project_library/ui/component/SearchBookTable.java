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

import project_library.dto.Rent;

public class SearchBookTable extends JTable implements MouseListener {
	private CustomTable model;
	private ArrayList<Rent> rentalList;
	
	public SearchBookTable() {
		initComponents();
	}

	private void initComponents() {
		setBorder(new EmptyBorder(0, 10, 0, 10));
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addMouseListener(this);
	}

	private Object[][] getRows(ArrayList<Rent> rentalList) {
		Object[][] rows = new Object[rentalList.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(rentalList.get(i)); 
		}
		return rows;
	}
	
	private Object[] toArray(Rent rent) {
		return new Object[] {
		rent.getMemberCode(),
		rent.getMemberName(),
		rent.getReturnDate(),
		rent.getRentDate(),
		rent.getIsDelay()
		};
	}

	private String[] getCols() {
		return new String[] {"회원코드", "성명", "대여일", "반납일", "연체여부"};
	}

	private class CustomTable extends DefaultTableModel{
		public CustomTable(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	}
	
	public ArrayList<Rent> getBList() {
		return rentalList;
	}
	
	public void setBookSearchManagementList(ArrayList<Rent> SBookList) {
		model = new CustomTable(getRows(SBookList), getCols());
		setModel(model);

		// column의 폭 설정
		TableColumnModel tcm = getColumnModel();
		tcm.getColumn(0).setPreferredWidth(100);
		tcm.getColumn(1).setPreferredWidth(200);
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

//		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
//		setRowSorter(sorter);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}