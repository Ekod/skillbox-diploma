package skillbox.diploma.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
