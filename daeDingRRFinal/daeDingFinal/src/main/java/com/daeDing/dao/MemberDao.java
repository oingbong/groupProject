package com.daeDing.dao;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.daeDing.vo.MemberVo;

@Repository
public class MemberDao {
	
	private static SqlSessionFactory factory;
	
	static{
		try {
			Reader reader = Resources.getResourceAsReader("com/daeDing/data/dbconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	// �α��� Ȯ��
	public MemberVo isMember(String m_id, String m_pwd){
		MemberVo m = null;
		HashMap map = new HashMap();
		map.put("m_id", m_id);
		map.put("m_pwd", m_pwd);
		
		SqlSession session = factory.openSession();
		m = session.selectOne("member.isMember", map);
		session.close();
		return m;
	}
	
	// ��� ȸ�� ���
	public List<MemberVo> list(){
		SqlSession session = factory.openSession();
		List<MemberVo> list = session.selectList("member.selectAll");
		session.close();
		return list;
	}
	
	// ȸ�� �� ����
	public MemberVo detail(String m_id){
		SqlSession session = factory.openSession();
		MemberVo m = session.selectOne("member.select", m_id);
		session.close();
		return m;
	}
	
	// ȸ�� ���� �߰�
	public int insert(MemberVo m){
		SqlSession session = factory.openSession();
		int re = session.insert("member.insert",m);
		session.commit();
		session.close();
		return re;
	}
	
	// ȸ�� ���� ����
	public int update(MemberVo m){
		SqlSession session = factory.openSession();
		int re = session.update("member.update", m);
		session.commit();
		session.close();
		return re;
	}
	
	// ȸ�� ���� ����
	public int delete(String m_id){
		SqlSession session = factory.openSession();
		int re = session.delete("member.delete", m_id);
		session.commit();
		session.close();
		return re;
	}
	
}
