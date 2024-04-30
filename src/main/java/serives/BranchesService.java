package serives;

import config.BaseService;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;
import pojos.branch.MergeBranchParams;

@Log4j2
public class BranchesService extends BaseService {

    private static final String MERGE_BRANCH_URL = "/merges";

    private BranchesService() {
    }

    public static Response mergeBranches(String base, String head, String commitMessage) {
        log.info(String.format("Merging branch %s into %s with comment %s", base, head, commitMessage));
        RequestSpecification request = configRequestAPI();
        request.basePath(MERGE_BRANCH_URL)
                .body(new MergeBranchParams(base, head, commitMessage));
        return post(request);
    }
}
