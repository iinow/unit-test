package com.ha.http;

import java.io.IOException;

public interface Http {
	String get(String url) throws IOException;
}
