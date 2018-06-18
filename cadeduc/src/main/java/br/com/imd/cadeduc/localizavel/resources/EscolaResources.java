package br.com.imd.cadeduc.localizavel.resources;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.imd.cadeduc.localizavel.domain.Escola;
import br.com.imd.cadeduc.localizavel.service.EscolaService;
import br.com.imd.cadwork.core.localizavel.model.Localizavel;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.util.exception.ConvertLocalizavelException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/escolas", produces = "application/json")
@Api(tags = "Escolas", description = "Operações pertinentes a escolas")
public class EscolaResources {

	@Autowired
	EscolaService escolaService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Localizavel> listar() throws GenericServiceException {
		return escolaService.listar();

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@Valid @RequestBody Escola escola, BindingResult resultado) throws GenericServiceException {

		escolaService.salvar(escola, resultado);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(escola.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Localizavel> buscar(@PathVariable("id") Long id) throws GenericServiceException {
		return escolaService.buscar(id);
	}

	@RequestMapping(value = "/endereco/{lat:.+}/{lng:.+}", method = RequestMethod.GET)
	@ApiOperation(value = "Escolas Próximas")
	public List<Map<String, Object>> getEscolasProximas(@PathVariable("lat") String lat, @PathVariable("lng") String lng) 
			throws GenericServiceException, NumberFormatException, ConvertLocalizavelException {
		
		return escolaService.buscarEscolasProximas(Double.valueOf(lat),Double.valueOf(lng));
	}
}
