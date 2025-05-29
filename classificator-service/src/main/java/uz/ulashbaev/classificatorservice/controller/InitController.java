package uz.ulashbaev.classificatorservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.ulashbaev.classificatorservice.service.InitService;

@RestController
@RequestMapping("/api/init")
@RequiredArgsConstructor
public class InitController {

    private final InitService initService;

    @PostMapping
    public String initialize() {
        return initService.initDataFromJson();
    }
}
