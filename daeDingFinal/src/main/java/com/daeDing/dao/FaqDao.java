package com.daeDing.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.daeDing.vo.FaqVo;

@Repository
public class FaqDao {

	private static SqlSessionFactory factory;

	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/daeDing/data/dbconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 자주하는 질문 목록
	public List<FaqVo> list() {
		SqlSession session = factory.openSession();
		List<FaqVo> list = session.selectList("faq.selectAll");
		session.close();
		return list;

	}
	
	// 자주하는 질문 등록
	public int insert(FaqVo f){
		SqlSession session = factory.openSession();
		int re = session.insert("faq.insert", f);
		session.commit();
		session.close();
		return re;
	}

	// 자주하는 질문 상세정보
	public FaqVo detail(int f_no){
		SqlSession session = factory.openSession();
		FaqVo f = session.selectOne("faq.select", f_no);
		session.close();
		return f;
	}
	
	// 자주하는 질문 수정
	public int update(FaqVo f){
		SqlSession session = factory.openSession();
		int re = session.update("faq.update", f);
		session.commit();
		session.close();
		return re;
	}
	
	// 자주하는 질문 삭제
	public int delete(int f_no){
		SqlSession session = factory.openSession();
		int re = session.delete("faq.delete",f_no);
		session.commit();
		session.close();
		return re;
	}
	
}
