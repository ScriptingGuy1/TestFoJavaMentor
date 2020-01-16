package testClasses;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {
 
	public static void main(String[] args) {	//����!!!!! 1+ ����� ����� ����������� ��������!!!! ������ = 0. ���������!!!!
		
		int value1 = -1; 	//�������� 1�� ����������
		int value2 = -1; 	//�������� 2�� ����������
		int index1 = -1;	//������ ������ ����������
		int index2 = -1;	//������ ������ ����������
		int flagValue = 0;	//���������� ����������
		String[] romeSmall = {"i","ii","iii","iv","v","vi","vii","viii","ix","x"};  //��� ������ � ������ ���������
	
		Scanner scan = new Scanner(System.in);			
		System.out.println("Enter your degeneration");
		String str = scan.nextLine();	//���� ���������

		
		Pattern pattern1 =  Pattern.compile("[^XIVxiv0-9+\\-\\*/]"); //�������� ������ ��������.
		Matcher matcher1 = pattern1.matcher(str);
			if (matcher1.find()==true) {
				str = matcher1.replaceAll("");
				System.out.println("�� ����� ������ �������, ��� ��� ��� �������� �� �������");
			}

		for (int i=0; i<romeSmall.length; i++) { //������ � ����������
			boolean isRome = str.contains(romeSmall[i]);
			if (isRome == true) {
				str = str.toUpperCase();
				System.out.println("�� ����� ������� ����� � ������ ��������, �� �� ������ ������ ���� ��������� "+ str);
			}
		}
		RomanOrArab f =  new RomanOrArab();
		int typeOfValue = f.ROA(str);  //�������� ������� ����� ��� ��������
		if(typeOfValue == 1) {
			ReadArab ReadAr= new ReadArab();
			int[] readArabResults = ReadAr.RA(str, typeOfValue,value1, value2); // ���������� �������� ����
			value1 = readArabResults[0];
			value2 = readArabResults[1];
			index1 = readArabResults[2];
			index2 = readArabResults[3];
			flagValue = readArabResults[4];
			
		}
		if(typeOfValue == 2) {
			ReadRoman ReadRo= new ReadRoman();
			int[] readRomeResults = ReadRo.RR(str, typeOfValue,value1, value2); // ���������� �������� ����
			value1 = readRomeResults[0];
			value2 = readRomeResults[1];
			index1 = readRomeResults[2];
			index2 = readRomeResults[3];
			flagValue = readRomeResults[4];
		}
		if (index1>index2) {  //���������� ������������� ����������
			int swap = value1;
			value1 = value2;
			value2 = swap;
			swap = index1;
			index1 = index2;
			index2 = swap;
		}  
		if (value1==9) index2 = 20;
		value1++; // ������ ���������� � 0
		value2++;
		if (value1 == 0)  {		//��� ����� ��������� ���� (f.e. 10+10) ����������� ������ ���������� �������� ������
			value1 = value2; 
			index2 = index1+20;	//��� �������� �� ������ �������������� �����(+10 8)
		}
		if (flagValue == 0) {
			System.out.println("Error! You entered romans and arabs value.");
			System.exit(1);
		}
	 	 
		 
		TypeOfOperation operation = new TypeOfOperation();	//��������� � ����������� ��� ��������
		int typeOfCalc = operation.TOF(str,index1,index2,typeOfValue);
		ProcessCalculator Calc = new ProcessCalculator();
		Calc.Process(str, value1, value2, typeOfValue, typeOfCalc);
	}

}
