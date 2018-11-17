package com.educative.typehead_commons;

import java.util.HashMap;

public class Trie {
TrieNode root;
	
	class TrieNode{
		boolean isEndOfWord;
		HashMap<Character, TrieNode> hm;
		int searchCount;
		
		TrieNode(){
			isEndOfWord = false;
			hm = new HashMap();
			searchCount = 0;
		}
	};
	
	public boolean search(String s){
		TrieNode first = root;
		
		for(int i=0;i<s.length();i++){
			char letter = s.charAt(i);
			
			if(first.hm.containsKey(letter))
				first = first.hm.get(letter);
			else
				return false;	
		}
		if(first.isEndOfWord){
			first.searchCount++;
			return true;
		}
		return false;
	}
	
	public void insert(String s){		
		TrieNode first = root;
		
		for(int i=0;i<s.length();i++){
			char letter = s.charAt(i);
			if(!first.hm.containsKey(letter)){
				TrieNode newnode = new TrieNode();
				first.hm.put(letter,newnode);
				first = newnode;		
			}
			else{
				first = first.hm.get(letter);
			}
			first.searchCount++;
		}
		first.isEndOfWord = true;
	}
}
