package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.UserInfo;
import mapper.UserMapper;

public class TestUserMapper {

	private SqlSession session;

	@Before
	public void init() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		session = factory.openSession();
	}

	@Test
	public void findAll() throws IOException {
		UserMapper userdao = session.getMapper(UserMapper.class);
		List<UserInfo> list = userdao.findAll();
		for (UserInfo ui : list) {
			System.out.println(ui.getUsername());
		}
	}

	@Test
	public void findById() throws IOException {
		UserMapper userdao = session.getMapper(UserMapper.class);
		UserInfo user = userdao.findById("郭达");
		System.out.println(user.getUserId());
	}

	@Test
	public void newuser() throws IOException {
		UserMapper userdao = session.getMapper(UserMapper.class);
		UserInfo user = new UserInfo();
		user.setUsername("123");
		int temp = userdao.newuser(user);
		if(temp > 0){
			session.commit();
			System.out.println("seccess!");
		}else{
			session.rollback();
			System.out.println("failed!");
		}
	}
	
	@Test
	public void change() throws IOException {
		UserMapper userdao = session.getMapper(UserMapper.class);
		UserInfo user = new UserInfo();
		user.setUserId(6);
		user.setStatus(2);
		int temp = userdao.change(user);
		if(temp > 0){
			session.commit();
			System.out.println("seccess!");
		}else{
			session.rollback();
			System.out.println("failed!");
		}
	}
	
	@Test
	public void dele() throws IOException {
		UserMapper userdao = session.getMapper(UserMapper.class);
		int temp = userdao.dele("123");
		if(temp > 0){
			session.commit();
			System.out.println("seccess!");
		}else{
			session.rollback();
			System.out.println("failed!");
		}
	}
	
	
	
	
	
	@After
	public void close() {
		session.close();
	}

}
