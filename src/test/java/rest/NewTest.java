package rest;

import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void testOutput() {
	  ProcessRequest conn=new ProcessRequest();
	  //conn.processRestApi("http://jsonplaceholder.typicode.com/users", "GET", "json");
	  conn.processRestApi("https://api.github.com/users/mralexgray/repos", "GET", "json");
	  System.out.println(conn.checkData("AFIncrementalStore"));
	//  System.out.println(conn.checkData("GlennaReichert"));
	  
  }
}
