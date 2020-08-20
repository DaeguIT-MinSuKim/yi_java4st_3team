package project_library.member.component;

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

import project_library.member.dto.Member;
import project_library.member_management.MemberManagement;

@SuppressWarnings("serial")
public class MemberTable extends JTable implements MouseListener {
	private CustomTable model;
	private ArrayList<Member> memberDtoList;

	public MemberTable() {
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

	private Object[][] getRows(ArrayList<Member> memberDtoList) {
		Object[][] rows = new Object[memberDtoList.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(memberDtoList.get(i));
		}
		return rows;
	}

	private Object[] toArray(Member memberDto) {
		return new Object[] { memberDto.getNo(), memberDto.getName(), memberDto.getTel(), memberDto.getRent() };
	}

	public ArrayList<Member> getMemberDtoList() {
		return memberDtoList;
	}

	public void setMemberList(ArrayList<Member> memberDtoList) {
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

	public void addMemberDto(Member newMto) {
		// model 추가
		model.addRow(toArray(newMto));
	}

	public void delMemberDto(int idx) {
		// model 삭제
		model.removeRow(idx);
	}

	public void updateRow(int idx, Member uptatedMem) {
		model.removeRow(idx);
		model.insertRow(idx, toArray(uptatedMem));
	}

	public void mouseClicked(MouseEvent e) {
		MemberManagement.pMember.setEditalbeTableTrueTf();

		int idx = MemberManagement.memberTable.getSelectedRow();
		Member mdt = MemberManagement.memberDtoList.get(idx);

		MemberPanel mp = new MemberPanel();
		mp.setMemberDto(mdt);

		// 삭제 취소 - 수정, 삭제 버튼 활성화
		MemberManagement.btnUpdate.setEnabled(true);
		MemberManagement.btnDelete.setEnabled(true);
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
