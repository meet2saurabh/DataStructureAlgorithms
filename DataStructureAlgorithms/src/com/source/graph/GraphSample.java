package com.source.graph;

import java.util.Scanner;


class Vertex{
	int lable;
	boolean isVisited;
	
	public Vertex(int l,boolean visited) {
		this.lable = l;
		this.isVisited =visited;
	}
}


public class GraphSample {
    static int numberOfVertex;
    static int numberOfEdge;
    static Vertex mVertex[];
    static int  mMetrix [][];
    
    
    
    static public void addEdge(int start,int end) {
    	mMetrix[start][end]=1;
    	mMetrix[end][start]=1;
    }
    
    static public void print() {
    	for(int r =0;r < numberOfVertex;r++) {
    		System.out.println();
    		for(int c=0;c<numberOfVertex;c++) {
    			System.out.print(mMetrix[r][c]+" ");
    		}
    	}
    }
    
     static public void doDFS(int start) {
    	 for (int i = 0; i <numberOfVertex; i++) {
 			mVertex[i] = new Vertex(i,false);
 		}
    	 System.out.println("doDFS");  
    	int STACK[]= new int[numberOfVertex];
    	int top =-1;
    	
    	mVertex[start].isVisited = true;
    	System.out.println(mVertex[start].lable);
    	STACK[++top]= start;
    	while(top>=0) {
    		int v = getAdjectentVertex(STACK[top]);
    		if(v!=-1) {
    	    	mVertex[v].isVisited = true;
    	    	System.out.println(mVertex[v].lable);
    	    	STACK[++top]= v;

    		}else {
    			--top;
    		}
    	}
    	 
    }
    
    static public void doBFS(int start) {
    	 for (int i = 0; i <numberOfVertex; i++) {
  			mVertex[i] = new Vertex(i,false);
  		}
    	System.out.println("doBSF"); 
    	int QUEUE[]= new int[numberOfVertex];
    	int FRONT =-1;
    	int REAR =-1;
    	
    	mVertex[start].isVisited = true;
    	System.out.println(mVertex[start].lable);
    	REAR = (REAR+1)%numberOfVertex;
    	QUEUE[REAR]= start;
    	
    	while(REAR != FRONT) {
    		FRONT = (FRONT+1)%numberOfVertex;
    		int v;
    		while((v=getAdjectentVertex(QUEUE[FRONT]))!=-1){
    	    	mVertex[v].isVisited = true;
    	    	System.out.println(mVertex[v].lable);
    	    	REAR = (REAR+1)%numberOfVertex;
    	    	QUEUE[REAR]= v;
    		}
    		
    	}
    	
    }
	
    static public int getAdjectentVertex(int v) {
    	for(int i=0;i<numberOfVertex;i++) {
    		if(mMetrix[v][i]==1 && mVertex[i].isVisited==false) {
    			return i;
    		}
    	}
		return -1;
    	
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		numberOfVertex = sc.nextInt();
		numberOfEdge = sc.nextInt();
		mVertex = new Vertex[numberOfVertex];
		mMetrix = new int[numberOfVertex][numberOfVertex];
		
		for(int i=0;i<numberOfVertex;i++) {
			mVertex[i] = new Vertex(i,false);
		}
		
		for(int i=0;i<numberOfEdge;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			addEdge(start,end);
		}
		sc.close();
		print();
		
		doBFS(0);
		doDFS(0);
		
		
	}

}
/*
7
6
0 1
0 2
1 3
1 4
2 5
2 6
*/
