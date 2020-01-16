package testClasses;

public class TypeOfOperation {
	String str;
	int index1;
	int index2;
	int typeOfValue;

	
	//��������� � ����������� ��� ��������
	public int TOF(String str,int index1,int index2,int typeOfValue) {	//TOF - Type of calculator
		String[] calc = {"+","-","*","/" };
		int flagCalc = 0;
		int typeOfCalc = -1;
		int indexSign = 0;
		int indexSignErr = -1;
		String[] rome2 = {"IX","X","VIII","VII","VI","IV","III","II","I","V"}; //��� ����������� ���������� ������� ����
		String[] arab2 = {"9","10","8","7","6","4","3","2","1","5"};
		
		if (typeOfValue == 2) {
			 for (int i=0; i<rome2.length; i++) {
					str=str.replaceAll(rome2[i],arab2[i]);	//������� � ��������. ����, ���� ������� ����������� � ReadArab, �� ����� ���-������ ����������
				}
		}
		
		for (int i=0; i<calc.length; i++) {
			boolean isContain1 = str.contains(calc[i]);	
			if (isContain1 == true) {
				typeOfCalc = i;
				flagCalc = flagCalc + 1;		
				indexSign = str.indexOf(calc[i]);
			}
		}
		

		switch(typeOfCalc) { // ����� ���� ���������� ������ (f.e. 1++2)
			case 0:indexSignErr = str.indexOf("+",indexSign+1);
				break;
			case 1:indexSignErr = str.indexOf("-",indexSign+1);
				break;
			case 2:indexSignErr = str.indexOf("*",indexSign+1);
				break;
			case 3:indexSignErr = str.indexOf("/",indexSign+1);
				break;
				
		}
		 
	 
		if (flagCalc == 0) {
			System.out.println("You didn't enter a sign");
			System.exit(2);
		}
	 	
	 
		if (indexSignErr>-1) {  // �������� �� ������� ���� ���������� ������ (f.e. 1++2)
			System.out.println("Error! You entered 2 identical characters sign");
			System.exit(2);
		}
		
		if (flagCalc > 1) {
			System.out.println("Error! You entered too many sign"); //�������� �� ��������� ������ ������ 
			System.exit(2);
		}
	 
		if ((indexSign <= index1) | (indexSign > index2)) { //�������� �� �������������� ����� (f.e. *1 2 ��� 2 5/)
	 		System.out.println("The sign must be between the first slogan and the second");
			System.exit(2);
		}
		return typeOfCalc;
	} 
 
}
