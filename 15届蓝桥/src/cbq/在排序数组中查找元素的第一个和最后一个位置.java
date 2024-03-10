package cbq;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * @Calss 二分查找
 * @author 长白崎
 *
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();

		int data[] = new int[L];
		for (int i = 0; i < data.length; ++i) {
			data[i] = sc.nextInt();
		}

		int n = sc.nextInt();

		int p[] = searchRange(data, n);
		System.out.println(Arrays.toString(p));

	}

	public static int[] searchRange(int[] nums, int target) {
		if(nums.length==0)
			return new int[] {-1,-1};
		int l = binarySearch(nums, target, 0);
		int r = binarySearch(nums, target, 1);
		
		if (r<+1 || nums[l + 1] != nums[r])
			return new int[] { -1, -1 };
		return new int[] { l+1, r };
	}

	public static int binarySearch(int data[], int n, int model) {
		if (data.length == 0)
			return -1;
		int l = 0, r = data.length-1;

		while (l <= r) {
			int mid = (l + r) >> 1;
			if (model == 0) {
				if (data[mid] >= n)
					r = mid - 1;
				else
					l = mid + 1;
			} else {
				if (data[mid] > n)
					r = mid - 1;
				else
					l = mid + 1;
			}
		}
		return r;
	}
}
