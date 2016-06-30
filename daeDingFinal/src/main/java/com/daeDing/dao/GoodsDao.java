package com.daeDing.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.daeDing.vo.GoodsVo;

@Repository
public class GoodsDao {

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
	public List<GoodsVo> list(String type) {
		SqlSession session = factory.openSession();
		List<GoodsVo> list = null;
		if(type != null){
			list = session.selectList("goods.selectAll2", type);
		}
		if(type == null || type ==""){
			list = session.selectList("goods.selectAll");
		}
		session.close();
		return list;
	}

	// 물품등록
	public int insert(GoodsVo v) {
		SqlSession session = factory.openSession(true);
		int re = session.insert("goods.insertGoods", v);
		session.close();
		return re;
	}// end insertClass
	
	// 물품 디테일
	public GoodsVo detail(int g_no){
		SqlSession session = factory.openSession(true);
		GoodsVo vo = session.selectOne("goods.detailGoods", g_no);
		session.close();
		return vo;
	}
	
	// 수정하기
	public int update(GoodsVo g){
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("goods.updateGoods", g);
		session.close();
		return re;
	}
	
	// 삭제하기
	public int delete(int g_no) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.delete("goods.delete", g_no);
		session.close();
		return re;
	}
	
}// end class
