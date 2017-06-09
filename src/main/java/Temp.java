import java.util.ArrayList;
import java.util.List;

enum ABC {
	KEY_ENUM(new ArrayList<String>()), VALUE_ENUM(new ArrayList<String>());

	private final List<String> list;

	private ABC(List<String> list) {
		this.list = list;
	}

	public void setKeyValue(String key) {
		KEY_ENUM.list.add(key);
	}

	public void setValueValue(String value) {
		VALUE_ENUM.list.add(value);
	}

	public List<String> getKeyENUMList() {
		return KEY_ENUM.list;
	}

	public List<String> getValueENUMList() {
		return VALUE_ENUM.list;
	}

}

public class Temp {
	public static void main(String[] args) {
		ABC.KEY_ENUM.setKeyValue("File 1");
		ABC.KEY_ENUM.setValueValue("Value 1");

		for (String str : ABC.KEY_ENUM.getKeyENUMList()) {
			System.out.println(str);
		}

		for (String str : ABC.VALUE_ENUM.getValueENUMList()) {
			System.out.println(str);
		}
	}
}