package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.PostListSteps;

@RunWith(SerenityRunner.class)
public class PostListTests {
    @Steps
    PostListSteps postListSteps;

    @Test
    public void verifyThatWeCanFindFirstPost() {
        postListSteps.getPostById("1");
        postListSteps.getIsExecutedSuccesfully();
        postListSteps.iShouldFindPostByTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }

    @Test
    public void verifyThatWeCanFindSecondPost(){
        postListSteps.getPostById("2");
        postListSteps.getIsExecutedSuccesfully();
        postListSteps.iShouldFindPostByTitle("qui est esse");
    }

    @Test
    public void verifyThatWeCanFindThirdPost(){
        postListSteps.getPostById("3");
        postListSteps.getIsExecutedSuccesfully();
        postListSteps.iShouldFindPostByTitle("ea molestias quasi exercitationem repellat qui ipsa sit aut");
    }

    @Test
    public void verifyThatWeCanCreateUser(){
        postListSteps.iCanCreatePost("Ogogo", "Egege", 1);
    }
}