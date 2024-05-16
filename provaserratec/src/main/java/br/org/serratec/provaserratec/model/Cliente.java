package br.org.serratec.provaserratec.model;


import br.org.serratec.provaserratec.dto.GeralDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message= "nome do cleinte não pode estar em branco")
	private String nomeCliente;
	@NotBlank(message = "nome do Prato não pode estar em branco")
	private String nomePrato;
	@NotBlank
	@Pattern(regexp = "\\d+", message = "Somente números são permitidos")
	private String valorPrato;
	private String pedido;
	
	
	
	public Long getId() {
		return id;
		
	}
	public Cliente(Long id, String nomeCliente, String nomePrato, String valorPrato, String pedido) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.nomePrato = nomePrato;
		this.valorPrato = valorPrato;
		this.pedido = pedido;
	}
	
	
	
	public Cliente() {
		super();
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNomePrato() {
		return nomePrato;
	}
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}
	public String getValorPrato() {
		return valorPrato;
	}
	public void setValorPrato(String valorPrato) {
		this.valorPrato = valorPrato;
	}
	public String getPedidos() {
		return pedido;
	}
	public void setPedidos(String pedido) {
		this.pedido = pedido;
		
		
	}

	public GeralDto toDto() {
		return new GeralDto(this.id, this.nomeCliente, this.nomePrato,
				this.valorPrato, this.pedido);
	}
	
	
	

}
