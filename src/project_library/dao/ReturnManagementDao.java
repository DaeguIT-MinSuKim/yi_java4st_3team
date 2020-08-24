package project_library.dao;

import java.util.List;
import project_library.dto.Rent;

public interface ReturnManagementDao {
	List<Rent> selectReturnManagementByAll();

	Rent selectRentByNo(Rent dto);

	int insertReturnManagement(Rent dto);

	int updateReturnManagement(Rent dto);

	int deleteReturnManagement(Rent dto);
}
