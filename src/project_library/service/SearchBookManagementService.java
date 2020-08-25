package project_library.service;

import java.util.List;

import project_library.dao.SearchBookManagementDao;
import project_library.dao.impl.SearchBookManagementDaoImpl;
import project_library.dto.Rent;

public class SearchBookManagementService {
	private SearchBookManagementDao dao = SearchBookManagementDaoImpl.getInstance();

	public List<Rent> getSearchBookManagementList() {
		return dao.selectSearchBookManagementByAll();
	}

	public void insertBook(Rent dto) {
		dao.insertSearchBookManagement(dto);
	}

	public void modifyBook(Rent dto) {
		dao.updateSearchBookManagement_book(dto);
		dao.updateSearchBookManagement_member(dto);
	}
	
/*
	public void removeBook(Rent dto) {
		dao.deleteRentalManagement(dto);
	}*/
}
