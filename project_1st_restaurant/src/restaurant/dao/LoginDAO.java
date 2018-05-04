package restaurant.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import restaurant.vo.Login;
import restaurant.vo.Restaurant;

public class LoginDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public List<Login> check(Login l) {
		List<Login> result = null;
		SqlSession session = null;
		try {
			session = factory.openSession(); // factory���� session�� ����޶�� ��û�Ѵ�. (cmd�� �α��ΰ� ���)
			RestaurantMapper mapper = session.getMapper(RestaurantMapper.class);
			result = mapper.check(l);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}
}
