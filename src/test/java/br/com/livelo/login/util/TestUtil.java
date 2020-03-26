package br.com.livelo.login.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;

public class TestUtil {

	private TestUtil() {
		throw new AssertionError("Util class should not be instantiated.");
	}

	public static String readJsonFile(final String filePath) throws IOException {
		try {
			final File input = new ClassPathResource(filePath).getFile();
			return new String(Files.readAllBytes(Paths.get(input.getPath())));
		} catch (IOException e) {
			throw e;
		}
	}
}