package project_library.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import project_library.dao.impl.SearchBookManagementDaoImpl;
import project_library.dto.Rent;

public class SearchBookManagementDaoTest {

	@Test
	public void testSelectSearchBookManagementByAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectSearchBookManagementByNo() {
		fail("Not yet implemented");
	}
	

	@Test
	public void testInsertSearchBookManagement() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSearchBookManagement_book() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSearchBookManagement_member() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectSearchBookWhereByCode() {
		List<Rent> list = SearchBookManagementDaoImpl.getInstance().selectSearchBookWhere(true, "B001");
		System.out.println(list);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
	}

	@Test
	public void testSelectSearchBookWhereByName() {
	
		List<Rent> list = SearchBookManagementDaoImpl.getInstance().selectSearchBookWhere(false, "리눅스 시스템 구축");
		System.out.println(list);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
}
