package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.model.domain.Consulta;

public interface ConsultaService {
	List<Consulta> consulta();
	List<Consulta> guarda(List<Consulta> datos);
}
