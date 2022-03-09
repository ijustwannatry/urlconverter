package task.urlconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import task.urlconverter.service.ShortUrlServiceProvider;

@RestController
@RequestMapping("/shorturl")
public class ShortUrlController {

    @Autowired
    ShortUrlServiceProvider shortUrlService;

    @PostMapping
    public String getShort(@RequestParam String url) {
        return shortUrlService.convert(url);
    }

    @GetMapping
    public String getUrl(@RequestParam String key) {
        return shortUrlService.getUrlByKey(key);
    }
}
