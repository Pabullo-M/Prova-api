package br.org.serratec.provaserratec.dto;
import br.org.serratec.provaserratec.model.Cliente;

public record GeralDto(
		 Long id,
		 String nomeCliente,
		 String nomePrato,
		 String valorPrato,
		 String pedidos
		) {

	public Cliente toEntity() {
			return new Cliente(this.id, this.nomeCliente, this.nomePrato,
					this.valorPrato, this.pedidos);
		}

}
