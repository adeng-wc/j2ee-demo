import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author caojingui
 * @since 2018/5/7 下午4:21
 */
public class Md5Utils {

    /**
     * Encodes a string 2 MD5
     *
     * @param str String to encode
     * @return Encoded String
     * @throws NoSuchAlgorithmException 异常
     */
    public static String crypt(String str) throws NoSuchAlgorithmException {
        StringBuilder hexString = new StringBuilder();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        byte[] hash = md.digest();
        for (byte aHash : hash) {
            if ((0xff & aHash) < 0x10) {
                hexString.append("0").append(Integer.toHexString((0xFF & aHash)));
            } else {
                hexString.append(Integer.toHexString(0xFF & aHash));
            }
        }
        return hexString.toString();
    }
}
