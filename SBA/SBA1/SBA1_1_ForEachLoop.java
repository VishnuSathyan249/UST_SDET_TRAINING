package sample;

public class SBA1_1_ForEachLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{10,2,3,45,67,11,22,67,89,23,};
		System.out.println("The array of elements are : ");
		
		for(int num : array)
			System.out.print(" " +num );
	}
}

output
The array of elements are : 
 10 2 3 45 67 11 22 67 89 23
