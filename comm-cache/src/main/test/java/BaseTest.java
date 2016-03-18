import com.comm.cache.CacheUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;

import java.io.IOException;

/**
 * Created by tancw on 2016/3/18.
 */
public class BaseTest {

	public static void main(String[] args) throws IOException {
		XMemcachedClientBuilder xMemcachedClientBuilder = new XMemcachedClientBuilder("120.24.94.225:11211");
		MemcachedClient client = xMemcachedClientBuilder.build();
		CacheUtils.setMemclient(client);
//        CacheUtils.add("test","value",7200);
		System.out.println(CacheUtils.get("test"));
	}
}
