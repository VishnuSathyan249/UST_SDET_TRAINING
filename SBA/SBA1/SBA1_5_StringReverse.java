package sample;

import java.util.Scanner;

public class SBA1_5_StringReverse {
	
	
	public static void main(String args[]) {
	
		char a[] = new char[20];
		String str;
		
		
		System.out.println("Enter the string");
		Scanner sc = new Scanner(System.in);	
		str = sc.nextLine();
		a = str.toCharArray();
		
		StringBuilder str1 = new StringBuilder(str);
		
		System.out.println();
		System.out.println("String before reverse");
		System.out.println(str);
		

		
		System.out.println();
		System.out.println("String after reverse using inbuilt function");
		System.out.println(str1.reverse());
		
		System.out.println();
		System.out.println("String after reverse using char array");
		
		for (int i = str.length()-1; i>=0 ; i--) 
		{
				System.out.print(a[i]);
		}
}
}

output:

	Enter the string
	HELLO

	String before reverse
	HELLO

	String after reverse using inbuilt function
	OLLEH

	String after reverse using char array
	OLLEH
	
