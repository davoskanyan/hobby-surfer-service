package me.hobbier.dac.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lilit.abrahamyan on 10/11/2016.
 */
public class FieldsJsonConverter {

	private final static ObjectMapper objectMapper = new ObjectMapper();

	public Object convertToDatabaseColumn(Map<String, Object> attribute) {
		try {
			return objectMapper.writeValueAsString(attribute);
		} catch (JsonProcessingException ex) {
			return null;
		}
	}

	public Map<String, Object> convertToEntityAttribute(Object dbData) throws IOException {
		return dbData == null ? new HashMap<>() : objectMapper.readValue(dbData.toString(),
				new TypeReference<Map<String, Object>>() {
				});

	}

}
