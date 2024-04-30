package config;

import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class BaseService {

    protected static Response get(RequestSpecification requestSpecification) {
        return requestSpecification.get();
    }

    protected static Response post(RequestSpecification requestSpecification) {
        return requestSpecification.post();
    }

    protected static Response put(RequestSpecification requestSpecification) {
        return requestSpecification.put();
    }

    @SneakyThrows
    protected static RequestSpecification configRequestAPI() {
        return given()
                .config(RestAssured.config().objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)))
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .headers(
                        Map.of("X-GitHub-Api-Version", ConfigurationProperties.API_VERSION,
                                "Authorization", "Bearer " + ConfigurationProperties.API_TOKEN,
                                "Accept", "application/vnd.github+json")
                )
                .baseUri(ConfigurationProperties.getFullURL())
                .relaxedHTTPSValidation()
                .log()
                .all();
    }
}
