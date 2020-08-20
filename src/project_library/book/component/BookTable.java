package project_library.book.component;

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

import project_library.book.dto.Book;
import project_library.book_management.BookManagement;

@SuppressWarnings("serial")
public class BookTable extends JTable implements MouseListener {

	private CustomTable model;
	private ArrayList<Book> bList;

	public BookTable() {
		initComponents();
	}

	private void initComponents() {
		setBorder(new EmptyBorder(0, 10, 0, 10));
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addMouseListener(this);
	}

	private String[] getCols() {
		return new String[] { "도서코드", "도서명", "저자", "출판사", "가격" };
	}

	private Object[][] getRows(ArrayList<Book> bList) {
		Object[][] rows = new Object[bList.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(bList.get(i));
		}
		return rows;
	}

	private Object[] toArray(Book bookDto) {
		return new Object[] { bookDto.getNo(), bookDto.getBookName(), bookDto.getAuthor(), bookDto.getPublisher(),
				bookDto.getPrice() };
	}

	public ArrayList<Book> getBList() {
		return bList;
	}

	public void setBookList(ArrayList<Book> bList) {
		model = new CustomTable(getRows(bList), getCols());
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

	public void addBookDto(Book newBto) {
		// model 추가
		model.addRow(toArray(newBto));
	}

	public void delBookDto(int idx) {
		// model 삭제
		model.removeRow(idx);
	}

	public void updateRow(int idx, Book uptatedBom) {
		model.removeRow(idx);
		model.insertRow(idx, toArray(uptatedBom));
	}

	public void mouseClicked(MouseEvent e) {
		BookManagement.pBPanel.setEditalbeTableTrueTf();

		int idx = BookManagement.table.getSelectedRow();
		Book bdt = BookManagement.bList.get(idx);

		BookPanel bp = new BookPanel();
		bp.setBookDto(bdt);

		// 삭제 취소 - 수정, 삭제 버튼 활성화
		BookButton.btnUpdate.setEnabled(true);
		BookButton.btnDelete.setEnabled(true);
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	protected void mouseClickedThis(MouseEvent e) {

	}

}
