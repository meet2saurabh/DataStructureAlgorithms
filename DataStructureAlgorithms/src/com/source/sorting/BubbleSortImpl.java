package com.source.sorting;

import java.util.Random;

public class BubbleSortImpl {
  
    static int data[];
    static int size= 10;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		data = new int[size];
		input();
		print();
		buubleSort(data);
		print();
		
	}
	
	
	public static void buubleSort(int arr[]) {
		
		for(int i=0;i< size-1;i++) {
			for(int j=0;j< size-i-1;j++) {
				if(arr[j]> arr[j+1]) {
					int temp = arr[j];
					arr[j]= arr[j+1];
					arr[j+1] = temp;
							
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
