package project_library.dao;

import java.util.List;

import project_library.dto.Member;

public interface MemberManagementDao {
	List<Member> selectMemberByAll();

	Member selectMemberByNo(Member mdto);

	int insertMember(Member mdto);

	int updateMember(Member mdto);

	int deleteMember(Member mdto);

}
