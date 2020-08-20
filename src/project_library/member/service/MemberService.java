package project_library.member.service;

import java.util.List;

import project_library.member.dao.MemberDao;
import project_library.member.dao.impl.MemberDaoImpl;
import project_library.member.dto.Member;

public class MemberService {
	private MemberDao dao = MemberDaoImpl.getInstance();

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
