import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Created by tancw on 2016/1/11.
 */
public class EncryUtils {
	@Test
	public void test() {
		String ec = DigestUtils.md5Hex("show@");
		System.out.println(ec);
	}
}
