package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.vo.MembersVo;

public class InsertMem {
	public static void main(String[] arge){
	String res = "config.xml";
	SqlSession session = null; 
	try {
		InputStream is;
		is = Resources.getResourceAsStream(res);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		session = factory.openSession();
	
		MembersVo mv = new MembersVo("java0","java01","java02@java.com","010...",null);
		
		int x = session.insert("member.addMem", mv);
		if(x==0){
			System.out.println("insert 실패!");
		}else{
			System.out.println("성공");
		}
		session.commit();
	}catch(IOException e){
		//TODO Auto
	}finally{
		session.close();
	}
	}
	
}