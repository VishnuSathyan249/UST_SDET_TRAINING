package sample;

import java.util.Scanner;
import java.lang.*;

public class SBA1_6_StringFunctions {
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first string");
		String str1 = sc.nextLine();
		System.out.println("Enter the second string");
		String str2 = sc.nextLine();
		System.out.println("Enter the third string");
		String str3 = sc.nextLine();
		
		System.out.println();
		System.out.println("First String = " +str1);
		System.out.println("Second String = " +str2);
		System.out.println("Third String = " +str3);
		
		Boolean b = str1.contains(str2);
		
		System.out.println();
		System.out.println("Contains() function");
		
		if (b==true) 
			
				System.out.println("First string contains second string");
			
	    else 
			    System.out.println("First string doesnot contains second string");
							
		
		System.out.println();
		System.out.println("length() function");
		System.out.println("Length of first string : "+str1.length());
		System.out.println("Length of second string : "+str2.length());
		System.out.println("Length of second string : "+str3.length());
		
		System.out.println();
		System.out.println("replace() function");
		System.out.println("After replacing string 1 with string 2 : "+str1.replace(str1, str2));
		
		System.out.println();
		System.out.println("concat() function");
		System.out.println("After concatenate string 1 with string 2 : "+str1.concat(" ").concat(str2));
		
		System.out.println();
		System.out.println("equals() function");
		Boolean b1 = str2.equals(str3);
		
		if (b1==true) 
			
			System.out.println("Second string equals to third string");

		else 
			
			System.out.println("Second string is not equal to third string");
	}

}
