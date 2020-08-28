package project_library.dao.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookStatusManagementDaoTest {

	@Test
	public void test01SelectTotalBook() {
		System.out.println("test01SelectTotalBook");
		int totalBook = BookStatusManagementDaoImpl.getInstance().selectTotalBook();
		Assert.assertNotNull(totalBook);

		System.out.printf("%s%s%n%n", totalBook, "권" + " - " + "총 대여 권수");
	}

	@Test
	public void test02SelectTotalOverdueBook() {
		System.out.println("test02SelectTotalOverdueBook");
		int overdueBook = BookStatusManagementDaoImpl.getInstance().selectTotalOverdueBook();
		Assert.assertNotNull(overdueBook);

		System.out.printf("%s%s%n%n", overdueBook, "권" + " - " + "총 연체 권수");
	}

	@Test
	public void test03SelectTotalRentalBook() {
		System.out.println("test03SelectTotalRentalBook");
		int rentalBook = BookStatusManagementDaoImpl.getInstance().selectTotalRentalBook();
		Assert.assertNotNull(rentalBook);

		System.out.printf("%s%s%n%n", rentalBook, "권" + " - " + "총 대여 권수");
	}

}
