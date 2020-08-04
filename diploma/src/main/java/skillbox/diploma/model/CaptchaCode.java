package skillbox.diploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "captcha_codes")
@Getter
@Setter
public class CaptchaCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private Timestamp time;

    @NotNull
    @Column(columnDefinition = "tinytext")
    private String code;

    @NotNull
    @Column(name = "secret_code", columnDefinition = "tinytext")
    private String secretCode;

}
