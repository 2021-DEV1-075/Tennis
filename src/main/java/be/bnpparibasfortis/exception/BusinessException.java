package be.bnpparibasfortis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import be.bnpparibasfortis.config.MessageEnum;
import be.bnpparibasfortis.config.MessageSource;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class BusinessException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static String buildMessage(final MessageEnum messageKey) {
		String key = messageKey.getKey();
		StringBuilder builder = new StringBuilder(key);
		builder.append(" [").append(MessageSource.get().message(key)).append("]");
		return builder.toString();
	}

	public BusinessException(final MessageEnum messageKey) {
		super(BusinessException.buildMessage(messageKey));
	}

	public BusinessException(final String msg) {
		super(msg);
	}
}
