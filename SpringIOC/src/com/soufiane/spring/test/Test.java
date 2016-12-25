package com.soufiane.spring.test;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.soufiane.spring.service.IService;
import com.soufiane.spring.service.Personne;

import junit.framework.TestCase;

public class Test extends TestCase{
	private ListableBeanFactory bf;
	
	public void setUp(){
		bf = new XmlBeanFactory(new ClassPathResource("config.xml"));
	}
	@org.junit.Test
	public void test() {
		IService service = (IService) bf.getBean("service");
		
		Object[] list = service.getAll().toArray();
		int i = 0;
		for(Object obj : list){
			Personne p = (Personne) obj;
			System.out.println("personne_" + i++ + p.toString());
		}
	}

}
