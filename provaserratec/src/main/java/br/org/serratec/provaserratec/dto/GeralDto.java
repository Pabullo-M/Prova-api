package br.org.serratec.provaserratec.dto;
import br.org.serratec.provaserratec.model.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record GeralDto(
		 Long id,
		 @NotBlank(message= "nome do cliente não pode estar em branco")
		 String nomeCliente,
		 @NotBlank(message = "nome do Prato não pode estar em branco")
		 String nomePrato,
		 @NotBlank
		 @Pattern(regexp = "\\d+", message = "Somente números são permitidos")
		 String valorPrato,
		 String pedidos
		) {

	public Cliente toEntity() {
			return new Cliente(this.id, this.nomeCliente, this.nomePrato,
					this.valorPrato, this.pedidos);
		}

}
