package skillbox.diploma.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettingsResponse {
    private boolean MULTIUSER_MODE;
    private boolean POST_PREMODERATION;
    private boolean STATISTICS_IS_PUBLIC;
}
