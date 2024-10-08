package com.atletica.mensal.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atletica.mensal.Entities.AtleticaEntity;
import com.atletica.mensal.Service.AtleticaService;

@RestController
@RequestMapping("/atletica")
public class AtleticaController {

	@Autowired
	private AtleticaService atleticaService;

	@PostMapping(value = "/criar")
	public AtleticaEntity criarAtletica(@RequestBody AtleticaEntity atletica) {
		return atleticaService.salvarAtletica(atletica);
	}
//comentario tteste
	@GetMapping(value = "/listarAtleticas")
	public List<AtleticaEntity> listarTodasAtleticas() {
		return atleticaService.listarTodasAtleticas();
	}

	@GetMapping("/{id}")
	public Optional<AtleticaEntity> buscarAtleticaPorId(@PathVariable Long id) {
		return atleticaService.buscarAtleticaPorId(id);
	}

	@DeleteMapping("/deletar/{id}")
	public void deletarAtletica(@PathVariable Long id) {
		atleticaService.deletarAtletica(id);
	}
	
	@GetMapping(value = "/findAll", produces = "application/json")
	public ResponseEntity<List<AtleticaEntity>> findAll(){
		
		try {
			return ResponseEntity.ok(atleticaService.findAll());
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
