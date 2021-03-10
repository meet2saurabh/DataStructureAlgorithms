package com.source.heap;


class Min {
	int Max;
	int size;
	int mHeap[];
	int FRONT =1;
	
	public Min(int _max) {
		this.Max = _max;
		this.size =0;
		mHeap = new int[this.Max+1];
	}
	
	public int getParent(int index) {
		return index/2;
	}
	
	public int leftChild(int index) {
		return 2*index;
	}
	
	public int rightChild(int index) {
		return 2*index+1;
	}
	
	public void add(int item) {
		if(size ==Max) {
			System.out.println("Heap is Full");
			return;
		}
		
		mHeap[size+1] =item;
		size++;
		heapifyUp(size);
		System.out.println("added :"+item);
	}
	
	public int  poll() {
		if(size ==0) {
			System.out.println("poll():Heap is Empty");
			return -1;
		}
		int item = mHeap[FRONT];
		mHeap[FRONT]=mHeap[size];
		size--;
		heapifyDown(FRONT);
		return item;
	}
	
	public void heapifyUp(int index) {
		while(mHeap[index]< mHeap[getParent(index)] && getParent(index) > 0) {
			int temp = mHeap[index];
			mHeap[index] = mHeap[getParent(index)];
			mHeap[getParent(index)] = temp;
			index = getParent(index);
		}
	}
	
	public void heapifyDown(int index) {
		if(mHeap[index] > mHeap[leftChild(index)] || mHeap[index] > mHeap[rightChild(index)]) {
			while(!isleaf(index) && index < size) {
				if(mHeap[leftChild(index)] < mHeap[rightChild(index)]) {
					int temp = mHeap[index];
					mHeap[index] =mHeap[leftChild(index)] ;
					mHeap[leftChild(index)] = temp;
					index = leftChild(index);
				}else if(mHeap[rightChild(index)] < mHeap[leftChild(index)]) {
					int temp = mHeap[index];
					mHeap[index] =mHeap[rightChild(index)] ;
					mHeap[rightChild(index)] = temp;
					index = rightChild(index);

				}
			}
		}
	}
	
	public boolean isleaf(int index) {
		if(index > size/2 && index <=size)
			return true;
		return false;
	}
	
	public int peek() {
		if(size ==0) {
			System.out.println("peek():Heap is Empty");
			return -1;
		}
		return mHeap[FRONT];
	}
	
	public int size() {
		return size;
	}
	
	public void printHeap() {
		System.err.println();
		for(int i =1 ;i<=size/2 ;i++) {
			System.out.println("Parent :"+mHeap[i]+" leftChild :"+mHeap[leftChild(i)]
					+" rightChild :"+mHeap[rightChild(i)]);
		}
	}
	
	public void printHeapStack() {
		if(size ==0) {
			System.out.println("printHeapStack():Heap is Empty");
			return ;
		}

		System.out.println();
		for(int i=1;i<=size;i++) {
			System.out.print(mHeap[i]+",");
		}
	}
}

class Max{
	int Max;
	int size;
	int mHeap[];
	int FRONT =1;
	
	public Max(int _max) {
		this.Max = _max;
		this.size =0;
		mHeap = new int[this.Max+1];
	}
	
	public int getParent(int index) {
		return index/2;
	}
	
	public int leftChild(int index) {
		return 2*index;
	}
	
	public int rightChild(int index) {
		return 2*index+1;
	}
	
	public void add(int item) {
		if(size ==Max) {
			System.out.println("Heap is Full");
			return;
		}
		
		mHeap[size+1] =item;
		size++;
		heapifyUp(size);
		System.out.println("added :"+item);
	}
	
	public int  poll() {
		if(size ==0) {
			System.out.println("poll():Heap is Empty");
			return -1;
		}
		int item = mHeap[FRONT];
		mHeap[FRONT]=mHeap[size];
		size--;
		heapifyDown(FRONT);
		return item;
	}
	
	public void heapifyUp(int index) {
		while(mHeap[index] > mHeap[getParent(index)] && getParent(index) > 0) {
			int temp = mHeap[index];
			mHeap[index] = mHeap[getParent(index)];
			mHeap[getParent(index)] = temp;
			index = getParent(index);
		}
	}
	
	public void heapifyDown(int index) {
		if(mHeap[index] < mHeap[leftChild(index)] || mHeap[index] < mHeap[rightChild(index)]) {
			while(!isleaf(index) && index < size) {
				if(mHeap[leftChild(index)] > mHeap[rightChild(index)]) {
					int temp = mHeap[index];
					mHeap[index] =mHeap[leftChild(index)] ;
					mHeap[leftChild(index)] = temp;
					index = leftChild(index);
				}else if(mHeap[rightChild(index)] > mHeap[leftChild(index)]) {
					int temp = mHeap[index];
					mHeap[index] =mHeap[rightChild(index)] ;
					mHeap[rightChild(index)] = temp;
					index = rightChild(index);

				}
			}
		}
	}
	
	public boolean isleaf(int index) {
		if(index > size/2 && index <=size)
			return true;
		return false;
	}
	
	public int peek() {
		if(size ==0) {
			System.out.println("peek():Heap is Empty");
			return -1;
		}
		return mHeap[FRONT];
	}
	
	public int size() {
		return size;
	}
	
	public void printHeap() {
		System.err.println();
		for(int i =1 ;i<=size/2 ;i++) {
			System.out.println("Parent :"+mHeap[i]+" leftChild :"+mHeap[leftChild(i)]
					+" rightChild :"+mHeap[rightChild(i)]);
		}
	}
	
	public void printHeapStack() {
		if(size ==0) {
			System.out.println("printHeapStack():Heap is Empty");
			return ;
		}

		System.out.println();
		for(int i=1;i<=size;i++) {
			System.out.print(mHeap[i]+",");
		}
	}
}
public class MinMaxHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Min mMinHeap = new Min(20);
		mMinHeap.add(22);
		mMinHeap.add(15);
		mMinHeap.add(17);
		mMinHeap.add(11);
		mMinHeap.add(9);
		mMinHeap.add(18);
		mMinHeap.add(20);
		mMinHeap.add(40);
		mMinHeap.add(32);
		mMinHeap.add(35);
		mMinHeap.add(19);
		mMinHeap.add(21);
		mMinHeap.add(3);
		mMinHeap.add(7);
		mMinHeap.add(41);
		mMinHeap.printHeap();
		
		while(mMinHeap.size()>0) {
			System.out.println(mMinHeap.poll());
			//mMinHeap.printHeapStack();
		}
		
		
		Max mMaxHeap = new Max(20);
		mMaxHeap.add(22);
		mMaxHeap.add(15);
		mMaxHeap.add(17);
		mMaxHeap.add(11);
		mMaxHeap.add(9);
		mMaxHeap.add(18);
		mMaxHeap.add(20);
		mMaxHeap.add(40);
		mMaxHeap.add(32);
		mMaxHeap.add(35);
		mMaxHeap.add(19);
		mMaxHeap.add(21);
		mMaxHeap.add(3);
		mMaxHeap.add(7);
		mMaxHeap.add(41);
		mMaxHeap.printHeap();
		
		while(mMaxHeap.size()>0) {
			System.out.println(mMaxHeap.poll());
			//mMinHeap.printHeapStack();
		}

	}

}
