package com.ariellopes.api.starwars.rest.model.modelApiStarWarsExterna;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetaApiStarWarsExterna implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<PlanetaApiStarWarsExterna> results = new ArrayList<>();
	
	private String count;
	private String name;
	private String rotation_period;
	private String orbital_period;
	private String diameter;
	private String climate;
	
	private List<String> films = new ArrayList<>();
}

