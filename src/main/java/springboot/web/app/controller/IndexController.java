package springboot.web.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${indexcontroller.index.titulo}")
	private String textIndex;
	private String textPerfil;
	private String texListar;
	
	@GetMapping(value={"/index","/","","home"})
	//@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index (Model model) {
		model.addAttribute("titulo",textIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil (Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("dix");
		usuario.setApellido("arone");
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo","perfil del usuario :" + usuario.getNombre());
		
		return "perfil";
	}
	@RequestMapping("/listar")
	public String listar (Model model) {
		
		model.addAttribute("titulo","titulo de Usuarios");
		
		return "listar";
	}	
	
	//Este metodo aplica a todo el controlador, lo que hace posible 
	//es que cualquier metodo va tener acceso a estos datos. 
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuario(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("dixroby","ac ac","dix@gmail"));
		usuarios.add(new Usuario("dixroby","arone","dix@gmail"));
		
		return usuarios;
	}
}