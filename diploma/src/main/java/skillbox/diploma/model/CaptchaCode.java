package skillbox.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "captcha_codes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaptchaCode {
}
