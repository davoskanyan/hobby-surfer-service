package me.hobbier.dac.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.hobbier.model.MultilingualString;

import java.io.IOException;
import java.util.Map;

/**
 * @author lilit.abrahamyan on 10/13/2016.
 */
public class MultilingualStringConverter {

	private final static ObjectMapper objectMapper = new ObjectMapper();

	public static MultilingualString convertToEntityAttribute(Object dbData) {
		try {
			Map<Integer, String> names = objectMapper.readValue(dbData.toString(),
					new TypeReference<Map<Integer, String>>() {
					});
			return new MultilingualString(names);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}
