package com.huawei.sdn.api.config;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableSwagger2
public class Swagger2 {

   /* @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.huawei.sdn.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
    	
    	Contact contact=new Contact("黃璐 00169347",
    	          "http://rnd-soliv.huawei.com","lu.huang@huawei.com");
    	
        return new ApiInfoBuilder()
                .title("接口变更检测平台AI")
                .description("本文档提供对平台接口的描述已经测试功能")
                .version("1.0.0")
                .contact(contact)
                .build();
    }*/

}
