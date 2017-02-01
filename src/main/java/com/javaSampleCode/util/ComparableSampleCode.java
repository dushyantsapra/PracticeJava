package com.javaSampleCode.util;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ComparableSampleCode implements Comparable<ComparableSampleCode> {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ComparableSampleCode() {
		super();
	}

	public ComparableSampleCode(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComparableSampleCode other = (ComparableSampleCode) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(ComparableSampleCode obj) {
		return this.id - obj.getId() + this.name.compareTo(obj.getName());
	}

	@Override
	public String toString() {
		return "ComparableSampleCode [id=" + id + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		Set<ComparableSampleCode> treeSet = new TreeSet<ComparableSampleCode>();
		treeSet.add(new ComparableSampleCode(1, "Sam"));
		treeSet.add(new ComparableSampleCode(1, "Rohan"));
		treeSet.add(new ComparableSampleCode(1, "Sam"));

		for (ComparableSampleCode obj : treeSet) {
			System.out.println(obj);
		}

		System.out.println(treeSet);

		Object tempObject = new Object();

		Map<ComparableSampleCode, Object> treeMap = new TreeMap<ComparableSampleCode, Object>();
		treeMap.put(new ComparableSampleCode(1, "Sam"), tempObject);
		treeMap.put(new ComparableSampleCode(1, "Rohan"), tempObject);
		treeMap.put(new ComparableSampleCode(1, "Sam"), tempObject);

		for (Map.Entry<ComparableSampleCode, Object> entrySet : treeMap.entrySet()) {
			System.out.println(entrySet.getKey());
		}

		System.out.println(treeMap);
	}
}