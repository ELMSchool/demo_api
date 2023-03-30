package school.elm.demo_api.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
}
