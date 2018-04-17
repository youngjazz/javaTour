package sparkJavaWeb;

import static spark.Spark.*;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/1/26 16:56
 */
public class FirstDemo {
	public static void main(String[] args) {
		get("/hello", (req, res) -> "FirstDemo");
		
		get("/hello/:name", (request, response) -> {
			return "Hello: " + request.params(":name");
		});
	}
	
	
	
}
