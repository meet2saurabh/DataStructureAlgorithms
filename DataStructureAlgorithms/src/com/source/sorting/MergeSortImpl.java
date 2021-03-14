package com.source.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MergeSortImpl {

	static int data[];
	static int size = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		data = new int[size];
		input();
		print();
		mergeSort(data, data.length);
		print();

	}

	public static void mergeSort(int arr[], int len) {
		   
		if (len < 2)
			return;

		int mid = len / 2;

		int left_arr[] = new int[mid];
		int right_arr[] = new int[len - mid];

		int k = 0;
		for (int i = 0; i < len; i++) {
			if (i < mid) {
				left_arr[i] = arr[i];
			} else {
				right_arr[k] = arr[i];
				k++;
			}
		}

		mergeSort(left_arr, mid);
		mergeSort(right_arr, len - mid);

		merge(left_arr, right_arr, arr, mid, len - mid);
	}

	public static void merge(int left_arr[], int right_arr[], int arr[], int left_size, int right_size) {
       
		int i = 0, l = 0, r = 0;

		while (l < left_size && r < right_size) {
			if (left_arr[l] < right_arr[r])
				arr[i++] = left_arr[l++];
			else
				arr[i++] = right_arr[r++];
		}

		while (l < left_size)
			arr[i++] = left_arr[l++];

		while (r < right_size)
			arr[i++] = right_arr[r++];

	}

	public static void print() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public static void input() {
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			int randomInteger = random.nextInt(100);
			data[i] = randomInteger;
		}

	}

}
