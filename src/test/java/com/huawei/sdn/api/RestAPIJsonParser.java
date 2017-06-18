package com.huawei.sdn.api;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

public class RestAPIJsonParser {
	@Test
	public void f() throws IOException {

		SwaggerParser sp = new SwaggerParser();
		Swagger sw = sp.read("d:/api.json");
		System.out.println(sw.getBasePath());
		System.out.println(sw.getHost());
		System.out.println(sw.getPaths());
		System.out.println("path处理");
		Map<String,Path> paths = sw.getPaths();
		for (Map.Entry<String, Path> entry : paths.entrySet()) {  
			  
		    System.out.println("Key = " + entry.getKey());  
		    Path path = entry.getValue();
		    System.out.println(path.getOperations().toString());
		  
		}  
		
		System.out.println(sw.getBasePath());
		System.out.println(sw.getBasePath());
		System.out.println(sw.getBasePath());
	}
}
