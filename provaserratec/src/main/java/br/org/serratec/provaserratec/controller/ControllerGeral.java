package br.org.serratec.provaserratec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.catalogoDeMusicas.dto.MusicasDto;
import br.org.serratec.provaserratec.dto.GeralDto;
import br.org.serratec.provaserratec.service.GeralService;


@RestController
@RequestMapping("/geral")
public class ControllerGeral {

	@Autowired
	private GeralService servico;
	
	
	@GetMapping
	public ResponseEntity<List<GeralDto>> listar(){
		return ResponseEntity.ok(servico.obterTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GeralDto> buscar(@PathVariable Long id) {
		Optional<GeralDto> geral = servico.obterPorId(id);
		if (geral.isPresent()) {
			return ResponseEntity.ok(geral.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GeralDto inserir(@RequestBody GeralDto cliente) {
		return servico.salvarGeral(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GeralDto> atualizar(@PathVariable Long id, @RequestBody GeralDto clienteAlterado) {
		Optional<GeralDto> cliente = servico.atualizarCliente(id, clienteAlterado);
		
		if (cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(cliente.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if(!servico.excluir(id)){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/buscarCliente")
    public ResponseEntity<List<GeralDto>> buscarPorCliente(@RequestParam String cliente) {
        List<GeralDto> clientes = servico.findByNomeClienteContainingIgnoreCase(cliente);
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }
}
