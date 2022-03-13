package cavbotics.ntclient.api;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import org.springframework.boot.jackson.JsonComponent;

/**
 * Handles converting between Number and JSON
 */
@JsonComponent
public class NumberJsonSerializer extends JsonSerializer<Number> {

  /**
   * Serializes the Number object into JSON format
   * 
   * @param num                Number object to serialize
   * @param jsonGenerator      JSON generator object from Jackson (provided
   *                           automatically)
   * @param serializerProvider Serializer Provider object from Jackson (provided
   *                           automatically)
   * 
   * @throws IOException             Missing at least one parameter
   * @throws JsonProcessingException Problem(s) encountered when processing to
   *                                 JSON
   */
  @Override
  public void serialize(Number num, JsonGenerator jsonGenerator,
      SerializerProvider serializerProvider) throws IOException,
      JsonProcessingException {

    jsonGenerator.writeStartObject();
    jsonGenerator.writeStringField(
        "number",
        getNumberString(num.getValue()));
    jsonGenerator.writeEndObject();
  }

  /**
   * Converts Number value to String
   * 
   * @param num Number value
   * @return Number value as a String
   */
  private static String getNumberString(java.lang.Number num) {
    return num.toString();
  }
}
