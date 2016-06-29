package com.daeDing.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.daeDing.vo.QuestionVo;

@Repository
public class QuestionDao {

	private static SqlSessionFactory factory;

	static {

		try {
			Reader reader = Resources.getResourceAsReader("com/daeDing/data/dbconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			System.out.println(e);
		} // end static

	}// end static

	// ���Ǹ��
	public List<QuestionVo> list() {

		SqlSession session = factory.openSession();

		List<QuestionVo> list = session.selectList("question.selectAll");

		session.close();

		return list;

	}// end listClass

	// ���� ���
	public int insert(QuestionVo v) {

		SqlSession session = factory.openSession(true);

		int re = session.insert("question.insertQuestion", v);

		session.close();

		return re;

	}// end insertClass

	// ���� �� ����
	public QuestionVo detail(int q_no) {
		SqlSession session = factory.openSession();
		QuestionVo q = session.selectOne("question.detail", q_no);
		session.close();
		return q;
	}

	// ���ǻ��� ó�� ����
	public int update_yesNo(int q_no) {
		SqlSession session = factory.openSession();
		int re = session.update("question.update_yesNo", q_no);
		session.commit();
		session.close();
		return re;
	}

}
