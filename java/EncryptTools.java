

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 加密工具
 */

public class EncryptTools {

	/**
	 * 加密
	 * @param passWord
	 *            需要的密码
	 * @return 返回加密后的数据串
	 */
	public static Object getEncryptedPassword(String passWord) {
		return new SimpleHash("SHA-1", passWord, passWord + reverse(passWord));
	}

	public static String reverse(String valStr) {
		return new StringBuffer(valStr).reverse().toString();
	}

	// Base64加密
	public static String getBASE64Str(String s) {
		String result = "";
		byte[] encodeBase64;
		try {
			encodeBase64 = Base64.encodeBase64(s.getBytes("UTF-8"));
			result = new String(encodeBase64);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

}
