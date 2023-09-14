package apiTest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data // Whole class is going to be used to store data
@JsonIgnoreProperties(ignoreUnknown = true)
public class List {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("idBoard")
    private String boardID;
}
