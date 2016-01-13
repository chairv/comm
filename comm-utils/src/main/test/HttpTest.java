import com.squareup.okhttp.*;
import org.junit.Test;
import utils.HttpUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

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
	public void post() throws IOException {
		String url = "https://api.baidu.com/sem/common/HolmesLoginService";
		System.out
				.println(HttpUtils
						.post(url,
								"{\"username\":\"Jenny123128\",\"token\":\"95fa0a5b22c88492e754a38f461022cb\",\"request\":{\"osVersion\":\"Windows\",\"deviceType\":\"pad\",\"clientVersion\":\"1.0\"},\"uuid\":\"d745464b0b794275837343e05a0df4ef\",\"functionName\":\"preLogin\"}"));
	}

	@Test
	public void mediaPost() throws IOException {
		String postBody = "{\"username\":\"Jenny123128\",\"token\":\"95fa0a5b22c88492e754a38f461022cb\",\"request\":{\"osVersion\":\"Windows\",\"deviceType\":\"pad\",\"clientVersion\":\"1.0\"},\"uuid\":\"d745464b0b794275837343e05a0df4ef\",\"functionName\":\"preLogin\"}";
		String url = "https://api.baidu.com/sem/common/HolmesLoginService";
		System.out.println(HttpUtils.post(url, MEDIA_TYPE_MARKDOWN, postBody));
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

	@Test
	public void tulingTest() throws IOException {
		String content = "天气";
		String url = "http://www.tuling123.com/openapi/api?key=11111111&info=";
		String param = "";
		try {
			param = url + URLEncoder.encode(content, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String rs = HttpUtils.get(param);
		System.out.println(rs);
	}

}
