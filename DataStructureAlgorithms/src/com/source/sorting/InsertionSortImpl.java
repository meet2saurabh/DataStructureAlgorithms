package com.source.sorting;

import java.util.Random;

public class InsertionSortImpl {

    static int data[];
    static int size= 10;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		data = new int[size];
		input();
		print();
		insertionSort(data);
		print();
		
	}
	
	
	public static void insertionSort(int arr[]) {
		
		for(int i=0;i<size;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1]= temp;
				}
			}
		}
		
	}
	
	public static void print() {
		System.out.println();
		 for(int i =0; i<size; i++){
		      System.out.print(data[i]+" ");
		 }
		 System.out.println();
	}
	
	public static void input() {
		Random random = new Random();
		 for(int i =0; i<size; i++){
		      int randomInteger = random.nextInt(100);
		      data[i]=randomInteger;
		 }


	}

}

