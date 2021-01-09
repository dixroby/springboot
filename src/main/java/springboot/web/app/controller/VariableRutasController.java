package springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class VariableRutasController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("titulo","Enviar parámetros de  la ruta  (@Pathvariable");
		return "variables/index";
	}
	
	@GetMapping("/string/{text}")
	public String variables(@PathVariable String text, Model model) {
		model.addAttribute("titulo","Recibir parámetros de  la ruta  (@Pathvariable");
		model.addAttribute("result","parametro recibido " + text);
		return "variables/ver";
	}
	
	@GetMapping("/string/{text}/{numero}")
	public String variables(@PathVariable String text,@PathVariable Integer numero, Model model) {
		model.addAttribute("titulo","Recibir parámetros de  la ruta  (@Pathvariable");
		model.addAttribute("result","parametro recibido " + text +" numero "+ numero);
		return "variables/ver";
	}

}
