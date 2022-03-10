package cavbotics.ntclient.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

	@GetMapping("/getnumber")
	public Number getnumber(@RequestParam(value = "key", defaultValue = "") String key, @RequestParam(value = "value", defaultValue = "") Number num) {
		if (key.length() > 0) System.out.println("No key provided");
		GetNumber updated = new GetNumber(key, num);
		return updated.getNumber();
	}

	@PostMapping("/setnumber")
	public boolean setnumber(@RequestParam(value = "key", defaultValue = "") String key, @RequestParam(value = "value", defaultValue = "") Number num) {
		if (key.length() > 0) System.out.println("No key provided");
		SetNumber updated = new SetNumber(key, num);
		return updated.updateNumber();
	}
}