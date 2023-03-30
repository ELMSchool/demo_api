package school.elm.demo_api.endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@PostMapping("/sayWhat")
	public ResponseEntity<String> sayWhat(@RequestBody String what) {
		if (what.equalsIgnoreCase("what")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( standardMessage() );
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body( parametrizedMessage(what) );
		}
	}
	
	public static String standardMessage() {
		return "Anything but WHAT...";
	}
	public static String parametrizedMessage(String str) {
		return "Say " + str + "!!!";
	}
	
}
