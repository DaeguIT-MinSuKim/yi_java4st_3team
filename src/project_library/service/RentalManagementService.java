package project_library.service;

import java.util.List;

import project_library.dao.RentalManagementDao;
import project_library.dao.impl.RentalManagementDaoImpl;
import project_library.dto.Rent;

public class RentalManagementService {
	private RentalManagementDao dao = RentalManagementDaoImpl.getInstance();

	public List<Rent> getRentalManagementList() {
		return dao.selectRentalManagementByAll();
	}

	public void insertBook(Rent dto) {
		dao.insertRentalManagement(dto);
	}

	public void modifyBook(Rent dto) {
		dao.updateRentalManagement_book(dto);
		dao.updateRentalManagement_member(dto);
	}
	
/*
	public void removeBook(Rent dto) {
		dao.deleteRentalManagement(dto);
	}*/
}
