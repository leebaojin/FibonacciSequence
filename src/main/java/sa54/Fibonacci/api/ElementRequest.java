package sa54.Fibonacci.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ElementRequest {
	
	private Integer elements;

	public ElementRequest(Integer elements) {
		super();
		this.elements = elements;
	}

	public ElementRequest() {
		super();
	}
	
	@JsonProperty
	public Integer getElements() {
		return elements;
	}
	
	@JsonProperty
	public void setElements(Integer elements) {
		this.elements = elements;
	}
	
	

}
