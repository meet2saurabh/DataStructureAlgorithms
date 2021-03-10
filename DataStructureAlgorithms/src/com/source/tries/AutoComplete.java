package com.source.tries;

class TriesNodes {
	TriesNodes children[];
	boolean isEndOfWord;
	int count;
	String word;

	public TriesNodes() {
		isEndOfWord = false;
		count = 0;
		children = new TriesNodes[26];
		word = null;
	}
}

class Triess {
	TriesNodes mRoot;
	int ALFABATE_SIZE = 26;
    String result = " ";

	public Triess() {
		mRoot = new TriesNodes();
	}

	public void delete(String word) {

	}
	
	public void printdisctioanry() {
		
	}

	public void add(String word) {
		TriesNodes currentNode = mRoot;
		
  		for (int i = 0; i < word.length(); i++) {
			TriesNodes node = new TriesNodes();
			char c = word.charAt(i);
			int index = c - 'a';

			if (currentNode.children[index] == null) {
				currentNode.children[index] = node;
				currentNode = node;
				currentNode.count++;
			} else {
				currentNode = currentNode.children[index];
				currentNode.count++;
			}
		}
		currentNode.word = word;
		currentNode.isEndOfWord = true;
	}

	public boolean search(String word) {
		TriesNodes currentNode = mRoot;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';

			if (currentNode.children[index] != null) {
				currentNode = currentNode.children[index];
			} else {
				return false;
			}

		}

		if (currentNode != null && currentNode.isEndOfWord)
			return true;

		return false;

	}

	public int searchwithPrefix(String word) {

		TriesNodes currentNode = mRoot;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if (currentNode.children[index] != null) {
				currentNode = currentNode.children[index];
			} else {
				return 0;
			}

		}

		if (currentNode.isEndOfWord && isLastNode(currentNode)) {
            result = word;
			System.out.println(word);
			return -1;
		}

		if (!isLastNode(currentNode)) {
			serchWords(currentNode, word);
			return 1;
		}

		return 0;
	}

	public boolean isLastNode(TriesNodes node) {
		for (int i = 0; i < 26; i++) {
			if (node.children[i] != null)
				return false;
		}
		return true;

	}

	public void serchWords(TriesNodes node, String prefix) {

		if (node.isEndOfWord) {
			result = prefix +" "+result;
			System.out.println(">"+prefix + " "+ node.count);
		}
		if (isLastNode(node))
			return;

		
		for (int i = 0; i < 26; i++) {
			if (node.children[i] != null) {
				String newPrefix = prefix + (char) (97 + i);
				serchWords(node.children[i], newPrefix);
			}
		}

	}
}

public class AutoComplete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triess mtries = new Triess();

		// mtries.add("sam");
		mtries.add("sam");
		mtries.add("samsung");
		mtries.add("samsungglobal");
		mtries.add("saurabh");
		mtries.add("sammy");
		mtries.add("samsung");
		mtries.add("sanu");

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

		int result = mtries.searchwithPrefix("sa");

		if (result == 0) {
			System.out.println("No string found with this prefix ");
		}

		if (result == -1) {
			System.out.println("No other strings found with this prefix");
		}
		
		String res [] = mtries.result.split(" ");
		System.out.println("Autocomplete result..");
		for(int i=0;i<res.length;i++) {
			System.out.println(res[i]);
		}
	}

}
