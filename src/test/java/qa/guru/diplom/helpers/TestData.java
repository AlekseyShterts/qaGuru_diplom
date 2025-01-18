package qa.guru.diplom.helpers;

import com.github.javafaker.Faker;
import qa.guru.diplom.models.BadArgumentEducationalModel;
import qa.guru.diplom.models.ResumeModel;
import qa.guru.diplom.models.ValidEducationalModel;

import java.time.LocalDateTime;
import java.util.List;

public class TestData {
    public static String generateResumeTitle() {
        return "Resume at " + LocalDateTime.now();
    }

    public static ValidEducationalModel getTestEducationalModelEn() {
        var area = new ValidEducationalModel.Area();
        area.setId("1");
        area.setName("Moscow");

        var items = new ValidEducationalModel.Items();
        items.setId("38909");
        items.setAcronym("KSPI");
        items.setText("Kolomna State Pedagogical Institute");
        items.setSynonyms(null);
        items.setArea(area);

        var model = new ValidEducationalModel();
        model.setItems(List.of(items));
        return model;
    }

    public static ValidEducationalModel getTestEducationalModelRu() {
        var area = new ValidEducationalModel.Area();
        area.setId("1");
        area.setName("Москва");

        var items = new ValidEducationalModel.Items();
        items.setId("38909");
        items.setAcronym("КГПИ");
        items.setText("Коломенский государственный педагогический институт");
        items.setSynonyms(null);
        items.setArea(area);

        var model = new ValidEducationalModel();
        model.setItems(List.of(items));
        return model;
    }

    public static BadArgumentEducationalModel getBadArgumentTestEducationalModel() {
        var errors = new BadArgumentEducationalModel.Errors();
        errors.setValue("id");
        errors.setType("bad_argument");

        var model = new BadArgumentEducationalModel();
        model.setErrors(List.of(errors));
        return model;
    }

    public static ResumeModel createResumeModel(String titleResume) {
        var faker = Faker.instance();

        ResumeModel resume = new ResumeModel();
        // Заполнение поля area
        ResumeModel.Area area = new ResumeModel.Area();
        area.setId(faker.number().numberBetween(1, 70));
        resume.setArea(area);

        // Заполнение поля contact
        ResumeModel.Contact emailContact = new ResumeModel.Contact();
        emailContact.setPreferred(true);
        ResumeModel.Contact.Type emailType = new ResumeModel.Contact.Type();
        emailType.setId("email");
        emailType.setName("Эл. почта");
        emailContact.setType(emailType);
        emailContact.setValue(faker.internet().emailAddress());
        resume.setContact(List.of(emailContact));

        // Заполнение поля gender
        ResumeModel.Gender gender = new ResumeModel.Gender();
        gender.setId(faker.demographic().sex());
        resume.setGender(gender);

        // Заполнение поля education
        ResumeModel.Education education = new ResumeModel.Education();
        ResumeModel.Education.Level level = new ResumeModel.Education.Level();
        level.setId("master");
        level.setName("Магистр");
        education.setLevel(level);

        ResumeModel.Education.Primary primaryEducation = new ResumeModel.Education.Primary();
        primaryEducation.setName(faker.university().name());
        primaryEducation.setOrganization("testFaculty");
        primaryEducation.setResult("testSpeciality");
        primaryEducation.setYear(faker.number().numberBetween(1980, 2020));
        education.setPrimary(List.of(primaryEducation));
        resume.setEducation(education);

        // Заполнение поля title
        resume.setTitle(titleResume);

        return resume;
    }
}
