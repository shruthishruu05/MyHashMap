package com.bridgelabz.myhashmap;

public class MyHashMapMain {

	public static void main(String[] args) {
		
			String sentence = "Paranoids are not paranoid because they are paranoid but "+"beacuse they keep putting themselves deliberately into "
								+"paranoid avoidable situations";
			MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
			String [] words = sentence.toLowerCase().split(" ");	
			for( String word : words) {
				Integer value = myHashMap.get(word);
				if(value == null) value = 1;
				else value  = value+1;
				myHashMap.add(word, value);
			}
			Integer frequency  = myHashMap.get("paranoid");
			System.out.println(myHashMap);
			System.out.println("the word \"paranoid\" is repeated :"+frequency+" times");
			myHashMap.remove("avoidable");
		}
}