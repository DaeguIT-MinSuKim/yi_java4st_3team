package project_library.dao;

import java.util.List;

import project_library.dto.Rent;

public interface RentalManagementDao {
	List<Rent> selectRentalManagementByAll();

	Rent selectRentalManagementByNo(Rent dto);

	int insertRentalManagement(Rent dto);
	
	int updateRentalManagement_book(Rent dto);
	int updateRentalManagement_member(Rent dto);

	//int deleteRentalManagement(Rent dto);
}
