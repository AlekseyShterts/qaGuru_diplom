package qa.guru.diplom.config;

import org.aeonbits.owner.Config;

public interface WebConfig extends Config{
    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("122.0")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browserSize")
    @DefaultValue("1980x1080")
    String getBrowserSize();
}
