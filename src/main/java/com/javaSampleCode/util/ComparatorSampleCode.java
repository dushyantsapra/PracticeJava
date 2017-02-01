package com.javaSampleCode.util;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class CustomComparator implements Comparator<TestPOJO> {

	@Override
	public int compare(TestPOJO obj1, TestPOJO obj2) {
		return obj1.getId() - obj2.getId() + obj1.getName().compareTo(obj2.getName());
	}
}

public class ComparatorSampleCode {
	public static void main(String[] args) {
		Set<TestPOJO> treeSet = new TreeSet<TestPOJO>(new CustomComparator());
		treeSet.add(new TestPOJO(1, "Sam"));
		treeSet.add(new TestPOJO(1, "Rohan"));
		treeSet.add(new TestPOJO(1, "Sam"));

		for (TestPOJO obj : treeSet) {
			System.out.println(obj);
		}

		System.out.println(treeSet);

		Object tempObject = new Object();

		Map<TestPOJO, Object> treeMap = new TreeMap<TestPOJO, Object>(new CustomComparator());
		treeMap.put(new TestPOJO(1, "Sam"), tempObject);
		treeMap.put(new TestPOJO(1, "Rohan"), tempObject);
		treeMap.put(new TestPOJO(2, "Sam"), tempObject);

		for (Map.Entry<TestPOJO, Object> entrySet : treeMap.entrySet()) {
			System.out.println(entrySet.getKey());
		}

		System.out.println(treeMap);
	}
}