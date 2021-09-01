package com.bridgelabz.myhashmap;

	import java.util.ArrayList;

	import com.bridgelabz.linkedlist.LinkedList;

	public class MyLinkedHashMap<K extends Comparable<K>,V extends Comparable<V>> {
		
		private final int numBuckets;
		
		ArrayList<LinkedList<K>> myBucketArray;
		
		public MyLinkedHashMap() {
			this.numBuckets = 10;
			this.myBucketArray = new ArrayList<LinkedList<K>>(numBuckets);
			
			for(int index=0 ; index <numBuckets ; index++) {
				this.myBucketArray.add(null);
			}
		}
		
		private int getBucketIndex(K key) {
			int hashCode = Math.abs(key.hashCode());
			int index = hashCode % numBuckets;
			return index;
		}
		
		public V get(K key) {
			
			int index = this.getBucketIndex(key);
			LinkedList<K> myLinkedList = this.myBucketArray.get(index);
			if(myLinkedList == null)
				return null;
			MyMapNode<K,V> myMapNode = (MyMapNode<K,V>) myLinkedList.search(key);
			return(myMapNode == null)?null:myMapNode.getValue();
		}
		
		public void add(K key, V value) {
			int index = this.getBucketIndex(key);
			LinkedList<K> myLinkedList = this.myBucketArray.get(index);
			if(myLinkedList == null) {
				myLinkedList = new LinkedList<K>();
				this.myBucketArray.set(index, myLinkedList);
			}
			
			MyMapNode<K, V>myMapNode = (MyMapNode<K,V>) myLinkedList.search(key);
			if(myMapNode == null) {
				myMapNode = new MyMapNode<K, V>(key, value);
				myLinkedList.appendNodes(myMapNode);
			}
			else {
				myMapNode.setValue(value);
			}
		}
		
		@Override
		public String toString() {
			return "MyLinkedHashMap List{" + myBucketArray + '}';
		}
		
	}


