package testClasses;

public class RomanOrArab {
	String str;
	
	public int ROA(String str) {
		String[] rome = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
		String[] arab = {"10","9","8","7","6","5","4","3","2","1"}; 
		int boolRome = 0; 
		int boolArab = 0;
		int typeOfValue = 0;
		for (int i=0; i<rome.length; i++) {
			boolean isRome = str.contains(rome[i]);
			if (isRome == true) boolRome = 1;
			boolean isArab = str.contains(arab[i]);
			if (isArab == true) boolArab = 1;
			}
			if ((boolRome > 0) & (boolArab == 0)) typeOfValue = 2;
			if ((boolRome == 0) & (boolArab > 0)) typeOfValue = 1;
			if (((boolRome > 0) & (boolArab > 0)) & ((boolRome == 0) & (boolArab == 0)))  System.out.println("Error1");
			return typeOfValue;
	}
	
}
 