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
	
		//한 화면에 보여줄 페이지의 수
		private int pageGRUOP = 5;	
		
		//한 화면에 보여줄 레코드의 수
		private int pageSIZE = 10;
		
		//전체레코드수를 저장할 변수
		private int totalRecord;
		
		//전체페이지수를 저장할 변수
		private int totalPage;
		
		//현재페이지를 저장할 변수
		private int pageNUM;
		
		public String getPageStr()
		{
			//전체페이지수가 11페이지이고, 한화면에 보여줄 페이지의 수는 5개씩 이고
			//현재페이지가 1,2,3,4,5페이지라면
			//보여줘야할 시작페이지 	: 1
			//마지막페이지	: 5
			
			//현재페이지가 6,7,8,9,10페이지라면
			//보여줘야할 시작페이지 	: 6
			//마지막페이지	: 10
			
			int startPage = ((pageNUM-1)/pageGRUOP)*pageGRUOP+1;
			int endPage = startPage+pageGRUOP-1;
			if(endPage >= totalPage)
				endPage = totalPage;
					
			String str = "";
			//[이전]에 대한 처리
			if(startPage>1)
			{
				str = str + "<a href='listNotice.do?pageNUM="+(startPage-1)+"'>[이전]</a>";
			}
			
			for(int i=startPage; i<=endPage; i++)
			{
				str  = str +  "<a href='listNotice.do?pageNUM="+i+"'>"+ i +"</a>&nbsp;&nbsp;";
			}
			
			//[다음]에 대한 처리
			if(endPage <totalPage)
			{
				str = str + "<a href='listNotice.do?pageNUM="+(endPage+1)+"'>[다음]</a>";
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

		//글 목록보기를 요청했을때 전체레코드수와 전체 페이지수를 계산한다.
		totalRecord = getTotalCount(searchField, keyword, m_id);		
		totalPage = (int)Math.ceil((double)totalRecord/pageSIZE);		
		
		//전체레코드수가 32개이고 한화면 10개씩 보여주고자 한다. 
		//이때 현재 페이지 번호가 1페이지라면
		//시작레코드: 1
		//마지막레코드: 10
		
		
		//이때 현재 페이지 번호가 2페이지라면
		//시작레코드: 11
		//마지막레코드: 20
		
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
			System.out.println("모두검색");
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


