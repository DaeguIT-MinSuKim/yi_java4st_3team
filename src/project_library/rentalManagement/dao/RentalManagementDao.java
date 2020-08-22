package project_library.rentalManagement.dao;

import java.util.List;

import project_library.rentalManagement.dto.RentalManagement;

public interface RentalManagementDao {
	List<RentalManagement> selectRentalManagementByAll();

	RentalManagement selectRentalManagementByNo(RentalManagement dto);

	int insertRentalManagement(RentalManagement dto);

	int updateRentalManagement(RentalManagement dto);

	int deleteRentalManagement(RentalManagement dto);
}
