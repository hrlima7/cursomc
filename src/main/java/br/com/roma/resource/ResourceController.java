package br.com.roma.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

	@RequestMapping("/categoria")
	public String Categorizar() {
		
		return "REST Funcionando !";
		
	}
}
