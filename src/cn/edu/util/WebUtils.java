package cn.edu.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author wangfang
 * 把一些公共方法放在这里
 */
public class WebUtils {
	
	/**
	 * 生成id
	 * @param idHead id开头字母
	 * @return
	 */
	public static String makeId(String idHead){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		StringBuffer id = new StringBuffer(idHead);
		id.append("-").append(sdf.format(new Date())).append("-").append(getRandomString(6)); 
		return id.toString().toUpperCase();
	}
	
	/**
	 * 生成任意长度的字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		String base = UUID.randomUUID().toString().replaceAll("-", "");
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(makeId("u"));
	}
	
}
