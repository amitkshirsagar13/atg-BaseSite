package services.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * <pre>
 * @projectName MyAccount
 * Creation date: Jun 1, 2015
 * @author Amit Kshirsagar
 * @version 1.0
 * @since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class BaseRestJsonEntity {
	public static ObjectMapper MAPPER = new ObjectMapper();

	@JsonIgnore
	public String getJsonString() throws JsonProcessingException {
		return MAPPER.writeValueAsString(this);
	}
}
