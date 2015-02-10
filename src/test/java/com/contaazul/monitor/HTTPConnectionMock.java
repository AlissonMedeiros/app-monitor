package com.contaazul.monitor;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class HTTPConnectionMock {

	public static HttpURLConnection mockHTTPConnection(final int code,
			final InputStream in) {
		return new HttpURLConnection(null) {

			@Override
			public void disconnect() {

			}

			@Override
			public boolean usingProxy() {
				return false;
			}

			@Override
			public void connect() throws IOException {
				this.responseCode = code;
			}

			@Override
			public InputStream getInputStream() throws IOException {
				return in;
			}

		};
	}
}
