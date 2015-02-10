package com.contaazul.monitor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.junit.Test;

public class SendPingURLTestIT {

	@Test
	public void pingContaAzul() throws MalformedURLException, IOException {
		SendPingURL pingURL = new SendPingURL();
		HttpURLConnection connection = pingURL
				.createConnection("https://www.contaazul.com.br");
		pingURL.send(connection, "GET");
		assertThat(connection.getResponseCode(), equalTo(200));
	}
}
