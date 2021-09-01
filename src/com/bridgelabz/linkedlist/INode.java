package com.bridgelabz.linkedlist;

public interface INode<K> {
	 public K getKey();
	 public void setKey(K key);
	 
	 INode getNext();
	 public void setNext(INode next);
}
