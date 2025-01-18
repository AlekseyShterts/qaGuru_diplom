package qa.guru.diplom.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListOfResumesModel {
    private Integer found;
    private List<Items> items;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Items {
        private ResumeModel.Area area;
        private List<ResumeModel.Contact> contact;
        private ResumeModel.Education education;
        private ResumeModel.Gender gender;
        private String title;
        private String id;
    }
}
