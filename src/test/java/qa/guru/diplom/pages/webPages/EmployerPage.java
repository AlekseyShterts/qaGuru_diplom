package qa.guru.diplom.pages.webPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static qa.guru.diplom.helpers.Constants.*;

public class EmployerPage {

    private final SelenideElement employerTitle = $("[data-qa=\"employer-index-title\"]");
    private final SelenideElement employerSubtitle = $("[data-qa=\"employer-index-subtitle\"]");
    private final SelenideElement publishVacancyButton = $("[data-qa=\"employer-index-publish-vacancy\"]");

    @Step("Проверка отображения заголовка на странице работодателя")
    public EmployerPage checkVisibleEmployerTitle() {
        employerTitle
                .shouldHave(text(employerTitleText))
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка отображения подзаголовка на странице работодателя")
    public EmployerPage checkVisibleEmployerSubtitle() {
        employerSubtitle
                .shouldHave(text(employerSubtitleText))
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка отображения кнопки публикации вакансии")
    public EmployerPage checkVisiblePublishVacancyButton() {
        publishVacancyButton
                .shouldHave(text(publishVacancyButtonText))
                .shouldBe(visible);
        return this;
    }
}
