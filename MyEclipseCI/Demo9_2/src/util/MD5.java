package util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class MD5 {
	public static void main(String[] args) {
		System.out.println(encrypt("abc"));
	}
	//MD5����
	public static String encrypt(String oldStr) {
		//����1����Ҫ���ܵ��ַ���ת��Ϊ�ַ�����
		byte[] oldBytes = oldStr.getBytes();
		//����2������MessageDigest�������øö����digest������ɼ��ܣ������ֽ�����
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");//ʵ������ʹ��MD5
			byte[] newBytes = md.digest(oldBytes);
			//����3�����ֽ�����ͨ��base64�㷨ת�ɵȳ��ַ���
			BASE64Encoder encoder = new BASE64Encoder();
			String newStr = encoder.encode(newBytes);
			return newStr;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}

	}
}