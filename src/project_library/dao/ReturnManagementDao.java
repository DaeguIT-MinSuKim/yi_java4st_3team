package project_library.dao;

import java.util.List;
import project_library.dto.Rent;

public interface ReturnManagementDao {
	List<Rent> selectReturnManagementByAll();

	Rent selectReturnManagementByNo(Rent dto);

	int insertReturnManagement(Rent dto);

	int updateReturnManagement_isRent(Rent dto);
	int updateReturnManagement_returnDate(Rent dto);

	int deleteReturnManagement(Rent dto);

}
