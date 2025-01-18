package qa.guru.diplom.config;

import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

public class ConfigDriver {
    @Getter
    private static final WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

}
