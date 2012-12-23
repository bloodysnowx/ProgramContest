package idcard;

import java.util.ArrayList;
import java.util.List;

import framework.Product;

public class IDCardWithSerialFactory extends IDCardFactory {
	private final List<String> serialOwnerList = new ArrayList<String>();
	@Override
	protected Product createProduct(String owner) {
		IDCardWithSerial p = new IDCardWithSerial(owner, serialOwnerList.size()); 
		serialOwnerList.add(owner);
		return p;
	}
	public void printList() {
		for(int i = 0; i < serialOwnerList.size(); ++i) {
			System.out.println(i + " : " + serialOwnerList.get(i));
		}
	}
}
