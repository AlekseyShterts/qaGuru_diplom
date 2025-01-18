package qa.guru.diplom.pages.webPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static qa.guru.diplom.helpers.Constants.*;

public class GeneralPage {

    private final SelenideElement headerBlock = $(".supernova-overlay");
    private final SelenideElement mainMenuAreaSwitcherButton = headerBlock.$("button[data-qa=\"mainmenu_areaSwitcher\"]");
    private final SelenideElement mainMenuEmployerHyperText = headerBlock.$("a[data-qa=\"mainmenu_employer\"]");
    private final SelenideElement mainMenuExpertResumeHyperText = headerBlock.$("a[data-qa=\"mainmenu_expertresume\"]");
    private final SelenideElement mainMenuApplicantServicesHyperText = headerBlock.$("a[data-qa=\"mainmenu_applicantServices\"]");
    private final SelenideElement searchInput = $("input#a11y-search-input");


    @Step("Проверка отображения кнопки переключения локации")
    public GeneralPage checkVisibleAreaSwitcher() {
        mainMenuAreaSwitcherButton
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка, что в кнопке переключения локации выбран город {city}")
    public GeneralPage checkAreaSwitcherContainCity(String city) {
        mainMenuAreaSwitcherButton
                .shouldBe(visible)
                .shouldHave(text(city));
        return this;
    }

    @Step("Клик по кнопке переключения локации")
    public GeneralPage clickAreaSwitcher() {
        mainMenuAreaSwitcherButton
                .click();
        return this;
    }

    @Step("Проверка отображения элемента работодателя в хедере")
    public GeneralPage checkEmployerElement() {
        mainMenuEmployerHyperText
                .shouldBe(visible)
                .shouldHave(text(mainMenuEmployerText));
        return this;
    }


    @Step("Клик по кнопке работодателя в хедере")
    public GeneralPage clickEmployerElement() {
        mainMenuEmployerHyperText
                .click();
        return this;
    }

    @Step("Проверка отображения по кнопке экспертного резюме")
    public GeneralPage checkExpertResumeElement() {
        mainMenuExpertResumeHyperText
                .shouldBe(visible)
                .shouldHave(text(mainMenuExpertResumeText));
        return this;
    }

    @Step("Проверка отображения кнопки ведущей ко всем сервисам")
    public GeneralPage checkApplicantServicesElement() {
        mainMenuApplicantServicesHyperText
                .shouldBe(visible)
                .shouldHave(text(mainMenuApplicantServicesText));
        return this;
    }

    @Step("Ввод и выполнение поискового запроса {request}")
    public GeneralPage setSearchRequest(String request) {
        searchInput
                .setValue(request)
                .pressEnter();
        return this;
    }
}
