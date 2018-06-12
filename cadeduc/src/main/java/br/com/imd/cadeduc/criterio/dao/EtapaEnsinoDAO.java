package br.com.imd.cadeduc.criterio.dao;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.imd.cadeduc.criterio.domain.CriterioLocalizacaoEtapaEnsino;
import br.com.imd.cadwork.core.dao.GenericDAO;

@Repository
public interface EtapaEnsinoDAO extends GenericDAO<CriterioLocalizacaoEtapaEnsino> {

	public Optional<CriterioLocalizacaoEtapaEnsino> findEtapaEnsinoByNome(@Param("nome") String nome);
}
