package project_library.ui.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import project_library.dto.Book;
import project_library.dto.Member;
import project_library.ui.frame.BookManagementFrame;

@SuppressWarnings("serial")
public class BookManagementTable extends JTable implements MouseListener {

	private CustomTable model;
	private ArrayList<Book> bookList;
		
	public BookManagementTable() {
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

	private Object[][] getRows(ArrayList<Book> bookList) {
		Object[][] rows = new Object[bookList.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(bookList.get(i));
		}
		return rows;
	}

	private Object[] toArray(Book bookDto) {
		return new Object[] { bookDto.getNo(), bookDto.getBookName(), bookDto.getAuthor(), bookDto.getPublisher(),
				String.format("%,d원", bookDto.getPrice()) };
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		model = new CustomTable(getRows(bookList), getCols());
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

		// RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		// setRowSorter(sorter);

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

	public void updateRow(int idx, Book updatedBoo) {
		model.removeRow(idx);
		model.insertRow(idx, toArray(updatedBoo));
	}

	public void mouseClicked(MouseEvent e) {
		BookManagementFrame.pBPanel.setEditalbeTableTrueTf();

		int idx = BookManagementFrame.bookTable.getSelectedRow();
		Book bdt = BookManagementFrame.bookList.get(idx);

		BookManagementPanel bp = new BookManagementPanel();
		bp.setBookDto(bdt);

		// 삭제 취소 - 수정, 삭제 버튼 활성화
		BookManagementButton.btnUpdate.setEnabled(true);
		BookManagementButton.btnDelete.setEnabled(true);
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
