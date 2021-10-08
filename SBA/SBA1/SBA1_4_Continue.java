package sample;

import java.util.Scanner;

public class SBA1_4_Continue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0,i =0,num,n;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the limit" );
		n = sc.nextInt();
		
			for(i=1;i<=(2*n);i++)
				{
					if(i%2 == 0)
						sum = sum +i;
					else
						continue;
				}	
		
		System.out.println("The sum of first " +n+ " even numbers are "+sum);
		
	}

	

}

output
	Enter the limit
	10
	The sum of first 10 even numbers are 110
