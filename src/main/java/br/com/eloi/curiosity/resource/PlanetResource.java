package br.com.eloi.curiosity.resource;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eloi.curiosity.modelo.Planet;

public class PlanetResource extends ResourceSupport  {

	private final Planet content;

    @JsonCreator
    public PlanetResource(@JsonProperty("content") Planet content) {
        this.content = content;
    }

    public Planet getContent() {
        return content;
    }
}
