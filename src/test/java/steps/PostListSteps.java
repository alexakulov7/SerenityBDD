package steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.is;

public class PostListSteps {
    private String POSTS = "http://jsonplaceholder.typicode.com/posts/";
    private Response response;
    private Response request;

    class JSONObject{
        int userId;
        String title;
        String body;

        public JSONObject(int userId, String title, String body) {
            this.userId = userId;
            this.title = title;
            this.body = body;
        }
    }

    @Step
    public void getPostById(String id){
        response = SerenityRest.when().get(POSTS + id);
    }

    @Step
    public void getIsExecutedSuccesfully(){
        response.then().statusCode(200);
    }

    @Step("Пытаемся найти заметку с названием {0}")
    public void iShouldFindPostByTitle(String title){
        response.then().body("title", is(title));
    }

    @Step("Пытаемся создать заметку с названием {0} и контентом {1}")
    public void iCanCreatePost(String title, String body, int userId){
        JSONObject jsonObj = new JSONObject(userId, title, body);
        SerenityRest.given()
                .contentType("application/json")
                //.parameters("title", title, "body", body, "userId", userId)
                .body(jsonObj)
                .when().post(POSTS)
                .then()// .extract().body();
                .body("title", is(title))
                .and()
                .body("body", is(body));
    }
}