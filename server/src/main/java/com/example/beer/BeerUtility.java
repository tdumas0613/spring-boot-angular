package com.example.beer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeerUtility {
	
	@Autowired BeerRepository repository;

	protected Collection<Map<String, String>> findGoodBeers() {
		return repository.findAll().stream()
				.filter(this::isGreat)
				.map(beer -> {
					Map<String, String> map = new HashMap<>();
					map.put("id", beer.getId().toString());
					map.put("name", beer.getName().toString());
					return map;
				}).collect(Collectors.toList());
	}
	
	private boolean isGreat(Beer beer) {
		return !"Budweiser".equals(beer.getName()) && 
				!"Coors Light".equals(beer.getName()) && 
				!"PBR".equals(beer.getName()); 
	}
}
