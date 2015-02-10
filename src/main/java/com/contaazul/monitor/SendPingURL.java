package com.contaazul.monitor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendPingURL {

	public void send(HttpURLConnection connection, String method)
			throws IOException {
		connection.setRequestMethod(method);
		connection.connect();
	}

	public HttpURLConnection createConnection(String string)
			throws MalformedURLException, IOException {
		return (HttpURLConnection) new URL(string).openConnection();
	}

}
