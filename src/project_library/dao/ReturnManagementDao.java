package project_library.dao;

import java.util.List;

import project_library.dto.ReturnManagement;

public interface ReturnManagementDao {
	List<ReturnManagement> selectReturnManagementByAll();

	ReturnManagement selectReturnManagementByNo(ReturnManagement dto);

	int insertReturnManagement(ReturnManagement dto);

	int updateReturnManagement(ReturnManagement dto);

	int deleteReturnManagement(ReturnManagement dto);
}
