package com.source.sorting;

import java.util.Random;

public class QuickSortImpl {

	static int data[];
	static int size = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		data = new int[size];
		input();
		print();
		quickSort(data, 0,data.length-1);
		print();

	}
	
	public static int partition(int arr[],int low,int high) {
		
		int pivot = arr[high];
		
		int i= low-1;
		for(int j = low;j<high;j++) {
			if(arr[j] <= pivot) {
				i++;
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
			}
		}
		
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

		
		return i+1;
	}
	
	public static void quickSort(int arr[],int low ,int high) {
		if( low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
		}
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
