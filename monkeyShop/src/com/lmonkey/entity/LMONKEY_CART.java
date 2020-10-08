package com.lmonkey.entity;

public class LMONKEY_CART {
	private int CART_ID;
	private String CART_P_FILENAME;
	private String CART_P_NAME;
	private double CART_P_PRICE;
	private int CART_QUANTITY;
	private int CART_P_STOCK;
	private int CART_P_ID;
	private String CART_U_ID;
	private int CART_VALID;
	public LMONKEY_CART(int cART_ID, String cART_P_FILENAME, String cART_P_NAME, double cART_P_PRICE, int cART_QUANTITY,
			int cART_P_STOCK, int cART_P_ID, String cART_U_ID, int cART_VALID) {
		super();
		CART_ID = cART_ID;
		CART_P_FILENAME = cART_P_FILENAME;
		CART_P_NAME = cART_P_NAME;
		CART_P_PRICE = cART_P_PRICE;
		CART_QUANTITY = cART_QUANTITY;
		CART_P_STOCK = cART_P_STOCK;
		CART_P_ID = cART_P_ID;
		CART_U_ID = cART_U_ID;
		CART_VALID = cART_VALID;
	}
	public int getCART_ID() {
		return CART_ID;
	}
	public void setCART_ID(int cART_ID) {
		CART_ID = cART_ID;
	}
	public String getCART_P_FILENAME() {
		return CART_P_FILENAME;
	}
	public void setCART_P_FILENAME(String cART_P_FILENAME) {
		CART_P_FILENAME = cART_P_FILENAME;
	}
	public String getCART_P_NAME() {
		return CART_P_NAME;
	}
	public void setCART_P_NAME(String cART_P_NAME) {
		CART_P_NAME = cART_P_NAME;
	}
	public double getCART_P_PRICE() {
		return CART_P_PRICE;
	}
	public void setCART_P_PRICE(double cART_P_PRICE) {
		CART_P_PRICE = cART_P_PRICE;
	}
	public int getCART_QUANTITY() {
		return CART_QUANTITY;
	}
	public void setCART_QUANTITY(int cART_QUANTITY) {
		CART_QUANTITY = cART_QUANTITY;
	}
	public int getCART_P_STOCK() {
		return CART_P_STOCK;
	}
	public void setCART_P_STOCK(int cART_P_STOCK) {
		CART_P_STOCK = cART_P_STOCK;
	}
	public int getCART_P_ID() {
		return CART_P_ID;
	}
	public void setCART_P_ID(int cART_P_ID) {
		CART_P_ID = cART_P_ID;
	}
	public String getCART_U_ID() {
		return CART_U_ID;
	}
	public void setCART_U_ID(String cART_U_ID) {
		CART_U_ID = cART_U_ID;
	}
	public int getCART_VALID() {
		return CART_VALID;
	}
	public void setCART_VALID(int cART_VALID) {
		CART_VALID = cART_VALID;
	}
	
}
