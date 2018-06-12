package br.com.imd.cadeduc.criterio.domain;

import io.swagger.annotations.ApiModel;

/**
 * 
 * Enumeração dos possíveis tipos de etapa de ensino
 * 
 * @author Miguel
 * @version 0.2
 *
 */

@ApiModel
public enum TipoEtapaEnsinoEnum {
	/**
	 * <strong>ENSINO_FUNDAMENTAL</strong> - 1
	 * <strong>ENSINO_MEDIO</strong> - 2
	 * <strong>ENSINO_FUNDAMENTAL_EJA</strong> - 3
	 * <strong>ENSINO_MEDIO_EJA</strong> - 4
	 */
	ENSINO_FUNDAMENTAL, 
	ENSINO_MEDIO,
	ENSINO_FUNDAMENTAL_EJA,
	ENSINO_MEDIO_EJA,
	
}
