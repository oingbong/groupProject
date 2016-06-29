package com.daeDing.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.daeDing.vo.OrderInfoVo;

@Repository
public class OrderInfoDao {
	
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
	public List<OrderInfoVo> list(String m_id) {

		SqlSession session = factory.openSession();

		List<OrderInfoVo> list = session.selectList("orderInfo.selectAll", m_id);

		session.close();

		return list;

	}// end listClass

	// 물품등록
	public int insert(OrderInfoVo v) {

		SqlSession session = factory.openSession(true);
		int re = session.insert("orderInfo.insertOrderInfo", v);
		session.close();

		return re;

	}// end insertClass

	
	
}
