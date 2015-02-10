package com.contaazul.monitor;

import static com.contaazul.monitor.HTTPConnectionMock.mockHTTPConnection;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.junit.Test;

import com.google.common.io.CharStreams;

public class SendPingURLTest {

	@Test
	public void pingGETInURL() throws IOException {
		SendPingURL sendPingURL = new SendPingURL();

		HttpURLConnection conconnection = mockHTTPConnection(200,
				new ByteArrayInputStream("TEST".getBytes()));
		sendPingURL.send(conconnection, "GET");

		assertThat(conconnection, notNullValue());
		assertThat(conconnection.getResponseCode(), equalTo(200));
		assertThat(conconnection.getRequestMethod(), equalTo("GET"));
		assertThat(CharStreams.toString(new InputStreamReader(conconnection
				.getInputStream())), equalTo("TEST"));

	}

	@Test(expected = MalformedURLException.class)
	public void pingInvalidURL() throws IOException {
		SendPingURL sendPingURL = new SendPingURL();
		sendPingURL.createConnection("*&*&9");
	}

	@Test
	public void pingValidURL() throws IOException {
		SendPingURL sendPingURL = new SendPingURL();
		sendPingURL.createConnection("https://www.contaazul.com.br");
	}

}
