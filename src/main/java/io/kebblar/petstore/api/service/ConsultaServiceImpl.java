package io.kebblar.petstore.api.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import io.kebblar.petstore.api.model.domain.Consulta;

@Service
public class ConsultaServiceImpl implements ConsultaService {
	List<Consulta> resultado = new ArrayList<>();

	@PostConstruct
	public void inicializa() {
    	resultado.add(new Consulta(3,1));
    	resultado.add(new Consulta(0,1));
    	resultado.add(new Consulta(1,3));		
	}

	@Override
	public List<Consulta> consulta() {
		return resultado;
	}

	@Override
	public List<Consulta> guarda(List<Consulta> datos) {
		this.resultado = datos;
		return datos;
	}
}
