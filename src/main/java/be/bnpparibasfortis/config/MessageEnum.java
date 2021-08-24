package be.bnpparibasfortis.config;

public enum MessageEnum {

	MSG01("MSG01");

	private String key;

	MessageEnum(String key) {
		this.key = key;
	}

	public final String getKey() {
		return this.key;
	}
}
