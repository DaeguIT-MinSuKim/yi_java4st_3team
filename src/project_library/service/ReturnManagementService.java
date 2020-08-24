package project_library.service;

import java.util.List;

import project_library.dao.ReturnManagementDao;
import project_library.dao.impl.RentalManagementDaoImpl;
import project_library.dao.impl.ReturnManagementDaoImpl;
import project_library.dto.ReturnManagement;

public class ReturnManagementService {
	private ReturnManagementDao dao = ReturnManagementDaoImpl.getInstance();

	public List<ReturnManagement> getReturnManagementList() {
		return dao.selectReturnManagementByAll();
	}

	public void insertBook(ReturnManagement dto) {
		dao.insertReturnManagement(dto);
	}

	public void modifyBook(ReturnManagement dto) {
		dao.updateReturnManagement(dto);
	}

	public void removeBook(ReturnManagement dto) {
		dao.deleteReturnManagement(dto);
	}
}
