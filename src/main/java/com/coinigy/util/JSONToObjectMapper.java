package com.coinigy.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JSONToObjectMapper {

	private JSONToObjectMapper() {
		
	}
	@SuppressWarnings("deprecation")
	public static <T> T convertJsonToObject(String data, Class<T> type)
			throws  IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
		/*objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));*/

		return objectMapper.readValue(data, type);

	}
}
