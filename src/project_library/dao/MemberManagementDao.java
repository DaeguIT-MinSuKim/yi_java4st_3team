package project_library.dao;

import java.util.List;

import project_library.dto.SearchMember;

public interface MemberManagementDao {
	List<SearchMember> selectMemberByAll();

	SearchMember selectMemberByNo(SearchMember mdto);

	int insertMember(SearchMember mdto);

	int updateMember(SearchMember mdto);

	int deleteMember(SearchMember mdto);

}
