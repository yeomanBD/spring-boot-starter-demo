package com.mlbd.springstarterdemo.libs;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class Utils {

	public static <T> T convert(Object object, Class<T> clazz) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(object, clazz);
	}

	public static <T> void merge(T source, T target) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.map(source, target);
	}

}
