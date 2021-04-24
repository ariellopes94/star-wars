package com.ariellopes.api.starwars.persistence.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("planeta")
public class PlanetaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;	
	
	private String nome;
	
	private String clima;
	
	private String terreno;
	
	

}
