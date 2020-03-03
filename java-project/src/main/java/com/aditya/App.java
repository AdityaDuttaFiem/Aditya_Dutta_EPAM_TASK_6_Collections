package com.aditya;

import java.util.*;
import java.io.*;
 
class MyList<E> 
{
    private int size = 0;
     
    private Object elements[]=new Object[10];

    public void add(E elem) {
        if (size == elements.length) {
            increase_capacity();
        }
        elements[size++] = elem;
    }
     
    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    @SuppressWarnings("unchecked")
    public E remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = elements[i];
        int numElts = elements.length - ( i + 1 ) ;
        System.arraycopy( elements, i + 1, elements, i, numElts ) ;
        size--;
        return (E) item;
    }
     
    public int size() {
        return size;
    }
     
    @Override
    public String toString() 
    {
         StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < size ;i++) {
             sb.append(elements[i].toString());
             if(i<size-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();
    }
     
    private void increase_capacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}

public class App
{
    public static void main(String[] args) 
    {
        MyList list = new MyList();
	Scanner sc=new Scanner(System.in);
	int ch=0;
	while(ch!=-1)
	{
		System.out.print("Enter 1 to add,2 to remove,3 to fetch,4 to print,-1 to QUIT:");
		ch=sc.nextInt();
		if(ch==1)
		{
			System.out.print("Enter element:");list.add(sc.next());
		}
		if(ch==2)
		{
			System.out.print("Enter index:");list.remove(sc.nextInt());
		}
        	if(ch==3)
		{
			System.out.print("Enter index:");Object val=list.get(sc.nextInt());
			System.out.println(val);
		}
		if(ch==4)
			System.out.println(list);

        	System.out.println("Current size:"+list.size());
	}
    }
}