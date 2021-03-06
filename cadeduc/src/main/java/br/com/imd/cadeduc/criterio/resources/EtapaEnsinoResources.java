package br.com.imd.cadeduc.criterio.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.imd.cadeduc.criterio.domain.CriterioLocalizacaoEtapaEnsino;
import br.com.imd.cadeduc.criterio.service.EtapaEnsinoService;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/etapasEnsino", produces = "application/json")
@Api(tags = "Etapas de Ensino", description = "Operações pertinentes a etapas de ensino")
public class EtapaEnsinoResources {

	@Autowired
	EtapaEnsinoService etapaEnsinoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CriterioLocalizacaoEtapaEnsino>> listar() throws GenericServiceException {
		return new ResponseEntity<>(etapaEnsinoService.listar(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@Valid @RequestBody CriterioLocalizacaoEtapaEnsino etapaEnsino, BindingResult resultado) throws GenericServiceException {

		etapaEnsinoService.salvar(etapaEnsino, resultado);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(etapaEnsino.getId())
				.toUri();

		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Optional<CriterioLocalizacaoEtapaEnsino>> buscar(@PathVariable("id") Long id)
			throws GenericServiceException {
		return new ResponseEntity<>(etapaEnsinoService.buscar(id), HttpStatus.OK);
	}
}
