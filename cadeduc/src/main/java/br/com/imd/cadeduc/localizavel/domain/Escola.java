package br.com.imd.cadeduc.localizavel.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.imd.cadwork.core.localizavel.model.Localizavel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * Classe que define o modelo Escola
 * 
 * @author Miguel
 * @version 0.4
 *
 */

@Entity
@Table(name = "escola", schema = "localizavel")
@ApiModel
public class Escola extends Localizavel{

	@ApiModelProperty(notes = "Telefone da instituição")
	private String telefone;

	@Override
	public boolean validaLocalizavel() {
		return google.validaExistencia(endereco.getLatitude(),
									   endereco.getLongitude(),									 
									   endereco.getCep(),
									   "escola");
		
	}

	public Escola() {
		id = new Long(0);
	}

	/**
	 * Método para retorno do id de uma instância de Escola
	 * 
	 * @return Long - Valor do id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Altera o valor do id de uma instância de Escola
	 * 
	 * @param id
	 *            Long - Novo valor do id
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que retorna o nome da escola
	 * 
	 * @return String - Nome da escola
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que modifica o nome da escola
	 * 
	 * @param nome
	 *            String - Novo nome da escola
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método para retorno o telefone da escola
	 * 
	 * @return String - Telefone da escola
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Altera o telefone de uma instância de Escola
	 * 
	 * @param telefone
	 *            String - Novo Telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


}
