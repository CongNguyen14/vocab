package kits.learnvocab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.dao.ConnectWordDao;
import kits.learnvocab.dao.LanguageDao;
import kits.learnvocab.dao.WordVnDao;
import kits.learnvocab.dto.ConnectWordDto;
import kits.learnvocab.dto.LanguageDto;
import kits.learnvocab.dto.WordvnDto;

public interface ChooseWord {
	 static void chooseWord(int a ) {
			Scanner sc = new Scanner(System.in);
			//ConnectWordDto ladto = new ConnectWordDto();
			
			ConnectWordDao cwdao = new ConnectWordDao();
			List<ConnectWordDto> ls = new ArrayList();
			
			ls = cwdao.findAll();		
			for (int i =0; i < ls.size(); i++) {
				
				if(a == ls.get(i).getTopic_id()) {
					
					System.out.println(ls.get(i).getName());
					Scanner sc1 = new Scanner(System.in);
					
					String input = sc.next();
					if(input.equals("t")) {	
						WordVnDao wvdao = new WordVnDao();
						List<WordvnDto> lsvn = new ArrayList();
							System.out.println( lsvn.get(i).getName());	
					
					
				}
				
			}
			}
			//int choose = sc.nextInt();
			//return choose;
			
		}
	 public static void main(String[] args) {
		 chooseWord(1);
	}

		
}
