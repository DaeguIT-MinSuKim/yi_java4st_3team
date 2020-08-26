package project_library.service;

import java.util.List;

import project_library.dao.ReturnManagementDao;
import project_library.dao.impl.ReturnManagementDaoImpl;
import project_library.dto.Rent;

public class ReturnManagementService {
	private ReturnManagementDao dao = ReturnManagementDaoImpl.getInstance();

	public List<Rent> getReturnManagementList() {
		return dao.selectReturnManagementByAll();
	}

	public void insertBook(Rent dto) {
		dao.insertReturnManagement(dto);
	}

	public void modifyReturnManagement(Rent dto) {
		dao.updateReturnManagement_isRent(dto);
		dao.updateReturnManagement_returnDate(dto);
	}

	public void removeBook(Rent dto) {
		dao.deleteReturnManagement(dto);
	}
}
