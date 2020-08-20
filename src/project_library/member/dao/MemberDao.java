package project_library.member.dao;

import java.util.List;

import project_library.member.dto.Member;

public interface MemberDao {
	List<Member> selectMemberByAll();

	Member selectMemberByNo(Member mdto);

	int insertMember(Member mdto);

	int updateMember(Member mdto);

	int deleteMember(Member mdto);

}

