package br.com.eloi.curiosity.resource;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eloi.curiosity.modelo.Sonda;

public class SondaResource extends ResourceSupport {

	final private Sonda content;

    @JsonCreator
    public SondaResource(@JsonProperty("content") Sonda content) {
        this.content = content;
    }
    
    public Sonda getContent() {
        return content;
    }
	
}
