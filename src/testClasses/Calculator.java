package testClasses;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {
 
	public static void main(String[] args) {	
		
		int value1 = -1; 	//Çíà÷åíèå 1îé ïåðåìåííîé
		int value2 = -1; 	//Çíà÷åíèå 2îé ïåðåìåííîé
		int index1 = -1;	//Èíäåêñ Ïåðâîé ïåðåìåííîé
		int index2 = -1;	//Èíäåêñ Âòîðîé ïåðåìåííîé
		int flagValue = 0;	//Êîëè÷åñòâî ïåðåìåííûõ
		String[] romeSmall = {"i","ii","iii","iv","v","vi","vii","viii","ix","x"};  //Äëÿ ðàáîòû ñ íèæíèì ðåãèñòðîì
	
		Scanner scan = new Scanner(System.in);			
		System.out.println("Enter your degeneration");
		String str = scan.nextLine();	//ââîä óðàâíåíèÿ

		
		Pattern pattern1 =  Pattern.compile("[^XIVxiv0-9+\\-\\*/]"); //Óäàëåíèå ëèøíèõ ñèìâîëîâ.
		Matcher matcher1 = pattern1.matcher(str);
			if (matcher1.find()==true) {
				str = matcher1.replaceAll("");
				System.out.println("Âû ââåëè ëèøíèå ñèìâîëû, òàê ÷òî ìíå ïðèøëîñü èõ óäàëèòü");
			}

		for (int i=0; i<romeSmall.length; i++) { //Ðàáîòà ñ ðåãèñòðàìè
			boolean isRome = str.contains(romeSmall[i]);
			if (isRome == true) {
				str = str.toUpperCase();
				System.out.println("Âû ââåëè ðèìñêèå öèôðû â íèæíåì ðåãèñòðå, íî ìû ñìîãëè ïîíÿòü âàøå âûðàæåíèå "+ str);
			}
		}
		RomanOrArab f =  new RomanOrArab();
		int typeOfValue = f.ROA(str);  //Ïðîâåðêà Ðèìñêèå öèôðû èëè Àðàáñêèå
		if(typeOfValue == 1) {
			ReadArab ReadAr= new ReadArab();
			int[] readArabResults = ReadAr.RA(str, typeOfValue,value1, value2); // Ñ÷èòûâàíèå Àðàáñêèõ öèôð
			value1 = readArabResults[0];
			value2 = readArabResults[1];
			index1 = readArabResults[2];
			index2 = readArabResults[3];
			flagValue = readArabResults[4];
			
		}
		if(typeOfValue == 2) {
			ReadRoman ReadRo= new ReadRoman();
			int[] readRomeResults = ReadRo.RR(str, typeOfValue,value1, value2); // Ñ÷èòûâàíèå Àðàáñêèõ öèôð
			value1 = readRomeResults[0];
			value2 = readRomeResults[1];
			index1 = readRomeResults[2];
			index2 = readRomeResults[3];
			flagValue = readRomeResults[4];
		}
		if (index1>index2) {  //Ïðàâèëüíîå ðàññïîëîæåíèå ïåðåìåííûõ
			int swap = value1;
			value1 = value2;
			value2 = swap;
			swap = index1;
			index1 = index2;
			index2 = swap;
		}  
		if (value1==9) index2 = 20;
		value1++; // Ìàññèâ íà÷èíàåòñÿ ñ 0
		value2++;
		if (value1 == 0)  {		//Ïðè ââîäå îäèíêîâûõ öèôð (f.e. 10+10) ïðèñâàåâàåò âòîðîé ïåðåìåííîé çíà÷åíèå ïåðâîé
			value1 = value2; 
			index2 = index1+20;	//Äëÿ ïðîâåðêè íà îøèáêó ìåñòîïîëîæåíèå çíàêà(+10 8)
		}
		if (flagValue == 0) {
			System.out.println("Error! You entered romans and arabs value.");
			System.exit(1);
		}
	 	 
		 
		TypeOfOperation operation = new TypeOfOperation();	//Ñ÷èòûâàåì è ðàññïàçíàåì òèï îïðåàöèè
		int typeOfCalc = operation.TOF(str,index1,index2,typeOfValue);
		ProcessCalculator Calc = new ProcessCalculator();
		Calc.Process(str, value1, value2, typeOfValue, typeOfCalc);
	}

}
