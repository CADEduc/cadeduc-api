package br.com.imd.cadeduc.localizavel.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.imd.cadwork.core.localizavel.model.Localizavel;
import br.com.imd.cadwork.core.localizavel.model.LocalizavelDAO;

@Repository
public interface EscolaDAO extends LocalizavelDAO {

	@Query("SELECT e FROM Escola e WHERE e.endereco.id = :idEndereco")
	public Optional<Localizavel> findEscolaByEndereco(@Param("idEndereco") Long idEndereco);
}
