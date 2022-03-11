package cavbotics.ntclient.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {
	@Autowired
    private ObjectMapper objectMapper;

	@GetMapping("/getnumber")
	public String getnumber(@RequestParam(value = "key", defaultValue = "") String key) throws JsonProcessingException {
		Number updated = new Number(key);
		String json = objectMapper.writeValueAsString(updated);
		return json;
	}

	@PostMapping("/setnumber")
	public boolean setnumber(@RequestParam(value = "key", defaultValue = "") String key, @RequestParam(value = "value", defaultValue = "") java.lang.Number num) {
		Number updated = new Number(key, num);
		return updated.updateNumber();
	}

	@DeleteMapping("/deletenumber")
	public boolean deletenumber(@RequestParam(value = "key", defaultValue = "") String key) {
		Number updated = new Number(key);
		return updated.removeNumber();
	}
}