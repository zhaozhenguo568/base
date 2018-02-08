package cn.cisdom.base.swgger;

import cn.cisdom.base.entity.UserEntity;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhenglee on 2017/7/11.
 */
@Configuration
@EnableSwagger2
@SwaggerDefinition(
        securityDefinition = @SecurityDefinition(
                apiKeyAuthDefintions = {
                        @ApiKeyAuthDefinition(key="token",name = "auth",in= ApiKeyAuthDefinition.ApiKeyLocation.HEADER)
                }
        )
)
public class SwaggerConfig {

    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了 （访问页面就可以看到效果了）
     *
     */
    @Bean
    public Docket testApi() {
//        final List<SecurityContext> securityContexts = Lists.newArrayList();
//        final List<AuthorizationScope> scopes=Lists.newArrayList();
//        AuthorizationScope scope =
//        securityContexts.add(new SecurityContext())
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("Content-Type").defaultValue("application/x-www-form-urlencoded; charset=utf-8").description("Content-Type").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(tokenPar.build());
//        tokenPar.name("token").description("token").defaultValue("").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.cisdom.base.api"))
                .paths(PathSelectors.any()).build().securitySchemes(securitySchemes()).ignoredParameterTypes(UserEntity.class);
//                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("自助建站系统API", // 大标题
                "自助建站系统API", // 小标题
                "1.0", // 版本
                "NO terms of service", new Contact("zhenglee","","18368053@qq.com"), // 作者
                "有问题,请点我", // 链接显示文字
                "http://wpa.qq.com/msgrd?v=3&uin=18368053&site=qq&menu=yes"// 链接
        );

        return apiInfo;
    }

    private ApiKey apiKey(){
        return new ApiKey("mykey", "key", "header");
    }

    private List<? extends SecurityScheme> securitySchemes() {
        List<ApiKey> authorizationTypes = Arrays.asList(new ApiKey("token", "token", "header"));
        return authorizationTypes;
    }


}
