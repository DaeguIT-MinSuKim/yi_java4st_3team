package project_library.ui;

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

import project_library.dto.SearchMember;
import project_library.main.MemberManagementMain;

@SuppressWarnings("serial")
public class SearchMemberTable extends JTable implements MouseListener {
	private CustomTable model;
	private ArrayList<SearchMember> memberDtoList;

	public SearchMemberTable() {
		initComponents();
	}

	private void initComponents() {
		setBorder(new EmptyBorder(0, 10, 0, 10));
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addMouseListener(this);
	}

	private String[] getCols() {
		return new String[] { "회원코드", "성명", "전화번호", "총 대여 권수" };
	}

	private Object[][] getRows(ArrayList<SearchMember> memberDtoList) {
		Object[][] rows = new Object[memberDtoList.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(memberDtoList.get(i));
		}
		return rows;
	}

	private Object[] toArray(SearchMember memberDto) {
		return new Object[] { memberDto.getNo(), memberDto.getName(), memberDto.getTel(), memberDto.getRent() };
	}

	public ArrayList<SearchMember> getMemberDtoList() {
		return memberDtoList;
	}

	public void setMemberList(ArrayList<SearchMember> memberDtoList) {
		model = new CustomTable(getRows(memberDtoList), getCols());
		setModel(model);

		// column의 폭 설정
		TableColumnModel tcm = getColumnModel();
		tcm.getColumn(0).setPreferredWidth(200);
		tcm.getColumn(1).setPreferredWidth(200);
		tcm.getColumn(2).setPreferredWidth(200);
		tcm.getColumn(3).setPreferredWidth(200);

		// column의 내용 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		tcm.getColumn(2).setCellRenderer(dtcr);
		tcm.getColumn(3).setCellRenderer(dtcr);

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

	public void addMemberDto(SearchMember newMto) {
		// model 추가
		model.addRow(toArray(newMto));
	}

	public void delMemberDto(int idx) {
		// model 삭제
		model.removeRow(idx);
	}

	public void updateRow(int idx, SearchMember uptatedMem) {
		model.removeRow(idx);
		model.insertRow(idx, toArray(uptatedMem));
	}

	public void mouseClicked(MouseEvent e) {
		MemberManagementMain.pMember.setEditalbeTableTrueTf();

		int idx = MemberManagementMain.memberTable.getSelectedRow();
		SearchMember mdt = MemberManagementMain.memberDtoList.get(idx);

		SearchMemberPanel mp = new SearchMemberPanel();
		mp.setMemberDto(mdt);

		// 삭제 취소 - 수정, 삭제 버튼 활성화
		MemberManagementMain.btnUpdate.setEnabled(true);
		MemberManagementMain.btnDelete.setEnabled(true);
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
