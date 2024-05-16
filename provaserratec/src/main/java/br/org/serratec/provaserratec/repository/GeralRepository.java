package br.org.serratec.provaserratec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.org.serratec.provaserratec.model.Cliente;


public interface GeralRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findByNomeClienteContainingIgnoreCase(String nomeCliente);
}
