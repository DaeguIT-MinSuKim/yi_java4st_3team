package project_library.dao;

public interface BookStatusManagementDao {

	int selectTotalBook();

	int selectTotalOverdueBook();

	int selectTotalRentalBook();

}
