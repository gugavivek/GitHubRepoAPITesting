package client; 
import io.restassured.RestAssured; 
import io.restassured.response.Response; 
import pojo.Issue; 
import pojo.Repo; 
public class GitHubClient { 
  public Response createRepo(Repo repo) { return RestAssured.given().body(repo).post("/user/repos"); } 
  public Response getRepo(String owner, String repoName) { return RestAssured.get("/repos/" + owner + "/" + repoName); } 
  public Response deleteRepo(String owner, String repoName) { return RestAssured.delete("/repos/" + owner + "/" + repoName); } 
  public Response createIssue(String owner, String repoName, Issue issue) { return RestAssured.given().body(issue).post("/repos/" + owner + "/" + repoName + "/issues"); } 
} 
