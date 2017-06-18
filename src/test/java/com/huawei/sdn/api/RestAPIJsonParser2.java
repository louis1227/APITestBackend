package com.huawei.sdn.api;

import java.io.IOException;

import org.testng.annotations.Test;

import com.huawei.sdn.api.utils.RestAPIParseException;
import com.huawei.sdn.api.utils.RestAPIUtils;

public class RestAPIJsonParser2 {
	@Test
	public void f() throws IOException {

		try {
			RestAPIUtils.compare("d:/api.json", "d:/api2.json");
		} catch (RestAPIParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
