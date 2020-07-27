package kits.learnvocab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.dao.LanguageDao;
import kits.learnvocab.dao.TopicDao;
import kits.learnvocab.dto.LanguageDto;
import kits.learnvocab.dto.TopicDto;

public interface ChooseTopic {
	 default int chooseTopic(int a) {
			Scanner sc = new Scanner(System.in);
			TopicDto tpdto = new TopicDto();
			TopicDao tpdao = new TopicDao();
			List<TopicDto> ls = new ArrayList();
			
			ls = tpdao.findAll();		
			for (int i =0; i < ls.size(); i++) {
				int j = i+1;
				System.out.println(  ls.get(i).getId()+"\t"+ ls.get(i).getName());
			}
			int choose = sc.nextInt();
			return choose;
			
		}
	 
}
