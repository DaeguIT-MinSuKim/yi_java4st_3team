package project_library.dao;

import java.util.List;

import project_library.dto.Book;
import project_library.dto.Rent;

public interface SearchBookManagementDao {
	List<Rent> selectSearchBookManagementByAll();

	Rent selectSearchBookManagementByNo(Rent dto);

	int insertSearchBookManagement(Rent dto);
	
	int updateSearchBookManagement_book(Rent dto);
	
	int updateSearchBookManagement_member(Rent dto);

	List<Rent> selectSearchBookWhere(boolean isCode, String searchKey);
	//int deleteRentalManagement(Rent dto);
}
