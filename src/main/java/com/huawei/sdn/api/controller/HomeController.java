/**
 * 
 */
package com.huawei.sdn.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huanglu
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
}
