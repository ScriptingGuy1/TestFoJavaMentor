package testClasses;

public class ProcessCalculator {
	String str;
	int value1;
	int value2;
	int typeOfValue;
	int typeOfCalc;
	 
	//Тут используется огромный костыль. Мне, честно, стыдно, что я так реализовал метод калькулирования римских цифр 
	public void Process(String str, int value1, int value2, int typeOfValue, int typeOfCalc) {
		String[] rome2 = {"IX","X","VIII","VII","VI","IV","III","II","I","V"}; //Для корректного считывания Римских цифр
		String[] arab2 = {"9","10","8","7","6","4","3","2","1","5"};
		String[] arab = {"10","9","8","7","6","5","4","3","2","1"}; 
		String[] rome = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
		int results = 0;
		String resultsStr = null;
		  
		switch(typeOfCalc) {
		case 0: results = value1+value2;
		if (typeOfValue == 2) {
			resultsStr = String.valueOf(results);
			if (results >10 ) {
				results -= 10;
				resultsStr = String.valueOf(results);
				for (int i=0; i<rome.length; i++) {
					resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
				}
				System.out.println("X"+resultsStr);
				break;
			}
			for (int i=0; i<rome.length; i++) {
				resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
			}
			System.out.println(resultsStr);
			break;
		}	
			System.out.println(value1 + " + " + value2 + " = " + results);
			break;
		case 1: results = value1 - value2;
			if (typeOfValue == 2) {
				resultsStr = String.valueOf(results);
				for (int i=0; i<rome.length; i++) {
					resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
				}	
				System.out.println(resultsStr);
				break;
			}
			System.out.println(value1 + " - " + value2 + " = " + results);
			break;
		case 2: results = value1*value2;
			if (typeOfValue == 2) {
				if ((results>10)&(results<21)){		//Для чисел от 11 до 21
					results -= 10;
					for (int i=0; i<rome.length; i++) {
						resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
					}
					System.out.println("X"+resultsStr);
					break;
				}
				if ((results>20)&(results<31)){		//Для чисел от 21 до 31
					results -= 20;
					for (int i=0; i<rome.length; i++) {
						resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
					}
					System.out.println("XX"+resultsStr);
					break;
				}
				if ((results>30)&(results<40)){		//Для чисел от 31 до 40
					results -= 30;
					for (int i=0; i<rome.length; i++) {
						resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
					}
					System.out.println("XXX"+resultsStr);
					break;
				}
				if (results==40){		//Для 40
								
					System.out.println("XL");
					break;
				}
				if ((results>40)&(results<50)){		//Для чисел от 41 до 49
					results -= 40;
					for (int i=0; i<rome.length; i++) {
						resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
					}
					System.out.println("XL"+resultsStr);
					break;
				}
				if (results==50){		//Для 50
					
					System.out.println("L");
					break;
				}
				if ((results>50)&(results<61)){		//Для чисел от 51 до 60
					results -= 50;
					for (int i=0; i<rome.length; i++) {
						resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
					}
					System.out.println("L"+resultsStr);
					break;
				}
				if ((results>60)&(results<71)){		//Для чисел от 61 до 70
					results -= 60;
					for (int i=0; i<rome.length; i++) {
						resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
					}
					System.out.println("LX"+resultsStr);
					break;
				}
				if ((results>70)&(results<81)){		//Для чисел от 71 до 80
					results -= 70;
					for (int i=0; i<rome.length; i++) {
						resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
					}
					System.out.println("LXX"+resultsStr);
					break;
				}
				if ((results>80)&(results<90)){		//Для чисел от 81 до 89
					results -= 80;
					for (int i=0; i<rome.length; i++) {
						resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
					}
					System.out.println("LXXX"+resultsStr);
					break;
				}
				if (results==90){		//Для 90
					
					System.out.println("XC");
					break;
				}
				if ((results>90)&(results<100)){		//Для чисел от 91 до 99
					results -= 80;
					for (int i=0; i<rome.length; i++) {
						resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
					}
					System.out.println("XC"+resultsStr);
					break;
				}
				if (results==100){		//Для 100
					
					System.out.println("C");
					break;
				}
				
			}
			System.out.println(value1 + " * " + value2 + " = " + results);
			break;
		case 3: if (value1%value2 == 0) {
					results = value1/value2;
					if (typeOfValue == 2) {
						resultsStr = String.valueOf(results);
						for (int i=0; i<rome.length; i++) {
							resultsStr=resultsStr.replaceAll(arab2[i],rome2[i]);
						}	
						System.out.println(resultsStr);
				break;
			} 
			System.out.println(value1 + " / " + value2 + " = " + results);
			break;
			}
		else {
			System.out.println("Деление с остатком, что нарушает 4ый пункт задания.");
			break;
		}
		 
		default: System.out.println("Error №3");
			break;
	}
	}
}
