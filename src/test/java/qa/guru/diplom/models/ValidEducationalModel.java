package qa.guru.diplom.models;

import lombok.Data;

import java.util.List;

@Data
public class ValidEducationalModel {
    private List<Items> items;

    @Data
    public static class Items {
        private String id;
        private String acronym;
        private String text;
        private String synonyms;
        private Area area;
    }

    @Data
    public static class Area {
        private String id;
        private String name;
    }
}
