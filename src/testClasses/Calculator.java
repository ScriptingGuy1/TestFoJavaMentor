package testClasses;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {
 
	public static void main(String[] args) {	//ИЛЬЯ!!!!! 1+ любое число неправильно работает!!!! Индекс = 0. Разберись!!!!
		
		int value1 = -1; 	//Значение 1ой переменной
		int value2 = -1; 	//Значение 2ой переменной
		int index1 = -1;	//Индекс Первой переменной
		int index2 = -1;	//Индекс Второй переменной
		int flagValue = 0;	//Количество переменных
		String[] romeSmall = {"i","ii","iii","iv","v","vi","vii","viii","ix","x"};  //Для работы с нижним регистром
	
		Scanner scan = new Scanner(System.in);			
		System.out.println("Enter your degeneration");
		String str = scan.nextLine();	//ввод уравнения

		
		Pattern pattern1 =  Pattern.compile("[^XIVxiv0-9+\\-\\*/]"); //Удаление лишних символов.
		Matcher matcher1 = pattern1.matcher(str);
			if (matcher1.find()==true) {
				str = matcher1.replaceAll("");
				System.out.println("Вы ввели лишние символы, так что мне пришлось их удалить");
			}

		for (int i=0; i<romeSmall.length; i++) { //Работа с регистрами
			boolean isRome = str.contains(romeSmall[i]);
			if (isRome == true) {
				str = str.toUpperCase();
				System.out.println("Вы ввели римские цифры в нижнем регистре, но мы смогли понять ваше выражение "+ str);
			}
		}
		RomanOrArab f =  new RomanOrArab();
		int typeOfValue = f.ROA(str);  //Проверка Римские цифры или Арабские
		if(typeOfValue == 1) {
			ReadArab ReadAr= new ReadArab();
			int[] readArabResults = ReadAr.RA(str, typeOfValue,value1, value2); // Считывание Арабских цифр
			value1 = readArabResults[0];
			value2 = readArabResults[1];
			index1 = readArabResults[2];
			index2 = readArabResults[3];
			flagValue = readArabResults[4];
			
		}
		if(typeOfValue == 2) {
			ReadRoman ReadRo= new ReadRoman();
			int[] readRomeResults = ReadRo.RR(str, typeOfValue,value1, value2); // Считывание Арабских цифр
			value1 = readRomeResults[0];
			value2 = readRomeResults[1];
			index1 = readRomeResults[2];
			index2 = readRomeResults[3];
			flagValue = readRomeResults[4];
		}
		if (index1>index2) {  //Правильное рассположение переменных
			int swap = value1;
			value1 = value2;
			value2 = swap;
			swap = index1;
			index1 = index2;
			index2 = swap;
		}  
		if (value1==9) index2 = 20;
		value1++; // Массив начинается с 0
		value2++;
		if (value1 == 0)  {		//При вводе одинковых цифр (f.e. 10+10) присваевает второй переменной значение первой
			value1 = value2; 
			index2 = index1+20;	//Для проверки на ошибку местоположение знака(+10 8)
		}
		if (flagValue == 0) {
			System.out.println("Error! You entered romans and arabs value.");
			System.exit(1);
		}
	 	 
		 
		TypeOfOperation operation = new TypeOfOperation();	//Считываем и расспазнаем тип опреации
		int typeOfCalc = operation.TOF(str,index1,index2,typeOfValue);
		ProcessCalculator Calc = new ProcessCalculator();
		Calc.Process(str, value1, value2, typeOfValue, typeOfCalc);
	}

}
