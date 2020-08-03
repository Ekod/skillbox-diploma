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
    private String code; //<----в БД должен быть тип TINYTEXT, но не нашёл подходящего типа или аннотации в Java

    @NotNull
    @Column(name = "secret_code")
    private String secretCode; //<----в БД должен быть тип TINYTEXT, но не нашёл подходящего типа или аннотации в Java

}
