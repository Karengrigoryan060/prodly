package com.prodly;

import helpers.ContentHelper;
import pojos.Company;
import pojos.content.Committer;
import pojos.content.Content;
import pojos.content.UpdateContentParams;
import serives.BranchesService;
import serives.CompanyService;
import serives.ContentService;
import utils.Base64Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ApiTest {

    @Test
    public void functionalTest() {
        Company randomCompany = CompanyService.getRandomCompany();

        String baseBranch = "main";
        String secondBranch = "dev";
        String filePath = "test.csv";

//        Call GitHub to insert records into the CSV you created in main.
        Content content = ContentHelper.getContent(filePath, baseBranch);
        UpdateContentParams contentParams = UpdateContentParams
                .builder()
                .committer(new Committer("prodlyTest", "prodlyTest@gmail.com"))
                .sha(content.getSha())
                .content(Base64Utils.encode(randomCompany)).message("Testing")
                .build();
        ContentService.updateContent(filePath, contentParams).then().statusCode(200);

//        Call GitHub to merge main into your second branch.
        BranchesService.mergeBranches(secondBranch, baseBranch, "Test message").then().statusCode(201);

//        Call GitHub to get the records that are in the CSV that is located in both branches.
        Content contentBaseAfterUpdate = ContentHelper.getContent(filePath, baseBranch);
        Content contentSecondAfterUpdate = ContentHelper.getContent(filePath, secondBranch);

//        Assert new Company object have been saved into main branch.
        assertEquals(randomCompany.toString(), Base64Utils.decode(contentBaseAfterUpdate.getContent()), "Company data have not been saved in main branch");
//        Assert that all the fields contain the same values in both files.
        assertEquals(contentBaseAfterUpdate.getContent(), contentSecondAfterUpdate.getContent(), "Contents are not identical between branches");
    }
}
