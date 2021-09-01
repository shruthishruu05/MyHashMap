package com.bridgelabz.linkedlist;

public class LinkedList<K extends Comparable <K>> {
	
	public INode<K> head;
	public INode<K> tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void add(INode<K> newNode) {
		if(head == null) {
			this.head = newNode;
		}
		if(tail == null) {
			this.tail = newNode;
		}
		else {
			newNode.setNext(this.head);
			this.head = newNode;
		}
	}
	
	public void append(INode<K> newNode) {
		if(head == null) {
			this.head = newNode;
		}
		if(tail == null) {
			this.tail = newNode;
		}
		else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}
	
	public void insert(INode<K> prevNode , INode<K> newNode) {
		INode<K> tempNode = prevNode.getNext();
		prevNode.setNext(newNode);
		newNode.setNext(tempNode);
	}
	
	public INode<K> pop(){
		INode<K> tempNode = this.head;
		this.head = this.head.getNext();
		return tempNode;
	}
	
	public INode<K> popLast(){
		INode<K> tempNode= this.head;
		while(!tempNode.getNext().equals(this.tail)) {
			tempNode = tempNode.getNext();
		}
		this.tail = tempNode;
		tempNode = tempNode.getNext();
		this.tail.setNext(null);
		return tempNode;
	}
	
	public INode<K> search(K key) {
		INode<K> tempNode = this.head;
		while(tempNode != null) {
			if(tempNode.getKey().equals(key)) {
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}
	
	
	public INode<K> delete(K key){
		INode<K> tempNode = this.head;
		while(tempNode != null) {
			if(tempNode.getNext().getKey().equals(key)) {
				INode<K> deletedNode = tempNode.getNext();
				tempNode.setNext(deletedNode.getNext());
				return deletedNode;
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}
	
	public int size() {
		int count = 0;
		INode<K> tempNode = this.head;
		while(tempNode != null) {
			count++;
			tempNode = tempNode.getNext();
		}
		return count;
	}
	
	public void display() {
		INode<K> tempNode = this.head;
		while(tempNode.getNext() != null) {
			System.out.print(tempNode.getKey()+" -> ");
			tempNode = tempNode.getNext();
		}
		System.out.println(tempNode.getKey());
	}
	
	public String toString() {
		return head.toString();
	}
}