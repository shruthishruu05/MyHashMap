package com.bridgelabz.myhashmap;
import com.bridgelabz.linkedlist.*;

public class MyHashMap<K extends Comparable<K>, V extends Comparable<V>> {

	LinkedList<K> hashLinkedList;

	public MyHashMap() {
		this.hashLinkedList = new LinkedList<>();
	}

	public V get(K key) {
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.hashLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	public void add(K key, V value) {
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.hashLinkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<K, V>(key, value);
			this.hashLinkedList.appendNodes(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	@Override
	public String toString() {
		return "Hash Map{" + hashLinkedList + "}";
	}
}