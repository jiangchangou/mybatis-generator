package cn.ligaixian.test;

import static org.junit.Assert.fail;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.ligaixian.mapper.DepartmentMapper;
import cn.ligaixian.pojo.Department;
import cn.ligaixian.pojo.DepartmentExample;

public class DepartmentTest {

	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;
	// 会话
	private SqlSession sqlSession;
	// mapper接口类 操作方法
	private DepartmentMapper departmentMapper;
	// 操作数据需要的条件组合类
	private DepartmentExample example = new DepartmentExample();

	@Before
	public void init() throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

		// 开启会话 sqlSession
		sqlSession = sqlSessionFactory.openSession();
		departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
	}

	@After
	public void after() {
		// 提交
		sqlSession.commit();
		// 关闭
		sqlSession.close();
	}

	/**
	 * 查询个数
	 */
	@Test
	public void testCountByExample() {

		long countByExample = departmentMapper.countByExample(example);
		System.out.println("一共查询条数是：" + countByExample);

	}

	@Test
	public void testDeleteByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	/**
	 * 添加
	 */
	@Test
	public void testInsert() {
		for (int i = 0; i < 1000; i++) {
			// 插入数据
			departmentMapper.insert(new Department("融资部" + (i + 1)));
		}
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
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
