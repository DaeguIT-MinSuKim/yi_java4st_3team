package project_library.dao;

import java.util.List;

import project_library.dto.RentalManagement;

public interface RentalManagementDao {
	List<RentalManagement> selectRentalManagementByAll();

	RentalManagement selectRentalManagementByNo(RentalManagement dto);

	int insertRentalManagement(RentalManagement dto);

	int updateRentalManagement(RentalManagement dto);

	int deleteRentalManagement(RentalManagement dto);
}
