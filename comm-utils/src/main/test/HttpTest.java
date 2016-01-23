import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tancw on 2015/9/15.
 */
public class HttpTest {
	private final static OkHttpClient client = new OkHttpClient();
	private final static MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("Content-Type:data/json;charset=UTF-8");

	@Test
	public void get() throws IOException {
		String url = "https://api.baidu.com/sem/common/HolmesLoginService";
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			Headers headers = response.headers();
			for (int i = 0; i < headers.size(); i++) {
				System.out.println(headers.name(i) + " : " + headers.value(i));
			}
			System.out.println(response.body().string());
		}
	}

	@Test
	public void asynGet() {
		String url = "https://www.baidu.com/";
		Request request = new Request.Builder().url(url).build();
		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Request request, IOException e) {
				e.printStackTrace();
			}

			@Override
			public void onResponse(Response response) throws IOException {
				if (!response.isSuccessful()) {
					throw new IOException("Unexpected code " + response);
				}
				Headers headers = response.headers();
				for (int i = 0; i < headers.size(); i++) {
					System.out.println(headers.name(i) + " : " + headers.value(i));
				}
				System.out.println(response.body().string());
			}
		});
		System.out.println("end");
	}

	@Test
	public void getHeadGet() throws IOException {
		String url = "https://www.baidu.com/";
		Request request = new Request.Builder().url(url).header("User-Agent", "OKHttp header.java")
				.addHeader("Accept", "application/json;q=0.5").addHeader("Accept", "application/vnd.github.v3+json").build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			System.out.println("Server : " + response.header("Server"));
			System.out.println("Date : " + response.header("Date"));
			System.out.println("Vary : " + response.header("Vary"));
			System.out.println(response.body().string());
		}
	}

	@Test
	public void simpleHttps() throws IOException {
		URL url = new URL("https://ebanks.gdb.com.cn/sperbank/perbankLogin.jsp");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		InputStream ins = con.getInputStream();
		InputStreamReader isr = new InputStreamReader(ins);
		BufferedReader in = new BufferedReader(isr);
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		in.close();
	}
}
