package algos;

import java.util.Arrays;

public class FindNextBigNum {
// 1. Start from the right
// 2. Look for a position where number is less than the previous one
// 3. Now for this number; find the next bigger number
// 4. Exchange their positions
	public static void main(String[] args) {
		String num = "534976";
		Integer i = 0;
		Integer[] numArray = new Integer[num.length()];
		Integer[] numArray1 = new Integer[num.length()];
		boolean numFound=false;
		while (i < num.length()) {
			numArray[i] = Character.getNumericValue(num.charAt(i));
			i++;
		}

		for (i = num.length() - 1; i >= 0; i--) {
			if (i == 0) {
				numFound = false;
				break;
			}

			if (numArray[i] > numArray[i - 1]) {
				Integer key = numArray[i - 1];
				numArray1 = findNextBigNumber(key, i - 1, numArray, i, num.length());
				numFound = true;
				break;
			}
		}

		if (numFound) {
			System.out.print("Next Big Number is: ");
			for (int j = 0; j <= numArray1.length - 1; j++) {
				System.out.print(numArray1[j]);
			}
		} else {
            System.out.println("No Number found");
		}

	}

	public static Integer[] findNextBigNumber(Integer key, int keyPos, Integer[] numArray, Integer low, Integer high) {
		Integer[] tempArray = new Integer[numArray.length];
		tempArray = numArray;
		Arrays.sort(tempArray, low, high);
		for (int k = low; k < high; k++) {
			if (tempArray[k] > key) {
				tempArray = swap(tempArray, keyPos, k);
				return tempArray;
			}
		}
		return null;
	}

	public static Integer[] swap(Integer[] numArray, Integer keyPos, Integer targetPos) {
		Integer target = numArray[targetPos];
		numArray[targetPos] = numArray[keyPos];
		numArray[keyPos] = target;
		return numArray;
	}

}
