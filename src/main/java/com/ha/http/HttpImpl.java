package com.ha.http;

import java.io.IOException;

import org.springframework.http.HttpEntity;

public class HttpImpl implements Http {

	@Override
	public String get(String url) throws IOException {
//		CloseableHttpClient client = HttpClients.createDefault();
//		HttpGet request = new HttpGet(url);
//		CloseableHttpResponse response = client.execute(request);
		try {
//			HttpEntity entity = response.getEntity();
//			return EntityUtils.toString(entity);
			return "";
		} finally {
//			response.close();
		}
	}
}
