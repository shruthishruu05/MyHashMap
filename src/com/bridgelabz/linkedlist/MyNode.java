package com.bridgelabz.linkedlist;

public class MyNode<K> implements INode<K>
{
	private K key;
	private INode<K> next;
	public MyNode(K key) 
	{
		super();
		this.key = key;
		this.next = null;
	}
	
	@Override
	public K getKey()
	{
		return key;
	}
	@Override
	public void setKey(K key)
	{
		this.key = key;
	}
	
	@Override
	public String toString() {
		StringBuilder myNodeString = new StringBuilder();
		myNodeString.append ("{"+"Key=").append(key).append('}');
		if(next!=null)
		{
			myNodeString.append("-->").append(next);
		}
		return myNodeString.toString();
	}
	@Override
	public INode getNext()
	{
		return next;
	}

	@Override
	public void setNext(INode next)
	{
		this.next = next;
	}

	
}
