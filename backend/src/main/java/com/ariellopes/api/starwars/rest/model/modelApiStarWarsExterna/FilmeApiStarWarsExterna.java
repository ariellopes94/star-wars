package com.ariellopes.api.starwars.rest.model.modelApiStarWarsExterna;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmeApiStarWarsExterna implements Serializable {
	private static final long serialVersionUID = 1L;

	public String title;
	
	public String urlImg;
	
	public String episode_id;
	
	public String opening_crawl;
	
	public String director;
	
	public String producer;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	public String release_date;
}
