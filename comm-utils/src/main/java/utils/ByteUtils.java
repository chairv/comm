package utils;

/**
 * Created by tancw on 2015/11/11.
 */
public class ByteUtils {

    /**
     *转十六进制
     * @param digest
     * @return
     */
    public static String byte2Hex(byte[] digest) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < digest.length; i++) {
            tmp = (Integer.toHexString(digest[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}
