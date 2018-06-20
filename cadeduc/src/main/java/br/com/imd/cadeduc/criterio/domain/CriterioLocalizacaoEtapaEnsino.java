package br.com.imd.cadeduc.criterio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.imd.cadwork.core.dao.GenericDomainException;
import br.com.imd.cadwork.core.localizavel.exception.CriterioException;
import br.com.imd.cadwork.core.localizavel.model.CriterioLocalizacao;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Classe que define o modelo etapa de ensino
 * 
 * @author Miguel
 * @version 0.2
 *
 */

@Entity
@Table(name = "etapa_ensino", schema = "criterio")
@ApiModel
public class CriterioLocalizacaoEtapaEnsino extends CriterioLocalizacao{
	
	@Column(name = "vagas_disponiveis")
	@ApiModelProperty(notes = "Quantidade de vagas disponíveis", required = true)
	private int vagasDisponiveis;

	@NotNull
	@Column(name = "tipo_etapa_ensino")
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(notes = "Tipo da etapa de ensino", required = true)
	private TipoEtapaEnsinoEnum tipoEtapaEnsino;


	/**
	 * Retorna o número de vagas disponíveis
	 * 
	 * @return int - Número de vagas
	 */
	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	/**
	 * Método que atualiza o número de vagas disponíveis
	 * 
	 * @param vagasDisponiveis
	 *            int - Novo número de vagas disponíveis
	 */

	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	/**
	 * Método para retorno do tipo da etapa de ensino
	 * 
	 * @return TipoEtapaEnsinoEnum - Etapa de ensino
	 */

	public TipoEtapaEnsinoEnum getTipoEtapaEnsino() {
		return tipoEtapaEnsino;
	}

	/**
	 * Altera a etapa de ensino da instância
	 * 
	 * @param tipoEtapaEnsino
	 *            TipoEtapaEnsinoEnum - Etapa de ensino para ser atualizada
	 */

	public void setTipoEtapaEnsino(TipoEtapaEnsinoEnum tipoEtapaEnsino) {
		this.tipoEtapaEnsino = tipoEtapaEnsino;
	}

	@Override
	public void validaCriterios() throws GenericDomainException {
		if(vagasDisponiveis==0) {
			throw new CriterioException("Quantidade de vagas insuficiente");
		}
		
	}

}