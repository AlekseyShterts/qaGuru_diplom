package qa.guru.diplom.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadArgumentEducationalModel {
    private List<Errors> errors;
    @JsonProperty("request_id")
    private String requestId;

    @Data
    public static class Errors {
        private String value;
        private String type;
    }
}
