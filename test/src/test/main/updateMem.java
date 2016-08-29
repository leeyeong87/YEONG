package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.vo.MembersVo;

public class updateMem {
	public static void main(String[] arge){
	String res = "config.xml";
	SqlSession session = null; 
	try {
		InputStream is;
		is = Resources.getResourceAsStream(res);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		session = factory.openSession();
		MembersVo mem = new MembersVo();//새로운 객체생성
		mem.setId("java");//객체에 ID저장
		MembersVo mv = session.selectOne("member.getid", mem);//저장된 아이디로 아이디 검색
		mv.setPwd("avaj");//검색된 아이디 정보에 패스워드값 변경
		if(mv.getId()!=null){//아이디를 받아왔는지 확인
		int x = session.update("member.upMem", mv);//업데이트 메서드 실행
		if(x==0){
			System.out.println("update 실패!");
		}else{
			System.out.println("성공");
		}
		}
		session.commit();
	}catch(IOException e){
		//TODO Auto
	}finally{
		session.close();
	}
	}
	
}