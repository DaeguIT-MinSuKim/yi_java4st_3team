package project_library.service;

import java.util.List;

import project_library.dao.SearchMemberManagementDao;
import project_library.dao.impl.SearchMemberManagementDaoImpl;
import project_library.dto.Rent;

public class SearchMemberManagementService {
	private SearchMemberManagementDao dao = SearchMemberManagementDaoImpl.getInstance();

	public List<Rent> getSearchBookManagementList() {
		return dao.selectSearchBookManagementByAll();
	}
	

	public List<Rent> getSelectSearchMemberByNoList(String memberCode) {
		return dao.selectSearchMemberByNo(memberCode);
	}


}
