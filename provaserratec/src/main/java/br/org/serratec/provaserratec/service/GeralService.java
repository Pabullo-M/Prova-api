package br.org.serratec.provaserratec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.provaserratec.dto.GeralDto;
import br.org.serratec.provaserratec.model.Cliente;
import br.org.serratec.provaserratec.repository.GeralRepository;
@Service
public class GeralService {
	
	@Autowired
	private GeralRepository repository;
	
	public List<GeralDto> obterTodos() {
		return repository.findAll().stream()
				.map(c -> new GeralDto(c.getId(),  
						c.getNomeCliente(), c.getNomePrato(), c.getValorPrato(), c.getPedidos()))
				.toList();
	}


	public GeralDto salvarGeral(GeralDto geral) {
		 
		
		Cliente clienteEntity = geral.toEntity();
		clienteEntity.setPedidos(clienteEntity.getNomePrato() + " R$ "+ clienteEntity.getValorPrato());
		repository.save(clienteEntity);
		return clienteEntity.toDto();
	}

	public Optional<GeralDto> atualizarCliente(Long id, GeralDto cliente){
		Cliente clienteEntity = cliente.toEntity();
		
		if (repository.existsById(id)) {
			clienteEntity.setId(id);
			repository.save(clienteEntity);
			return Optional.of(clienteEntity.toDto());
		}
		return Optional.empty();
	}
	
	public boolean excluir(Long id) {
		if(!repository.existsById(id)){
			return false;
		}
		
		repository.deleteById(id);
		return true;
	}


	public Optional<GeralDto> obterPorId(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		if (cliente.isPresent()) {
			return Optional.of(cliente.get().toDto());	
		}
		return Optional.empty();
	}

	public List<GeralDto> findByNomeClienteContainingIgnoreCase(String cliente) {
        return repository.findByNomeClienteContainingIgnoreCase(cliente).stream()
            .map(c -> new GeralDto(c.getId(), c.getNomeCliente(), c.getNomePrato(), c.getValorPrato(), c.getPedidos()))
            .toList();
    }
	
}
