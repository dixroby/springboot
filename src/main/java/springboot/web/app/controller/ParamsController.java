package springboot.web.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	@GetMapping("/string")
	public String param(@RequestParam(name="text",required = false,defaultValue = "nada") String text, Model model) {
		model.addAttribute("result","el texto enviado es: "+text);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo,@RequestParam Integer numero, Model model) {
		model.addAttribute("result","el texto enviado es: "+saludo +" n "+ numero);
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");	
		Integer numero;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
			
		}catch (NumberFormatException e){
			numero = 0;
		}
		model.addAttribute("result","el texto enviado es: "+saludo +" n "+ numero);
		return "params/ver";
	}
	
}
