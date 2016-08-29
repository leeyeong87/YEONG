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
		MembersVo mem = new MembersVo();//���ο� ��ü����
		mem.setId("java");//��ü�� ID����
		MembersVo mv = session.selectOne("member.getid", mem);//����� ���̵�� ���̵� �˻�
		mv.setPwd("avaj");//�˻��� ���̵� ������ �н����尪 ����
		if(mv.getId()!=null){//���̵� �޾ƿԴ��� Ȯ��
		int x = session.update("member.upMem", mv);//������Ʈ �޼��� ����
		if(x==0){
			System.out.println("update ����!");
		}else{
			System.out.println("����");
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