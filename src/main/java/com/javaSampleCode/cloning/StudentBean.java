package com.javaSampleCode.cloning;

public class StudentBean implements Cloneable {
	private String name;
	private AddressBean addressBean;

	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentBean(String name, AddressBean addressBean) {
		super();
		this.name = name;
		this.addressBean = addressBean;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressBean getAddressBean() {
		return addressBean;
	}

	public void setAddressBean(AddressBean addressBean) {
		this.addressBean = addressBean;
	}

	public Object clone() throws CloneNotSupportedException {
		return (StudentBean) super.clone();
	}

	@Override
	public String toString() {
		return "StudentBean [name=" + name + ", addressBean=" + addressBean + "]";
	}

}
