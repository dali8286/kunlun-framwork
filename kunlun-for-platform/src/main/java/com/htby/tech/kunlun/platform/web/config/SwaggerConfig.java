package com.htby.tech.kunlun.platform.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author renhao
 * @date 2019/10/18
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Value(value = "${swagger.enabled}")
    private Boolean swaggerEnabled;

    public static List<String> URIS = Arrays.asList("/swagger-ui.html**", "/swagger-resources/**", "/v2/api-docs/**", "/webjars/**");

    @Profile({"local", "dev"})
    @Bean
    public Docket createRestApi() {
//        ParameterBuilder ticketPar = new ParameterBuilder();
//        List<Parameter> parameters = new ArrayList<>();
//        ticketPar.name("hscms-token").description("认证令牌").modelRef(new ModelRef("string")).parameterType("header").required(true).order(Integer.MAX_VALUE).build();
//        parameters.add(ticketPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .pathMapping("/")
                .groupName("v1.0.0")
//                .globalOperationParameters(parameters)
                .enable(swaggerEnabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.htby.tech.kunlun.platform"))
                .paths(PathSelectors.any())
                .build().apiInfo(restApiInfo());
    }

    private ApiInfo restApiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .version("v1.0.0")
                .build();
    }

//    @Profile({"local", "dev"})
//    @Bean
//    public Docket createErrorCode() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .genericModelSubstitutes(ResponseEntity.class)
//                .useDefaultResponseMessages(true)
//                .forCodeGeneration(false)
//                .pathMapping("/")
//                .groupName("公用错误码")
//                .enable(swaggerEnabled)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("none"))
//                .paths(PathSelectors.any())
//                .build().apiInfo(errorCodeApiInfo());
//    }

//    private ApiInfo errorCodeApiInfo() {
//        return new ApiInfoBuilder()
//                .title("华师宣传部CMS-公用错误码")
//                .description(
//                        "-1\t|\t系统繁忙,稍后重试\n" +
//                        "0\t|\t操作成功\n" +
//                        "100\t|\t验签错误,操作失败\n" +
//                        "200\t|\t参数错误,操作失败\n" +
//                        "210\t|\t用户名与密码不匹配,请重试\n" +
//                        "211\t|\t登录验证码错误,请重试\n" +
//                        "900\t|\ttoken失效,及时刷新\n" +
//                        "901\t|\ttoken失效,重新登录"
//                )
//                .version("公用错误码")
//                .build();
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
