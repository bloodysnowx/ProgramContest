package idcard;

import java.util.ArrayList;
import java.util.List;

import framework.Factory;
import framework.Product;

public class IDCardFactory extends Factory {
	private final List<String> owners = new ArrayList<String>();
	
	@Override
	protected void registerProduct(Product p) {
		owners.add(((IDCard)p).getOwner());
	}

	@Override
	protected Product createProduct(String owner) {
		return new IDCard(owner);
	}

	public List<String> getOwners() {
		return owners;
	}
}
