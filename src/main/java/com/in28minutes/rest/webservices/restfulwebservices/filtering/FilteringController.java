package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("val1", "val2", "val3");
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		
		SimpleBeanPropertyFilter sbpf = SimpleBeanPropertyFilter.filterOutAllExcept("f1", "f2"); 
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", sbpf);
		
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBeans() {
		List<SomeBean> list = Arrays.asList(new SomeBean("val1", "val2", "val3"), new SomeBean("val4", "val5", "val6"));
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		
		SimpleBeanPropertyFilter sbpf = SimpleBeanPropertyFilter.filterOutAllExcept("f2", "f3"); 
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", sbpf);
		mapping.setFilters(filters);
		return mapping; 
	}
}
