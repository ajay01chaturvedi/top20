// Leet Code - 153. Find Minimum in Rotated Sorted Array
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
//Find the minimum element.
//You may assume no duplicate exists in the array.

package com.alg.top20.divideprune;

public class MinInRotatedSortedArray {

	public static int findMin1(int[] in) {
		int l = 0;
		int r = in.length - 1;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (in[m] > in[r])
				l = m + 1;
			else
				r = m;
		}
		return in[l];
	}
}
