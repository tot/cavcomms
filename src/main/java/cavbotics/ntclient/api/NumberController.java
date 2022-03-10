package cavbotics.ntclient.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

	@GetMapping("/getnumber")
	public java.lang.Number getnumber(@RequestParam(value = "key", defaultValue = "") String key, @RequestParam(value = "value", defaultValue = "") java.lang.Number num) {
		if (key.length() > 0) System.out.println("No key provided");
		Number updated = new Number(key, num);
		return updated.getNumber();
	}

	@PostMapping("/setnumber")
	public boolean setnumber(@RequestParam(value = "key", defaultValue = "") String key, @RequestParam(value = "value", defaultValue = "") java.lang.Number num) {
		if (key.length() > 0) System.out.println("No key provided");
		Number updated = new Number(key, num);
		return updated.updateNumber();
	}
}