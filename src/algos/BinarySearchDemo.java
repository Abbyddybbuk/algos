package algos;

import java.util.Arrays;

public class BinarySearchDemo {

	public static void main(String[] args) {
		int[] val = {6,8,2,5,1,4,9,0,10,11,67,32,21,20,15,99,107,91};
		int key = 91;
		Arrays.sort(val);
        for(int i=0;i<val.length;i++) {
        	System.out.print(" " + val[i] + " ");
        }   
        System.out.println();
        System.out.println("**************");
        
        String output = execBinarySearch(val, key, 0, val.length - 1);
        
        System.out.println(output);
	}
	
	public static String execBinarySearch(int[] numArray,int key,int low,int high) {
		if (low > high) {
			return "Number not found";
		}
		
		int mid = (low + high)/2;
		
		if (key==numArray[mid]) {
			return "number found at index " + mid;
		} else if (key < numArray[mid]) {
			return execBinarySearch(numArray, key, low, mid-1);
		} else {
			return execBinarySearch(numArray, key, mid+1, high);
		}
		
	}	

}
