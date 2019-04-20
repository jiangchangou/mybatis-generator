package cn.ligaixian.test;

import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.ligaixian.mapper.EmployeeMapper;
import cn.ligaixian.pojo.Employee;
import cn.ligaixian.pojo.EmployeeExample;

public class EmployeeTest {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private EmployeeMapper empMapper;
	private EmployeeExample example = new EmployeeExample();

	@Before
	public void init() throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

		// 开启会话 sqlSession
		sqlSession = sqlSessionFactory.openSession();
		empMapper = sqlSession.getMapper(EmployeeMapper.class);
	}

	@After
	public void after() {
		// 提交
		sqlSession.commit();
		// 关闭
		sqlSession.close();
	}

	@Test
	public void testCountByExample() {
		example.createCriteria().andIdEqualTo(3000);
		long countByExample = empMapper.countByExample(example);

		System.out.println(countByExample);
	}

	@Test
	public void testDeleteByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExample() {
		example.setOrderByClause("id desc limit 0,2");

		List<Employee> list = empMapper.selectByExample(example);

		// 迭代器 遍历
		Iterator<Employee> iterator = list.iterator();
		while (iterator.hasNext()) {
			Employee emp = iterator.next();
			System.out.println(emp);
			System.out.println("id：" + emp.getId());
			System.out.println("名称：" + emp.getLastname() + "\n");
		}

	}

	@Test
	public void testSelectByPrimaryKey() {

	}

	@Test
	public void testUpdateByExampleSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

}
