package sample;

import java.util.Scanner;

public class SBA1_2_AddPositiveNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0,i =0,num;
		Scanner sc = new Scanner(System.in);
		
		for(i=0;i>=0;i++)
		{
			System.out.println("Enter positive number");
			num = sc.nextInt();
				
				if(num<0)
					break;
				else
					sum = sum +num;
		}
		
		System.out.println("The sum of " +i+ " positive numbers is "+sum);

	}

}

output
	Enter positive number
	1
	Enter positive number
	3
	Enter positive number
	4
	Enter positive number
	-1
	The sum of 3 positive numbers is 8
