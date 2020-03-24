package br.com.livelo.login.util;

import java.util.Collection;

public final class ValidateUtil {

	private ValidateUtil() {
	}

	public static boolean isNullOrEmpty(final Collection<?> c) {
		return c == null || c.isEmpty();
	}
}
