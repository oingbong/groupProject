package com.daeDing.dao;

import java.io.Reader;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.daeDing.vo.CartVo;


@Repository
public class CartDao {

	private static SqlSessionFactory factory;

	static {

		try {
			Reader reader = Resources.getResourceAsReader("com/daeDing/data/dbconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			System.out.println(e);
		} // end static

	}// end static
	

	// 물품목록
	public List<CartVo> list(String m_id) {

		SqlSession session = factory.openSession();

		List<CartVo> list = session.selectList("cart.selectAll", m_id);

		session.close();

		return list;

	}// end listClass
	

	// 물품등록
	public int insert(CartVo c) {

		SqlSession session = factory.openSession(true);

		int re = session.insert("cart.insertCart", c);

		session.close();

		return re;

	}// end insertClass
	

	
	public int delete(int c_no) {

		int re = -1;
		SqlSession session = factory.openSession(true);
		
		re = session.delete("cart.delete", c_no);
		session.close();

		return re;

	}
	
	public int deleteAll() {

		int re = -1;
		SqlSession session = factory.openSession(true);
		
		re = session.delete("cart.deleteAll");
		session.close();

		return re;

	}
	

}// end class