package com.javaSampleCode.cloning;

import java.io.Serializable;

public class EmployeeBean implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private AddressBean addressBean;

	public EmployeeBean() {
		super();
	}

	public EmployeeBean(String name, AddressBean addressBean) {
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
		EmployeeBean emp = (EmployeeBean) super.clone();
		emp.setAddressBean(new AddressBean());
		emp.getAddressBean().setCityName(getAddressBean().getCityName());
		emp.getAddressBean().setStateName(getAddressBean().getStateName());
		return emp;
	}

	@Override
	public String toString() {
		return "EmployeeBean [name=" + name + ", addressBean=" + addressBean + "]";
	}
}