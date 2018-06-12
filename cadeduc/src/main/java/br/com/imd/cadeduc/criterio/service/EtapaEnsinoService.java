package br.com.imd.cadeduc.criterio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import br.com.imd.cadeduc.criterio.dao.EtapaEnsinoDAO;
import br.com.imd.cadeduc.criterio.domain.CriterioLocalizacaoEtapaEnsino;
import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.service.GenericService;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.core.service.exception.ResourceConflictException;

@Component
public class EtapaEnsinoService extends GenericService<CriterioLocalizacaoEtapaEnsino> {

	@Override
	public List<CriterioLocalizacaoEtapaEnsino> listar() throws GenericServiceException {
		return super.listar();
	}

	@Override
	public void salvar(CriterioLocalizacaoEtapaEnsino etapaEnsino, BindingResult resultado) throws GenericServiceException {
		super.salvar(etapaEnsino, resultado);
	}

	@Override
	public Optional<CriterioLocalizacaoEtapaEnsino> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}

	@Autowired
	public void setDao(GenericDAO<CriterioLocalizacaoEtapaEnsino> dao) {
		super.dao = dao;
	}

	@Override
	protected void verificaExistencia(CriterioLocalizacaoEtapaEnsino etapaEnsino) throws GenericServiceException {
		Optional<CriterioLocalizacaoEtapaEnsino> etapaCadastrada = ((EtapaEnsinoDAO) dao).findEtapaEnsinoByNome(etapaEnsino.getNome());
		if (etapaEnsino.getId() != 0 || etapaCadastrada.isPresent()) {
			throw new ResourceConflictException();
		}
	}
}
