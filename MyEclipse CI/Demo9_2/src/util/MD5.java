package util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class MD5 {
	public static void main(String[] args) {
		System.out.println(encrypt("abc"));
	}
	//MD5加密
	public static String encrypt(String oldStr) {
		//步骤1：把要加密的字符串转化为字符数组
		byte[] oldBytes = oldStr.getBytes();
		//步骤2：调用MessageDigest对象，利用该对象的digest方法完成加密，返回字节数组
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");//实例化，使用MD5
			byte[] newBytes = md.digest(oldBytes);
			//步骤3：将字节数组通过base64算法转成等长字符串
			BASE64Encoder encoder = new BASE64Encoder();
			String newStr = encoder.encode(newBytes);
			return newStr;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}

	}
}