package project_library.dao;

import java.util.List;

import project_library.dto.Book;
import project_library.dto.Rent;

public interface SearchMemberManagementDao {
	List<Rent> selectSearchBookManagementByAll();

}
