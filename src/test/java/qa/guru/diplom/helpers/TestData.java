package qa.guru.diplom.helpers;

import qa.guru.diplom.models.BadArgumentEducationalModel;
import qa.guru.diplom.models.ValidEducationalModel;

import java.util.List;

public class TestData {

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

}
