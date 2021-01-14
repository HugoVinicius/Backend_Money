package com.example.money.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.money.api.event.RecursoCriadoEvent;
import com.example.money.api.model.Categoria;
import com.example.money.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Categoria> Listar() {
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}	
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codigo) {
		
		//Categoria categoriaBusca = new Categoria();
		//categoriaBusca.setCodigo(codigo);			
		//Example<Categoria> example = Example.of(categoriaBusca);				
		//Categoria categoriaLocalizada = categoriaRepository.findOne(example).orElse(null);
		
		
		//Optional<Categoria> categoria = this.categoriaRepository.findById(codigo);
		//return categoria.isPresent() ? 
		//ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
				
		return this.categoriaRepository.findById(codigo).
				map(categoria -> ResponseEntity.ok(categoria)).
				orElse(ResponseEntity.notFound().build());	
	}
		
	@GetMapping("/CategoriaOld")
	public ResponseEntity<?> listarMod() {
		List<Categoria> categorias = categoriaRepository.findAll();	
		
		return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.noContent().build();
	}
		
	@GetMapping("/outro")
	public String outro() {
		return "OK";
	}
}
