package tests; 
import base.BaseTest; 
import client.GitHubClient; 
import io.restassured.response.Response; 
import org.testng.Assert; 
import org.testng.annotations.Test; 
import pojo.Repo; 
import utils.ConfigReader; 
public class RepoTests extends BaseTest { 
  GitHubClient client = new GitHubClient(); 
  String username = ConfigReader.get("username"); 
  String repoName = "automation-repo2";
  @Test(priority=1) 
  public void testCreateRepo() { 
    Repo repo = new Repo(repoName, "Created via API automation", false); 
    Response response = client.createRepo(repo); 
    Assert.assertEquals(response.statusCode(), 201); 
  } 
  @Test(priority=2) 
  public void testGetRepo() { 
    Response response = client.getRepo(username, repoName); 
    Assert.assertEquals(response.statusCode(), 200);
      String name = response.jsonPath().getString("name");
      String fullName = response.jsonPath().getString("full_name");
      boolean isPrivate = response.jsonPath().getBoolean("private");
      String owner = response.jsonPath().getString("owner.login");
      String htmlUrl = response.jsonPath().getString("html_url");
      String createdAt = response.jsonPath().getString("created_at");

      System.out.println("Repo Name: " + name);
      System.out.println("Full Name: " + fullName);
      System.out.println("Private: " + isPrivate);
      System.out.println("Owner: " + owner);
      System.out.println("URL: " + htmlUrl);
      System.out.println("Created At: " + createdAt);
  } 
  @Test(priority=3) 
  public void testDeleteRepo() { 
    Response response = client.deleteRepo(username, repoName); 
    Assert.assertEquals(response.statusCode(), 204); 
  } 
} 
