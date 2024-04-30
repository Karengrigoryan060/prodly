package serives;

import config.BaseService;
import lombok.extern.log4j.Log4j2;
import pojos.content.UpdateContentParams;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
@Log4j2
public class ContentService extends BaseService {

    private static final String CONTENT_BY_PATH_URL = "/contents/{path}";

    private ContentService() {
    }

    public static Response getContent(String path, Map<String, String> queryParams) {
        log.info(String.format("Getting content for file: %s", path));
        RequestSpecification request = configRequestAPI();
        request.basePath(CONTENT_BY_PATH_URL.replace("{path}", path)).queryParams(queryParams);
        return get(request);
    }

    public static Response updateContent(String path, UpdateContentParams params) {
        log.info(String.format("Updating content for file: %s", path));
        RequestSpecification request = configRequestAPI();
        request.basePath(CONTENT_BY_PATH_URL.replace("{path}", path)).body(params);
        return put(request);
    }
}
