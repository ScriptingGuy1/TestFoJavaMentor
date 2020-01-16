package testClasses;

public class ReadArab {
	int typeOfValue;
	String str;


 	
	// Считывание Арабских цифр
	public  int[] RA(String str, int typeOfValue,int value1, int value2) {
		int index1=-1;  
		int index2=-1;
		int flagValue = 0;
		boolean flagErr = false; 
		String[] arab = {"10","9","8","7","6","5","4","3","2","1"};
		String reservStr = str; //Резервная копия строки
		 if (typeOfValue == 1) {
			for (int i=0; i<arab.length; i++) {
				boolean isContain1 = str.contains(arab[i]);
				if (isContain1 == true) { //Если мы нашли число из массива arab, то записываем его значение и индекс
					if (flagValue == 0) {
						value1 = 9 - i;
						flagValue = 1;
						index1 = str.indexOf(arab[i]);
						str = str.replaceAll(arab[i], "."); // Для работы с выражениями 10+10 9+9 и тд
						flagErr = true;			//Для защиты от ситуаций с вводом только одного слогаемого
					}	
					else 
						if(flagValue == 1) {
							value2 = 9 - i;
							flagValue = 2;
							index2 = str.indexOf(arab[i]);
						}
						else {
							if (flagValue == 2) {
							System.out.println("Error! You entered more then 2 variables or incorrect variables");
							System.exit(1);
							}
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
		 int[] readArabResults = {value1, value2, index1, index2, flagValue};
		return readArabResults;
	}
}
