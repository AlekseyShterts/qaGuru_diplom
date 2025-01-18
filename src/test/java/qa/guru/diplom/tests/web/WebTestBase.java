package qa.guru.diplom.tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.guru.diplom.helpers.Attachments;
import qa.guru.diplom.config.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class WebTestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://spb.hh.ru/";

        var browser = ConfigDriver.getWebConfig().getBrowser();
        if (browser.contains(":")) {
            Configuration.browser = browser.split(":")[0];
            Configuration.browserVersion = browser.split(":")[1];
        } else {
            Configuration.browser = browser;
            Configuration.browserVersion = ConfigDriver.getWebConfig().getBrowserVersion();
        }
        if (ConfigDriver.getWebConfig().getRemoteUrl() != null) {
            Configuration.remote = ConfigDriver.getWebConfig().getRemoteUrl();
        }

        Configuration.browserSize = ConfigDriver.getWebConfig().getBrowserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.addVideo();
        closeWebDriver();
    }
}
