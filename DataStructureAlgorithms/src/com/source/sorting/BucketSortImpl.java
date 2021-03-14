package com.source.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSortImpl {
	static int arr[] = { 40, 10, 30, 80, 70, 20, 60, 50, 100 };
	static int size = 9;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bucketSort(arr);

	}

	public static void bucketSort(int data[]) {
		// find number of Buckets
		int numberofBucket = (int) Math.ceil(Math.sqrt(size));
		System.out.println("numberofBucket: " + numberofBucket);
		// initialize min and max value
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		// set max and min value
		for (int i = 0; i < size; i++) {
			if (data[i] < min) {
				min = data[i];
			}
			if (data[i] > max) {
				max = data[i];
			}
		}

		System.out.println("max: " + max + " min "+min);
		
		// create blanck bucket
		ArrayList<Integer>[] bucket = new ArrayList[numberofBucket];

		// Initialize buckets
		for (int i = 0; i < numberofBucket; i++) {
			bucket[i] = new ArrayList<Integer>();
		}

		// traverse array and put values in buckets
		for (int value : data) {
			int bucketIndex = (int) Math.ceil((value * numberofBucket) / max);
			System.out.println("bucketIndex: " + bucketIndex + " value "+value);
			if(bucketIndex==0)bucketIndex=bucketIndex+1;
			bucket[bucketIndex-1].add(value);
		}

		// print buckets value
		for (int i = 0; i < numberofBucket; i++) {
			System.out.println("Bucket : " + i);
			for (int val : bucket[i]) {
				System.out.print(val + " ");
			}
		}

		// Sort Bucket Values
		for (ArrayList<Integer> buckets : bucket) {
			Collections.sort(buckets);
		}

		// print buckets value
		for (int i = 0; i < numberofBucket; i++) {
			System.out.println("Bucket : " + i);
			for (int val : bucket[i]) {
				System.out.print(val + " ");
			}
		}
		
		//concatenate buckets
		int index =0;
		for (ArrayList<Integer> buckets : bucket) {
			for(int val : buckets) {
				data[index]= val;
				index++;
			}
		}
		
		// print sorted Array
		System.out.println();
		for(int i=0;i<size;i++) {
			System.out.print(data[i]+ " ");
		}


	}

}
