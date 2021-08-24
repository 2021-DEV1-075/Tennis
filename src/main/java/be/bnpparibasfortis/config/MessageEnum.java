package be.bnpparibasfortis.config;

public enum MessageEnum {

	MSG01("MSG01"), MSG02("MSG02"), MSG03("MSG03"), MSG04("MSG04"), MSG05("MSG05"), ERR01("ERR01"), ERR02("ERR02"),
	ERR03("ERR03"), ERR04("ERR04");

	private String key;

	MessageEnum(String key) {
		this.key = key;
	}

	public final String getKey() {
		return this.key;
	}
}
