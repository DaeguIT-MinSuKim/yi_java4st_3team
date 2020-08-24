package project_library.service;

import java.util.List;

import project_library.dao.MemberManagementDao;
import project_library.dao.impl.MemberManagementDaoImpl;
import project_library.dto.Member;

public class MemberManagementService {
	private MemberManagementDao dao = MemberManagementDaoImpl.getInstance();

	public List<Member> getMemberDtoList() {
		return dao.selectMemberByAll();
	}

	public void insertMember(Member mdto) {
		dao.insertMember(mdto);
	}

	public void modifyMember(Member mdto) {
		dao.updateMember(mdto);
	}

	public void removeMember(Member mdto) {
		dao.deleteMember(mdto);
	}

}
