package com.daeDing.dao;


import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.daeDing.vo.NoticeVo;

@Repository
public class NoticeDao {
	
		//�� ȭ�鿡 ������ �������� ��
		private int pageGRUOP = 5;	
		
		//�� ȭ�鿡 ������ ���ڵ��� ��
		private int pageSIZE = 10;
		
		//��ü���ڵ���� ������ ����
		private int totalRecord;
		
		//��ü���������� ������ ����
		private int totalPage;
		
		//������������ ������ ����
		private int pageNUM;
		
		public String getPageStr()
		{
			//��ü���������� 11�������̰�, ��ȭ�鿡 ������ �������� ���� 5���� �̰�
			//������������ 1,2,3,4,5���������
			//��������� ���������� 	: 1
			//������������	: 5
			
			//������������ 6,7,8,9,10���������
			//��������� ���������� 	: 6
			//������������	: 10
			
			int startPage = ((pageNUM-1)/pageGRUOP)*pageGRUOP+1;
			int endPage = startPage+pageGRUOP-1;
			if(endPage >= totalPage)
				endPage = totalPage;
					
			String str = "";
			//[����]�� ���� ó��
			if(startPage>1)
			{
				str = str + "<a href='listNotice.do?pageNUM="+(startPage-1)+"'>[����]</a>";
			}
			
			for(int i=startPage; i<=endPage; i++)
			{
				str  = str +  "<a href='listNotice.do?pageNUM="+i+"'>"+ i +"</a>&nbsp;&nbsp;";
			}
			
			//[����]�� ���� ó��
			if(endPage <totalPage)
			{
				str = str + "<a href='listNotice.do?pageNUM="+(endPage+1)+"'>[����]</a>";
			}
			
			return str;
		}
		
		
	
	private static SqlSessionFactory factory;	
	static{
		try{
			Reader reader = Resources.getResourceAsReader("com/daeDing/data/dbconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public int deleteNotice(int n_no, String n_pwd)
	{
		int re = -1;
		HashMap map = new HashMap();
		map.put("n_no", n_no);
		map.put("n_pwd", n_pwd);
		SqlSession session =factory.openSession(true);
		re = session.update("notice.delete",map);
		session.close();
		return re;
	}
	
	public int updateNotice(NoticeVo n)
	{
		int re = -1;
		SqlSession session =factory.openSession(true);
		re= session.update("notice.update", n);
		session.close();
		return re;
	}
	
	
	
	
	public int getTotalCount(String searchField, String keyword, String m_id)
	{
		HashMap map = new HashMap();
		map.put("searchField", searchField);
		map.put("keyword", keyword);
		map.put("m_id", m_id);
		int re = -1;
		SqlSession session = factory.openSession();
		re=session.selectOne("notice.totalCount", map);
		session.close();
		return re;
	}
	
	public int getTotalCount(String searchField, String keyword)
	{
		HashMap map = new HashMap();
		map.put("searchField", searchField);
		map.put("keyword", keyword);		
		int re = -1;
		SqlSession session = factory.openSession();
		re=session.selectOne("notice.totalCount", map);
		session.close();
		return re;
	}
	
	
	public int updateStep(int b_ref, int b_step)
	{
		int re =  -1;
		SqlSession session = factory.openSession(true);
		HashMap map = new HashMap();
		map.put("b_ref", b_ref);
		map.put("b_step", b_step);		
		re =session.update("notice.updateStep", map);		
		session.close();		
		return re;
	}	
		
	
	public int nextNo()
	{
		int re =  -1;
		SqlSession session = factory.openSession();
		re = session.selectOne("notice.nextNo");
		session.close();		
		return re;
	}
	
	
	public NoticeVo getNotice(int n_no, boolean hitAdd)
	{	
		NoticeVo n = null;
		SqlSession session = factory.openSession(true);
		if(hitAdd == true)
		{
			session.update("notice.updateHit", n_no);
		}
		n=session.selectOne("notice.selectNoticeByNo", n_no);
		session.close();
		return n;
	}
	
	public int insertNotice(NoticeVo n)
	{
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("notice.insert", n);
		//session.commit();
		session.close();
		return re;
	}
	
	public List<NoticeVo> listNotice(String m_id, int pageNUM, String searchField, String keyword, String sort)
	{
		this.pageNUM = pageNUM;

		//�� ��Ϻ��⸦ ��û������ ��ü���ڵ���� ��ü ���������� ����Ѵ�.
		totalRecord = getTotalCount(searchField, keyword, m_id);		
		totalPage = (int)Math.ceil((double)totalRecord/pageSIZE);		
		
		//��ü���ڵ���� 32���̰� ��ȭ�� 10���� �����ְ��� �Ѵ�. 
		//�̶� ���� ������ ��ȣ�� 1���������
		//���۷��ڵ�: 1
		//���������ڵ�: 10
		
		
		//�̶� ���� ������ ��ȣ�� 2���������
		//���۷��ڵ�: 11
		//���������ڵ�: 20
		
		int start = (pageNUM-1) * pageSIZE+1;
		int end = start+pageSIZE-1;
		
		if(end > totalRecord)
			end = totalRecord;	
		
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		if(m_id != null)
		{
			map.put("id", m_id);
		}
		else
		{
			System.out.println("��ΰ˻�");
			map.put("searchField", searchField);
			map.put("keyword", keyword);
			map.put("sort", sort);
		}
		
		
		List<NoticeVo> list = null;
		SqlSession session= factory.openSession();
		System.out.println("map:"+map);
		list= session.selectList("notice.selectAll", map);
		session.close();
		return list;
	}
}


