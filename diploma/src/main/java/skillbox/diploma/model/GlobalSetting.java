package skillbox.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "global_settings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GlobalSetting {
}
