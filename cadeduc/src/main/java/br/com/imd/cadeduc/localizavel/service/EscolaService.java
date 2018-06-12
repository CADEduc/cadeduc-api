package br.com.imd.cadeduc.localizavel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import br.com.imd.cadeduc.localizavel.dao.EscolaDAO;
import br.com.imd.cadeduc.localizavel.domain.Escola;
import br.com.imd.cadwork.core.dao.GenericDAO;
import br.com.imd.cadwork.core.service.GenericService;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.core.service.exception.ResourceConflictException;

@Component
public class EscolaService extends GenericService<Escola> {

	@Override
	public List<Escola> listar() throws GenericServiceException {
		return super.listar();
	}

	@Override
	public void salvar(Escola escola, BindingResult resultado) throws GenericServiceException {
		super.salvar(escola, resultado);
	}

	@Override
	public Optional<Escola> buscar(Long id) throws GenericServiceException {
		return super.buscar(id);
	}

	@Autowired
	public void setDao(GenericDAO<Escola> dao) {
		super.dao = dao;
	}

	@Override
	protected void verificaExistencia(Escola escola) throws GenericServiceException {
		Optional<Escola> escolaCadastrada = ((EscolaDAO) dao).findEscolaByEndereco(escola.getEndereco().getId());
		if (escola.getId() != 0 || escolaCadastrada.isPresent()) {
			throw new ResourceConflictException();
		}
	}
}
