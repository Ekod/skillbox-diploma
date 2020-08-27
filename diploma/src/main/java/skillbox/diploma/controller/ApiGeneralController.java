package skillbox.diploma.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import skillbox.diploma.api.response.SettingsResponse;
import skillbox.diploma.api.response.TagResponse;
import skillbox.diploma.config.InitRequestConfig;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiGeneralController {

    InitRequestConfig initRequestConfig;


    @GetMapping("/init")
    public InitRequestConfig init() {
        return initRequestConfig;
    }

    @GetMapping("/tag")
    public TagResponse getTags() {
        return new TagResponse();
    }

    @GetMapping("/settings")
    public SettingsResponse getSettings() {
        return new SettingsResponse(
                false,
                false,
                false
        );
    }

    @RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.GET}, value = "/**/{path:[^\\\\.]*}")
    public String redirectToIndex() {
        return "forward:/";
    }
}
