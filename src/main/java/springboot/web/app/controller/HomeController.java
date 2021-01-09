package springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		//esta primera forma redirige a la ruta y reinicia el request, 
		//perdiendose todo el contenido almacenado en el request
		
		//return "redirect:/app/index";
		
		//dentro del mismo request ira al metodo handler que este mapeado a la ruta
		//pero sin recargar la pagina, solamente por debajo
		return "forward:/app/index"; 
	}
}
