package kits.learnvocab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.dao.TopicDao;
import kits.learnvocab.dto.TopicDto;

public class Main {
	public static void main(String[] args) {
//		TopicDto tpdto = new TopicDto();
//		
//		TopicDao tpdao = new TopicDao();
		
		//----find all----//
//		List<TopicDto> ls = new ArrayList();
//		ls = tpdao.findAll();		
//		for (int i =0; i < ls.size(); i++) {
//			System.out.println(ls.get(i).getId()+"\t"+ ls.get(i).getName());
//		}
		//----add----//
//		tpdto.setId(5);
//		tpdto.setName("222");
//		tpdao.add(tpdto);
	
		//----delete----//
		//tpdao.delete(tpdto);
		
		//tpdao.update(tpdto);
		
		Login lg = new Login();
		lg.Login();
		
		
	}
	
	
}

