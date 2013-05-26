package idcard;

public class IDCardWithSerial extends IDCard {
	private final int serial;
	IDCardWithSerial(String owner, int serial) {
		super(owner);
		this.serial = serial;
	}
}
