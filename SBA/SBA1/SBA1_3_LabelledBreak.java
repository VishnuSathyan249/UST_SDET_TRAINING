package sample;

import java.util.Scanner;

public class SBA1_3_LabelledBreak {
	
	public static void main(String args[]) {
		
		int sum = 0,i =0,num,n;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the limit" );
		n = sc.nextInt();
		
		first:
		for(i=1;i<=1000;i++)
		{
			
			second:
				for(int j=0;j<100000;j++)
				{
					if(j>n)
						break first;
					else
						sum = sum +j;
				}
				
		}
		
		System.out.println("The sum of first " +n+ " natural numbers is "+sum);
		
	}

}

output
	Enter the limit
	10
	The sum of first 10 natural numbers is 55
