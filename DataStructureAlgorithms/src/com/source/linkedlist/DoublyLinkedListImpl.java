package com.source.linkedlist;
//void init()
//void insertAfter(int data)
//void insertBefore(int data)
//void movePrevious()
//void moveNext()
//void remove()
//int data()
//void finish()
class DNode{
	int data;
	DNode next;
	DNode prev;
	
	public DNode(int d) {
		this.data = d;
		this.next = null;
		this.prev = null;
	}
}

class DoublyLinkList{
	DNode mHead;
	DNode mCurrent;
	
	void init() {
		mHead = null;
		mCurrent = null;
	}
	
	void insertAfter(int data) {
       
		DNode node = new DNode(data);
		
		if(mHead ==null) {
		   mHead = node;
		   mCurrent = mHead;
		   return;
		}
		
		if(mCurrent.next !=null) {
			node.next = mCurrent.next;
			mCurrent.next.prev = node;
			mCurrent.next = node;
			node.prev = mCurrent;
		   return;
		}
		
				
		mCurrent.next = node;
		node.prev = mCurrent;

		
	}
	
	void insertBefore(int data) {
		
		DNode node = new DNode(data);
		
		if (mHead == null) {
			mHead = node;
			mCurrent = mHead;
			return;
		}
		
		if(mCurrent == mHead) {
			node.next = mCurrent;
			mCurrent.prev = node;
			mHead = node;
			return;
		}
		
		mCurrent.prev.next = node;
		node.prev = mCurrent.prev;
		node.next= mCurrent;
		mCurrent.prev = node;
		
		
	}
	
	void movePrevious() {
		
		if(mHead == null)
			return;
		
		if(mCurrent == null)
			return;
		
		if(mCurrent.prev ==null)
			return;
		if(mCurrent.prev!=null)
			mCurrent = mCurrent.prev;
	}
	
	void moveNext() {
		
		if(mHead == null)
			return;
		
		if(mCurrent == null)
			return;

		
		if(mCurrent.next ==null)
			return;
		
		if(mCurrent.next!=null)
			mCurrent = mCurrent.next;
	}
	
	void remove() {
		
		if(mHead ==null) {
			return;
		}
		
		if(mCurrent == mHead) {
			mCurrent = mCurrent.next;
			mCurrent.prev = null;
			mHead = mCurrent;
			return;
		}
		
		if(mCurrent.next == null) {
			mCurrent = mCurrent.prev;
			mCurrent.next = null;
			return;
		}
		
		mCurrent.prev.next = mCurrent.next;
		mCurrent.next.prev = mCurrent.prev;
		mCurrent = mCurrent.next;
		
	
	}
	
	int data() {
		if(mHead== null)
			return -1;
		return mCurrent.data;
		
	}
	
	void finish() {
		mHead = null;
		mCurrent = null;
	}
	
	void print() {
		if(mHead == null) {
		    return;	
	    }
		
		DNode node = mHead;
		System.out.println();
		while(node != null) {
			System.out.print(node.data+"->");
			node = node.next;
		}
	}

}
public class DoublyLinkedListImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		DoublyLinkList mDoublyLinkList = new DoublyLinkList();
		mDoublyLinkList.init();
		
		mDoublyLinkList.insertBefore(10);
		mDoublyLinkList.movePrevious();
		System.out.println();
		System.out.println(mDoublyLinkList.data());
		
		mDoublyLinkList.insertAfter(20);
		mDoublyLinkList.insertAfter(30);
		
		mDoublyLinkList.print();
	    System.out.println();
		System.out.println(mDoublyLinkList.data());

		System.out.println();
		mDoublyLinkList.moveNext();
		System.out.println(mDoublyLinkList.data());
		
		mDoublyLinkList.insertAfter(11);
		mDoublyLinkList.insertAfter(12);
		mDoublyLinkList.insertAfter(13);
		mDoublyLinkList.insertAfter(14);

		mDoublyLinkList.print();
		
		mDoublyLinkList.insertBefore(9);
		mDoublyLinkList.insertBefore(8);
		mDoublyLinkList.print();
		
		
		System.out.println();
		mDoublyLinkList.moveNext();
		System.out.println(mDoublyLinkList.data());

		System.out.println();
		mDoublyLinkList.moveNext();
		System.out.println(mDoublyLinkList.data());

		System.out.println();
		mDoublyLinkList.movePrevious();
		System.out.println(mDoublyLinkList.data());
		
		System.out.println();
		mDoublyLinkList.movePrevious();
		System.out.println(mDoublyLinkList.data());

		mDoublyLinkList.remove();
		mDoublyLinkList.print();
		

		mDoublyLinkList.moveNext();
		mDoublyLinkList.moveNext();
		mDoublyLinkList.moveNext();
		mDoublyLinkList.moveNext();
		System.out.println();
		System.out.println(mDoublyLinkList.data());
		
		mDoublyLinkList.remove();
		mDoublyLinkList.print();

		System.out.println();
		mDoublyLinkList.movePrevious();
		System.out.println(mDoublyLinkList.data());
		
		System.out.println();
		mDoublyLinkList.movePrevious();
		System.out.println(mDoublyLinkList.data());

		mDoublyLinkList.remove();
		mDoublyLinkList.print();


	}

}
