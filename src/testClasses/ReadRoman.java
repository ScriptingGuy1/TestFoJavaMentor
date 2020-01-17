package testClasses;

public class ReadRoman {
	int typeOfValue;
	String str;
	
	
	//Считывание Римских цифр 
	public  int[] RR(String str, int typeOfValue,int value1, int value2) {
		int index1=-1;
		int index2=-1;
		int flagValue = 0;
		boolean flagErr = false;
		String[] rome2 = {"IX","X","VIII","VII","VI","IV","III","II","I","V"}; //Для корректного считывания Римских цифр
		String[] arab2 = {"9","10","8","7","6","4","3","2","1","5"};
		String[] arab = {"10","9","8","7","6","5","4","3","2","1"}; 
		String reservStr = str;
		if (typeOfValue == 2) {
			 for (int i=0; i<rome2.length; i++) {
					str=str.replaceAll(rome2[i],arab2[i]);	//Перевод в Арабские. ИЛЬЯ, этот участок дублируется с ReadArab, их можно как-нибудь обьяденить
				}
				for (int i=0; i<arab.length; i++) {
					boolean isContain1 = str.contains(arab[i]);
					if (isContain1 == true) {
						if (flagValue == 0) {
							value1 = 9 - i;
							flagValue = 1;
							index1 = str.indexOf(arab[i]);
							str = str.replaceAll(arab[i], ".");
							if ((index1+1)!=str.length()) { //Для проверки на значение больше 10
								char ch = str.charAt(index1+1);
								if ((ch!='+')&(ch!='-')&(ch!='*')&(ch!='/')) {
									System.out.println("Error! You entered incorrect variables");
									System.exit(1);
								}
								else ch = str.charAt(str.length()-2);
								if ((ch!='+')&(ch!='-')&(ch!='*')&(ch!='/')) {
									System.out.println("Error! incorrect variables");
									System.exit(1);
								}
							}
							flagErr = true;			//Для защиты от ситуаций с вводом только одного слогаемого
						}	
						else 
							if(flagValue == 1) {
								value2 = 9 - i;
								flagValue = 2;
								index2 = str.indexOf(arab[i]);// + arab[i].length()-1;
								if ((index1+1)!=str.length()) { //Для проверки на значение больше 10
									char ch = str.charAt(index1+1);
									if ((ch!='+')&(ch!='-')&(ch!='*')&(ch!='/')) {
										System.out.println("Error! You entered incorrect variables");
										System.exit(1);
									}
								}
							} 
							else
								if (flagValue == 2) {
									System.out.println("Error! You entered more then 2 variables or incorrect variables");
									System.exit(1);
							}	
					}
				}
		} 
		
		int indexErr = index1;
		if (flagErr==true) { //Проверка на 10+10
			 indexErr = str.indexOf(".",index1+1);
			 if(indexErr == -1) flagErr = false;
			
		 }

		if (((flagErr == false)&(value2 == -1))|((flagValue == 1)&((flagErr == false)))) { //Защита от ввода только одного слогаемого f.e. 10+  +4 итд
			System.out.println("Error! You entered only incorect the equation, or does not correspond to a task");
			System.exit(1);	
		}

		 str = reservStr;
			 int[] readRomeResults = {value1, value2, index1, index2,flagValue};
			return readRomeResults;
		}	 
}
 
