package kits.learnvocab;

public class Admin implements ChooseLanguage, ChooseTopic, ChooseWord{

		Admin(){
			int b = 0;
			b  = chooseLanguage();
			int c = 0;
			c = chooseTopic(b);
			
			
			
		}
		
		private void chooseContinue() {
			
		}
		
	
}
