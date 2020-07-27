package kits.learnvocab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.dao.LanguageDao;
import kits.learnvocab.dao.TopicDao;
import kits.learnvocab.dto.LanguageDto;
import kits.learnvocab.dto.TopicDto;

public interface ChooseLanguage {
	 default int chooseLanguage() {
		Scanner sc = new Scanner(System.in);
		LanguageDto ladto = new LanguageDto();
		LanguageDao ladao = new LanguageDao();
		List<LanguageDto> ls = new ArrayList();
		
		ls = ladao.findAll();		
		for (int i =1; i < ls.size(); i++) {
			
			System.out.print("choose " + ls.get(i).getLang()+ " press " + i + "\t");
		}
		int choose = sc.nextInt();
		return choose;
		
	}
	
	
}
