package com.javaSampleCode.json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

class JsonSimpleBean {
	private int id;
	private String name;
	private Map<Integer, Integer> simpleMap;
	private List<String> simpleList;
	private Map<Integer, List<Integer>> MapHavinList;
	private List<Map<Integer, Integer>> listHavingMap;
	private Map<Integer, Map<Integer, List<Integer>>> mapHavingMapHavingList;
	private List<Map<Integer, List<Integer>>> listhavingMapHavingList;

	public JsonSimpleBean() {
		super();
	}

	public JsonSimpleBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public JsonSimpleBean(int id, String name, Map<Integer, Integer> simpleMap) {
		super();
		this.id = id;
		this.name = name;
		this.simpleMap = simpleMap;
	}

	public JsonSimpleBean(int id, String name, Map<Integer, Integer> simpleMap, List<String> simpleList) {
		super();
		this.id = id;
		this.name = name;
		this.simpleMap = simpleMap;
		this.simpleList = simpleList;
	}

	public JsonSimpleBean(int id, String name, Map<Integer, Integer> simpleMap, List<String> simpleList,
			Map<Integer, List<Integer>> mapHavinList) {
		super();
		this.id = id;
		this.name = name;
		this.simpleMap = simpleMap;
		this.simpleList = simpleList;
		MapHavinList = mapHavinList;
	}

	public JsonSimpleBean(int id, String name, Map<Integer, Integer> simpleMap, List<String> simpleList,
			Map<Integer, List<Integer>> mapHavinList, List<Map<Integer, Integer>> listHavingMap) {
		super();
		this.id = id;
		this.name = name;
		this.simpleMap = simpleMap;
		this.simpleList = simpleList;
		MapHavinList = mapHavinList;
		this.listHavingMap = listHavingMap;
	}

	public JsonSimpleBean(int id, String name, Map<Integer, Integer> simpleMap, List<String> simpleList,
			Map<Integer, List<Integer>> mapHavinList, List<Map<Integer, Integer>> listHavingMap,
			Map<Integer, Map<Integer, List<Integer>>> mapHavingMapHavingList) {
		super();
		this.id = id;
		this.name = name;
		this.simpleMap = simpleMap;
		this.simpleList = simpleList;
		MapHavinList = mapHavinList;
		this.listHavingMap = listHavingMap;
		this.mapHavingMapHavingList = mapHavingMapHavingList;
	}

	public JsonSimpleBean(int id, String name, Map<Integer, Integer> simpleMap, List<String> simpleList,
			Map<Integer, List<Integer>> mapHavinList, List<Map<Integer, Integer>> listHavingMap,
			Map<Integer, Map<Integer, List<Integer>>> mapHavingMapHavingList,
			List<Map<Integer, List<Integer>>> listhavingMapHavingList) {
		super();
		this.id = id;
		this.name = name;
		this.simpleMap = simpleMap;
		this.simpleList = simpleList;
		MapHavinList = mapHavinList;
		this.listHavingMap = listHavingMap;
		this.mapHavingMapHavingList = mapHavingMapHavingList;
		this.listhavingMapHavingList = listhavingMapHavingList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, Integer> getSimpleMap() {
		return simpleMap;
	}

	public void setSimpleMap(Map<Integer, Integer> simpleMap) {
		this.simpleMap = simpleMap;
	}

	public List<String> getSimpleList() {
		return simpleList;
	}

	public void setSimpleList(List<String> simpleList) {
		this.simpleList = simpleList;
	}

	public Map<Integer, List<Integer>> getMapHavinList() {
		return MapHavinList;
	}

	public void setMapHavinList(Map<Integer, List<Integer>> mapHavinList) {
		MapHavinList = mapHavinList;
	}

	public List<Map<Integer, Integer>> getListHavingMap() {
		return listHavingMap;
	}

	public void setListHavingMap(List<Map<Integer, Integer>> listHavingMap) {
		this.listHavingMap = listHavingMap;
	}

	public Map<Integer, Map<Integer, List<Integer>>> getMapHavingMapHavingList() {
		return mapHavingMapHavingList;
	}

	public void setMapHavingMapHavingList(Map<Integer, Map<Integer, List<Integer>>> mapHavingMapHavingList) {
		this.mapHavingMapHavingList = mapHavingMapHavingList;
	}

	public List<Map<Integer, List<Integer>>> getListhavingMapHavingList() {
		return listhavingMapHavingList;
	}

	public void setListhavingMapHavingList(List<Map<Integer, List<Integer>>> listhavingMapHavingList) {
		this.listhavingMapHavingList = listhavingMapHavingList;
	}

	@Override
	public String toString() {
		return "JsonSimpleBean [id=" + id + ", name=" + name + ", simpleMap=" + simpleMap + ", simpleList=" + simpleList
				+ ", MapHavinList=" + MapHavinList + ", listHavingMap=" + listHavingMap + ", mapHavingMapHavingList="
				+ mapHavingMapHavingList + ", listhavingMapHavingList=" + listhavingMapHavingList + "]";
	}
}

public class JsonSampleCode {
	public static void main(String[] args)
			throws FileNotFoundException, IOException, JsonSyntaxException, ClassNotFoundException {
		JsonSimpleBean jsonSimpleBean = null;
		String jsonSimpleString = null;
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;

		ObjectInputStream ois = null;
		FileInputStream fis = null;

		JsonObject jsonObject = null;

		// Case 1 Starts
		jsonSimpleBean = new JsonSimpleBean(1, "Dushyant");
		jsonSimpleString = new Gson().toJson(jsonSimpleBean);
		System.out.println(jsonSimpleString);

		fos = new FileOutputStream("/home/sapra/json.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(jsonSimpleString);
		fos.close();
		oos.close();

		fis = new FileInputStream("/home/sapra/json.txt");
		ois = new ObjectInputStream(fis);
		jsonObject = new JsonParser().parse((String) ois.readObject()).getAsJsonObject();
		fis.close();
		ois.close();
		// System.out.println("\nJsonObject : " + jsonObject);
		System.out.format("Id %d, String %s : ", jsonObject.get("id").getAsInt(), jsonObject.get("name").getAsString());
		System.out.println("\n");
		// Case 1 Ends

		// Case 2 Starts
		Map<Integer, Integer> simpleMap = new HashMap<Integer, Integer>();
		simpleMap.put(1, 1);
		simpleMap.put(2, 2);
		simpleMap.put(3, 3);
		simpleMap.put(4, 4);

		jsonSimpleBean = new JsonSimpleBean(1, "Dushyant", simpleMap);
		jsonSimpleString = new Gson().toJson(jsonSimpleBean);
		System.out.println(jsonSimpleString);

		fos = new FileOutputStream("/home/sapra/json.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(jsonSimpleString);
		fos.close();
		oos.close();

		fis = new FileInputStream("/home/sapra/json.txt");
		ois = new ObjectInputStream(fis);
		jsonObject = new JsonParser().parse((String) ois.readObject()).getAsJsonObject();
		fis.close();
		ois.close();
		// System.out.println("\nJsonObject : " + jsonObject);
		simpleMap = new Gson().fromJson(jsonObject.get("simpleMap"), new TypeToken<Map<Integer, Integer>>() {
		}.getType());
		System.out.println("Map<Integer, Integer> : " + simpleMap);
		System.out.println();
		// Case 2 Ends

		// Case 3 Starts
		List<String> simpleList = Arrays.asList("1", "2", "3", "4");

		jsonSimpleBean = new JsonSimpleBean(1, "Dushyant", simpleMap, simpleList);
		jsonSimpleString = new Gson().toJson(jsonSimpleBean);
		System.out.println(jsonSimpleString);

		fos = new FileOutputStream("/home/sapra/json.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(jsonSimpleString);
		fos.close();
		oos.close();

		fis = new FileInputStream("/home/sapra/json.txt");
		ois = new ObjectInputStream(fis);
		jsonObject = new JsonParser().parse((String) ois.readObject()).getAsJsonObject();
		fis.close();
		ois.close();
		// System.out.println("\nJsonObject : " + jsonObject);

		simpleList = new Gson().fromJson(jsonObject.get("simpleList"), new TypeToken<List<String>>() {
		}.getType());
		System.out.println("List<String> : " + simpleList);
		System.out.println();
		// Case 3 Ends

		// Case 4 Starts
		Map<Integer, List<Integer>> mapHavingList = new HashMap<Integer, List<Integer>>();
		mapHavingList.put(1, Arrays.asList(1, 2, 3));
		mapHavingList.put(2, Arrays.asList(2, 3, 4));
		mapHavingList.put(3, Arrays.asList(3, 4, 5));

		jsonSimpleBean = new JsonSimpleBean(1, "Dushyant", simpleMap, simpleList, mapHavingList);
		jsonSimpleString = new Gson().toJson(jsonSimpleBean);
		System.out.println(jsonSimpleString);

		fos = new FileOutputStream("/home/sapra/json.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(jsonSimpleString);
		fos.close();
		oos.close();

		fis = new FileInputStream("/home/sapra/json.txt");
		ois = new ObjectInputStream(fis);
		jsonObject = new JsonParser().parse((String) ois.readObject()).getAsJsonObject();
		fis.close();
		ois.close();
		// System.out.println("\nJsonObject : " + jsonObject);
		mapHavingList = new Gson().fromJson(jsonObject.get("MapHavinList"),
				new TypeToken<Map<Integer, List<Integer>>>() {
				}.getType());
		System.out.println("Map<Integer, List<Integer>> : " + mapHavingList);
		System.out.println();
		// Case 4 Ends

		// Case 5 Starts
		List<Map<Integer, Integer>> listHavingMap = new ArrayList<Map<Integer, Integer>>();
		Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
		tempMap.put(1, 1);
		tempMap.put(2, 2);
		listHavingMap.add(tempMap);

		tempMap = new HashMap<Integer, Integer>();
		tempMap.put(3, 3);
		tempMap.put(4, 4);
		listHavingMap.add(tempMap);

		jsonSimpleBean = new JsonSimpleBean(1, "Dushyant", simpleMap, simpleList, mapHavingList, listHavingMap);
		jsonSimpleString = new Gson().toJson(jsonSimpleBean);
		System.out.println(jsonSimpleString);

		fos = new FileOutputStream("/home/sapra/json.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(jsonSimpleString);
		fos.close();
		oos.close();

		fis = new FileInputStream("/home/sapra/json.txt");
		ois = new ObjectInputStream(fis);
		jsonObject = new JsonParser().parse((String) ois.readObject()).getAsJsonObject();
		fis.close();
		ois.close();
		// System.out.println("\nJsonObject : " + jsonObject);
		listHavingMap = new Gson().fromJson(jsonObject.get("listHavingMap"),
				new TypeToken<List<Map<Integer, Integer>>>() {
				}.getType());
		System.out.println("List<Map<Integer, Integer>> : " + listHavingMap);
		System.out.println();
		// Case 5 Ends

		// Case 6 Starts
		Map<Integer, Map<Integer, List<Integer>>> mapHavingMapHavingList = new HashMap<Integer, Map<Integer, List<Integer>>>();
		Map<Integer, List<Integer>> tempMap1 = new HashMap<Integer, List<Integer>>();
		tempMap1.put(1, Arrays.asList(1, 2, 3));
		tempMap1.put(2, Arrays.asList(2, 3, 4));
		mapHavingMapHavingList.put(1, tempMap1);

		tempMap1 = new HashMap<Integer, List<Integer>>();
		tempMap1.put(3, Arrays.asList(3, 4, 5));
		tempMap1.put(4, Arrays.asList(4, 5, 6));
		mapHavingMapHavingList.put(2, tempMap1);

		jsonSimpleBean = new JsonSimpleBean(1, "Dushyant", simpleMap, simpleList, mapHavingList, listHavingMap,
				mapHavingMapHavingList);
		jsonSimpleString = new Gson().toJson(jsonSimpleBean);
		System.out.println(jsonSimpleString);

		fos = new FileOutputStream("/home/sapra/json.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(jsonSimpleString);
		fos.close();
		oos.close();

		fis = new FileInputStream("/home/sapra/json.txt");
		ois = new ObjectInputStream(fis);
		jsonObject = new JsonParser().parse((String) ois.readObject()).getAsJsonObject();
		fis.close();
		ois.close();
		// System.out.println("\nJsonObject : " + jsonObject);
		mapHavingMapHavingList = new Gson().fromJson(jsonObject.get("mapHavingMapHavingList"),
				new TypeToken<Map<Integer, Map<Integer, List<Integer>>>>() {
				}.getType());
		System.out.println("Map<Integer, Map<Integer, List<Integer>>> : " + mapHavingMapHavingList);
		System.out.println();
		// Case 6 Ends

		// Case 7 Starts
		List<Map<Integer, List<Integer>>> listhavingMapHavingList = new ArrayList<Map<Integer, List<Integer>>>();
		tempMap1 = new HashMap<Integer, List<Integer>>();
		tempMap1.put(1, Arrays.asList(1, 2, 3));
		tempMap1.put(2, Arrays.asList(2, 3, 4));
		listhavingMapHavingList.add(tempMap1);

		tempMap1 = new HashMap<Integer, List<Integer>>();
		tempMap1.put(3, Arrays.asList(3, 4, 5));
		tempMap1.put(4, Arrays.asList(4, 5, 6));
		listhavingMapHavingList.add(tempMap1);

		jsonSimpleBean = new JsonSimpleBean(1, "Dushyant", simpleMap, simpleList, mapHavingList, listHavingMap,
				mapHavingMapHavingList, listhavingMapHavingList);
		jsonSimpleString = new Gson().toJson(jsonSimpleBean);
		System.out.println(jsonSimpleString);

		fos = new FileOutputStream("/home/sapra/json.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(jsonSimpleString);
		fos.close();
		oos.close();

		fis = new FileInputStream("/home/sapra/json.txt");
		ois = new ObjectInputStream(fis);
		jsonObject = new JsonParser().parse((String) ois.readObject()).getAsJsonObject();
		fis.close();
		ois.close();
		// System.out.println("\nJsonObject : " + jsonObject);
		listhavingMapHavingList = new Gson().fromJson(jsonObject.get("listhavingMapHavingList"),
				new TypeToken<List<Map<Integer, List<Integer>>>>() {
				}.getType());
		System.out.println("List<Map<Integer, List<Integer>>> : " + listhavingMapHavingList);
		System.out.println();

		// Case 8 Starts
		jsonObject = new JsonObject();
		jsonObject.addProperty("map", new Gson().toJson(new HashMap<Integer, Integer>()));
		System.out.println(jsonObject);

		JsonArray jsonArray = new JsonArray();
		jsonArray.add("asdasd");
		jsonArray.add(new Gson().toJson(Arrays.asList(1, 2, 3, 4)));
		jsonArray.add("ASASASAS");
		jsonArray.add(new JsonParser().parse("{\"aaa\" : \"asdasdasdasdas\"}").getAsJsonObject());
		System.out.println(jsonArray);

		String str = "[\"asdasd\", \"qweqweqwe\"]";
		jsonArray = new JsonParser().parse(str).getAsJsonArray();
		System.out.println(jsonArray);
	}
}
