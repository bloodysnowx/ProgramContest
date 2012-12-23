package idcard;

import framework.Product;

public class IDCard extends Product {
	IDCard(String owner) {
		super();
		System.out.println(owner + "'s card will be made.");
		this.owner = owner;
	}
	private final String owner;
	@Override
	public void use() {
		System.out.println(owner + "'s card will be used.");
	}
	String getOwner() {
		return owner;
	}
}
