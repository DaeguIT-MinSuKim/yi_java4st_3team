package project_library.member.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import project_library.member.dao.impl.MemberDaoImpl;
import project_library.member.dto.Member;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDaoTest {
	private MemberDao dao;

	@Before
	public void setUp() throws Exception {
		dao = MemberDaoImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void test04SelectMemberByAll() {
		System.out.printf("%s()%n", "test04SelectMemberByAll");
		List<Member> list = dao.selectMemberByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);

		System.out.println();

	}

	@Test
	public void test05SelectMemberByNo() {

	}

	@Test
	public void test01InsertMember() {
		System.out.printf("%s()%n", "test01InsertMember");
		Member newMember = new Member("M010", "김김김", "010-1111-1111", 0);
		int res = dao.insertMember(newMember);
		Assert.assertEquals(1, res);

		System.out.printf("%s%n%n", newMember);
	}

	@Test
	public void test02UpdateMember() {
		System.out.printf("%s()%n", "test02UpdateMember");
		Member updMember = new Member("M010", "자바자", "010-5555-5555", 0);
		int res = dao.updateMember(updMember);
		Assert.assertEquals(1, res);

		System.out.printf("%s%n%n", updMember);
	}

	@Test
	public void test03DeleteMember() {
		System.out.printf("%s()%n", "test03DeleteMember");
		Member delMember = new Member("M010");
		int res = dao.deleteMember(delMember);
		Assert.assertEquals(1, res);

		System.out.printf("%s%n%n", delMember);
	}

}
