package project_library.service;

import java.util.List;

import project_library.dao.RentalManagementDao;
import project_library.dao.impl.RentalManagementDaoImpl;
import project_library.dto.RentalManagement;

public class RentalManagementService {
	private RentalManagementDao dao = RentalManagementDaoImpl.getInstance();

	public List<RentalManagement> getRentalManagementList() {
		return dao.selectRentalManagementByAll();
	}

	public void insertBook(RentalManagement dto) {
		dao.insertRentalManagement(dto);
	}

	public void modifyBook(RentalManagement dto) {
		dao.updateRentalManagement(dto);
	}

	public void removeBook(RentalManagement dto) {
		dao.deleteRentalManagement(dto);
	}
}
