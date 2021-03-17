package com.source.tries;


class AutoTrieNode{
	int ALFABATE_SIZE = 26;
	String word;
	
	AutoTrieNode mChildren [];
	int count;
	boolean isEndOfWord;
	
	public AutoTrieNode() {
		mChildren = new AutoTrieNode[ALFABATE_SIZE];
		count =0;
		isEndOfWord = false;
		word = null; 
	}
	
}

class AutoTrie{
	int ALFABATE_SIZE = 26;
	AutoTrieNode mRoot;
	String AutofillResult;
	public void init() {
		mRoot = new AutoTrieNode();
	}
	
	public void insert(String key) {
		AutoTrieNode current = mRoot;
		for(int i=0;i<key.length();i++) {
			char c = key.charAt(i);
			int index = c -'a';
			if(current.mChildren[index]==null) {
				current.mChildren[index] = new AutoTrieNode();
				current = current.mChildren[index];
				current.count++;
			}else {
				current = current.mChildren[index];
				current.count++;
			}
		}
		current.word = key;
		current.isEndOfWord = true;
	}
	
	public void remove(String key) {
		AutoTrieNode root = mRoot;
		remove(root, key, 0);
	}
	
	public AutoTrieNode remove(AutoTrieNode root,String key,int depth) {
		// if Tree is empty
		if(root== null) {
			return  null;
		}
		
		// if last character of key is being processed
		if(depth == key.length()) {
			
		//	This node no more end of word after removal this key 
			if(root.isEndOfWord) // Delete bcde and it can be prefix bcdef
				root.isEndOfWord = false;
			
			// if given is not prefix of any other word
			if(isLeaf(root)) { 
				root = null;
			}
			
			return root;
		}
		
		// if not last character of key recur of the child 
		// Obtain using ASCCII value
		int index = key.charAt(depth) -'a';
		
		root.mChildren[index]= remove(root.mChildren[index], key, depth+1);
		
		// if root does not have any child (its only child got deleted )
		// it is not end of another word/
		
		if(isLeaf(root) && root.isEndOfWord== false) {
			root =null;
		}
		
		return root;
	}
	
	public boolean search(String key) {
		AutoTrieNode current = mRoot;
		for(int i=0;i<key.length();i++) {
			char c = key.charAt(i);
			int index = c-'a';
			if(current.mChildren[index]==null) {
				  return false;
			   }
			  current = current.mChildren[index];
			}
        
		if(current!=null && current.isEndOfWord) {
			return true;
		}
		
		return false;
	}
	
	public void searchWord(String key) {
		
	}
	
	public int searchWithPrefix(String key) {
		
		AutoTrieNode current = mRoot;
		for(int i=0;i<key.length();i++) {
			char c = key.charAt(i);
			int index = c-'a';
			if(current.mChildren[index]==null) {
				return 0;
			}
			current = current.mChildren[index];
		}
		AutofillResult =" ";
		if(current.isEndOfWord && isLeaf(current)) {
			AutofillResult = current.word;
			System.out.println(current.word +" is only word with prefix "+key);
			return -1;
		}
		
		if(!isLeaf(current)) {
			searchWordsWithPrefix(current,key);
		}
		return 1;
	}
	
	public void searchWordsWithPrefix(AutoTrieNode root, String prefix) {
				
		if(root.isEndOfWord) {
			   AutofillResult = prefix +" "+AutofillResult; 
		}
		
		if(isLeaf(root))
			return;
		
		for(int i=0;i<ALFABATE_SIZE;i++) {
			if(root.mChildren[i]!=null) {
			   String newprefix =  prefix + (char)(i+97); 
			   searchWordsWithPrefix(root.mChildren[i],newprefix);
			}
		}
	}
	
	public boolean isLeaf(AutoTrieNode root) {
		for(int i=0;i<ALFABATE_SIZE;i++) {
			if(root.mChildren[i]!=null)
				return false;
		}
		return true;
	}
	
	public void print() {
		
	}
	
	
	
	
}

public class TriesSearchAutofill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoTrie mtries = new AutoTrie();
		mtries.init();

		// mtries.insert("sam");
		mtries.insert("sam");
		mtries.insert("samsung");
		mtries.insert("samsungglobal");
		mtries.insert("saurabh");
		mtries.insert("sammy");
		mtries.insert("samsung");
		mtries.insert("sanu");
		
		mtries.insert("bcde");
		mtries.insert("bc");
		mtries.insert("bcdef");
		mtries.insert("bckg");
		mtries.insert("k");

		if (mtries.search("samsung")) {
			System.out.println("String found");
		} else {
			System.out.println("String not found");
		}

		if (mtries.search("noida")) {
			System.out.println("String found");
		} else {
			System.out.println("String not found");
		}

		int result = mtries.searchWithPrefix("bc");

		if (result == 0) {
			System.out.println("No string found with this prefix ");
		}

		if (result == -1) {
			System.out.println("No other strings found with this prefix");
		}
		
		String res [] = mtries.AutofillResult.split(" ");
		System.out.println("Autocomplete result..");
		for(int i=0;i<res.length;i++) {
			System.out.println(res[i]);
		}
		
		mtries.remove("bcde");
		
		int result1 = mtries.searchWithPrefix("bc");

		if (result1 == 0) {
			System.out.println("No string found with this prefix ");
		}

		if (result1 == -1) {
			System.out.println("No other strings found with this prefix");
		}
		
		String res1 [] = mtries.AutofillResult.split(" ");
		System.out.println("Autocomplete result..");
		for(int i=0;i<res.length;i++) {
			System.out.println(res[i]);
		}

		
		
	}

}
