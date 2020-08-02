package skillbox.diploma.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class InitRequestConfig {

    @Value("${title}")
    private String title;

    @Value("${subtitle}")
    private String subtitle;

    @Value("${phone}")
    private String phone;

    @Value("${email}")
    private String email;

    @Value("${copyright}")
    private String copyright;

    @Value("${copyrightFrom}")
    private String copyrightFrom;

}
