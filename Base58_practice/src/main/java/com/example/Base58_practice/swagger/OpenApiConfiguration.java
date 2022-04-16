package com.example.Base58_practice.swagger;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration
{
    public static final String API_NODE_PROFILE = "Node Profile";
    public static final String API_NODE_PROFILE_COMMANDS = "Node Profile Commands";
    public static final String API_NODE_PROFILE_TELEMETRY = "Node Profile Telemetry";
    public static final String API_NODE_PROFILE_ALARM_THRESHOLDS = "Telemetry Alarm Thresholds";

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("User Management")
                                .description("User Management")
                                .version("1.0")
                                .license(
                                        new License()
                                                .name("Apache 2.0")
                                                .url("http://www.apache.org/licenses/LICENSE-2.0")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("User Profile Management")
                .pathsToMatch("/node-profile/**")
                .build();
    }
}
