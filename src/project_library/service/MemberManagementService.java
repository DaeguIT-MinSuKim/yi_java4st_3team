package project_library.service;

import java.util.List;

import project_library.dao.MemberManagementDao;
import project_library.dao.impl.MemberManagementDaoImpl;
import project_library.dto.SearchMember;

public class MemberManagementService {
	private MemberManagementDao dao = MemberManagementDaoImpl.getInstance();

	public List<SearchMember> getMemberDtoList() {
		return dao.selectMemberByAll();
	}

	public void insertMember(SearchMember mdto) {
		dao.insertMember(mdto);
	}

	public void modifyMember(SearchMember mdto) {
		dao.updateMember(mdto);
	}

	public void removeMember(SearchMember mdto) {
		dao.deleteMember(mdto);
	}

}
