package helpers;

import config.BaseService;
import pojos.content.Content;
import serives.ContentService;

import java.util.Map;

public class ContentHelper extends BaseService {
    private ContentHelper() {
    }

    public static Content getContent(String path, String ref) {
        return ContentService.getContent(path, Map.of("ref", ref)).then().extract().as(Content.class);
    }
}
