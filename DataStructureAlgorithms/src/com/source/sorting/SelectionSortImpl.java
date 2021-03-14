package com.source.sorting;

import java.util.Random;

public class SelectionSortImpl {
    static int data[];
    static int size= 10;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		data = new int[size];
		input();
		print();
		selelctionSort(data);
		print();
		
	}
	
	
	public static void selelctionSort(int arr[]) {
		
		int min_index =0;
		for(int i=0;i<size;i++) {
			min_index=i;
			for(int j=i+1;j<size;j++) {
				if(arr[j]<arr[min_index]) {
					min_index =j;
				}
			}
			
			int temp = arr[i];
			arr[i]= arr[min_index];
			arr[min_index]=temp;
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
