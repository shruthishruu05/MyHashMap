package com.bridgelabz.linkedlist;

public class LinkedList<K extends Comparable <K>> {
	
	public INode head;
	public INode tail;
	public LinkedList() {
		this.head = head;
		this.tail = tail;
	}
	public void add(INode newNode)
	{
		if(this.tail==null) {
			this.tail = newNode;
		}
		if(this.head==null) {
			this.head = newNode;
		}
		else
		{
			INode tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
	}
	public void appendNodes(INode newNode)
	{
		if(this.head==null)
		{
			this.head =newNode;
		}
		if(this.tail==null) {    
			this.tail = newNode;
		}
		else
		{
			INode tempNode =newNode;
			tempNode.setNext(this.head);
			this.head = newNode;
		}
	}
	
	public void printLinkedList()
	{
		System.out.println("My nodes: "+head );
	}
	public void insert(INode newNode)
	{
		this.head.setNext(newNode);
		newNode.setNext(this.tail);
		
	}
	public Object pop()
	{
		INode tempNode = this.head;
		this.head = (INode) this.head.getNext();
		return  tempNode.getKey();	
	}
	public Object popLast()
	{
		INode temporaryNode = this.head;
		while(!temporaryNode.getNext().equals(this.tail))
		{
			temporaryNode = temporaryNode.getNext();
		}
		this.tail = temporaryNode;
		temporaryNode = temporaryNode.getNext();
		this.tail.setNext(null);
		return temporaryNode;
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
	
	public void insertAfter(INode nodeAfter,INode node) {
		INode tempNode = this.head;
		while(!tempNode.equals(nodeAfter)) {
			tempNode = tempNode.getNext();
		}
		tempNode.setNext(node);
		node.setNext(this.tail);	
	}
	public void deleteAt(INode node) {
		INode previous=this.head;
		INode current = this.head;
		while(!current.equals(node)) {
			previous = current;
			current=current.getNext();
		}
		previous.setNext(current.getNext());
		current.setNext(null);
	}
	public void ascendingEntry(INode<K> newNode) {
		INode<K> tempNode;
		if(this.head == null || ((Comparable<K>) this.head.getKey()).compareTo(newNode.getKey())>0) {
			newNode.setNext(this.head);
			this.head = newNode;
		}
		else {
			tempNode = this.head;
			while(tempNode.getNext()!= null && ((Comparable<K>) tempNode.getNext().getKey()).compareTo(newNode.getKey())<0)
				tempNode = tempNode.getNext();
			newNode.setNext(tempNode.getNext());
			tempNode.setNext(newNode);
		}
	}
}
