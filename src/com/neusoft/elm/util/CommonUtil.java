package com.neusoft.elm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

	//��ȡϵͳ����
	public static String getCurDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
}