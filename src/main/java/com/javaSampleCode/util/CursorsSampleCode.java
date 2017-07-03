package com.javaSampleCode.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class CursorsSampleCode {
	public static <T> void iteratorSampleCode(List<T> list) {
		System.out.println("Iterator Sample Code");
		Iterator<T> itr = list.iterator();

		while (itr.hasNext()) {
			T nextElement = itr.next();
			if (nextElement == new Integer(3)) {
				itr.remove();
				continue;
			}
			System.out.println(nextElement);
		}
	}

	public static <T> void listIteratorSampleCode(List<T> list, T setElement, T addElement) {
		System.out.println("List Iterator Sample Code");
		ListIterator<T> itr = list.listIterator();

		System.out.println("Forward Iteraton ");
		while (itr.hasNext()) {
			Integer element = (Integer) itr.next();
			System.out.println(element);
			if (element == 3) {
				itr.add(addElement);
				System.out.println("Add Size " + list.size());
			} else if (element == 5) {
				itr.set(setElement);
				System.out.println("Update Size " + list.size());
			}
		}
		System.out.println("Updated List " + list);
		System.out.println("Backward Iteraton ");
		while (itr.hasPrevious()) {
			Integer element = (Integer) itr.previous();
			System.out.println(element);
			if (element == 3) {
				itr.add(addElement);
				System.out.println("Add Size " + list.size());
			} else if (element == 5) {
				itr.set(setElement);
				System.out.println("Update Size " + list.size());
			} else if (element == 4) {
				System.out.println("Previos Index " + itr.previousIndex());
				System.out.println("Next Index " + itr.nextIndex());
			}
		}
		System.out.println("Updated List " + list);
	}

	public static <T> void enumeratorSampleCode(Vector<T> vector) {
		System.out.println("Enumerator Sample Code");
		Enumeration<T> enumeration = vector.elements();
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		CursorsSampleCode.<Integer>iteratorSampleCode(list);
		CursorsSampleCode.listIteratorSampleCode(list, 50, 30);

		Vector<Integer> vector = new Vector<>();
		vector.add(1);
		vector.add(2);
		vector.add(3);
		vector.add(4);
		CursorsSampleCode.enumeratorSampleCode(vector);
	}
}
