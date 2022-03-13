package cavbotics.ntclient.api;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class NumberJsonSerializer extends JsonSerializer<Number> {
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

  private static String getNumberString(java.lang.Number num) {
    return num.toString();
  }
}
