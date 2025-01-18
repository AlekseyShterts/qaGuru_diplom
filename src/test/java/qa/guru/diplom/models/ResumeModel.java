package qa.guru.diplom.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResumeModel {
    private Area area;
    private List<Contact> contact;
    private Education education;
    private List<Experience> experience;
    private String firstName;
    private Gender gender;
    private String lastName;
    private String photo;
    private String portfolio;
    private String skills;
    private String title;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Area {
        private Integer id;
    }

    @Data
    public static class Contact {
        private Boolean preferred;
        private Type type;
        private Object value;
        private String comment;
        private Boolean needVerification;
        private Boolean verified;

        @Data
        public static class Type {
            private String id;
            private String name;
        }

        @Data
        public static class Value {
            private String city;
            private String country;
            private String formatted;
            private String number;
        }
    }

    @Data
    public static class Education {
        private Object additional;
        private Object attestation;
        private Object elementary;
        private Level level;
        private List<Primary> primary;

        @Data
        public static class Level {
            private String id;
            private String name;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Primary {
            private String name;
            private Object nameId;
            private String organization;
            private Object organizationId;
            private String result;
            private Object resultId;
            private Integer year;
        }
    }

    @Data
    public static class Experience {
        private Object area;
        private String company;
        private Object companyId;
        private String companyUrl;
        private String description;
        private Object employer;
        private String end;
        private List<Object> industries;
        private Object industry;
        private String position;
        private String start;
    }

    @Data
    public static class Gender {
        private String id;
        private String name;
    }
}
