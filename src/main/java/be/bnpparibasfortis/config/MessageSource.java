package be.bnpparibasfortis.config;

import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;

public class MessageSource {
	private static MessageSource INSTANCE;
	private static final ResourceBundleMessageSource messageSource;
	static {
		messageSource = new ResourceBundleMessageSource();
		MessageSource.messageSource.setBasenames("messages");
		MessageSource.messageSource.setDefaultEncoding("UTF-8");
		MessageSource.messageSource.setDefaultLocale(Locale.ENGLISH);
	}

	public static MessageSource get() {
		if (MessageSource.INSTANCE == null)
			MessageSource.INSTANCE = new MessageSource();
		return MessageSource.INSTANCE;
	}

	public static ResourceBundleMessageSource getMessageSource() {
		return MessageSource.messageSource;
	}

	private MessageSource() {
	}

	public String message(String key) {
		return MessageSource.messageSource.getMessage(key, null, Locale.ENGLISH);
	}

	public String message(String key, Object... values) {
		return MessageSource.messageSource.getMessage(key, values, Locale.ENGLISH);
	}

	public String message(MessageEnum msgEnum, Object... values) {
		return MessageSource.messageSource.getMessage(msgEnum.getKey(), values, Locale.ENGLISH);
	}

}
