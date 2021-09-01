package com.bridgelabz.myhashmap;
import com.bridgelabz.linkedlist.*;

import java.util.ArrayList;

public class MyHashMap<K extends Comparable<K>,V extends Comparable <V>> {
	private final int numBuckets; 
	ArrayList<LinkedList<K>> myBucketArray; 
	
	public MyHashMap() {
		this.numBuckets = 10;
		this.myBucketArray = new ArrayList<LinkedList<K>>(numBuckets);
		for(int i=0; i< numBuckets; i++) this.myBucketArray.add(null);
	}
	
	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode% numBuckets;
		return index;
	}
	
	public V get(K key) {
		int index = getBucketIndex(key);
		LinkedList<K> myLinkedList = myBucketArray.get(index);
		if(myLinkedList == null) return null;
		MyMapNode<K,V> myMapNode = (MyMapNode<K,V>) myLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}
	
	public void add(K key, V value) {
		int index = getBucketIndex(key);
		LinkedList<K> LinkedList = myBucketArray.get(index);
		if(LinkedList == null) {
			LinkedList = new LinkedList<K>();
			this.myBucketArray.set(index,LinkedList);
		}
		MyMapNode<K,V> myMapNode = (MyMapNode<K,V> ) LinkedList.search(key);
		if(myMapNode == null) {
			myMapNode = new MyMapNode<K,V> (key, value);
			LinkedList.append(myMapNode);
		}
		else {
			myMapNode.setValue(value);
		}
	}
	
	@Override
	public String toString() {
		
		return "MyHashMapNodes{" +myBucketArray+ "}";
	}
	
}