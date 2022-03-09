package task.urlconverter.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.urlconverter.exception.KeyNotFoundException;
import task.urlconverter.keygenerator.SimpleGenerator;
import task.urlconverter.model.ShortUrl;
import task.urlconverter.validator.UrlValidator;

@Service
public class ShortUrlService implements ShortUrlServiceProvider {

    @Autowired
    private RedisTemplate<String, ShortUrl> redisTemplate;

    @Override
    public String getUrlByKey(String key) {
        ShortUrl url = redisTemplate.opsForValue().get(key);
        if (url == null) {
            throw new KeyNotFoundException("There is no such key");
        } else {
            return url.getUrl();
        }
    }

    @Override
    @Transactional
    public String convert(String url) {
        UrlValidator.validate(url);
        String key = SimpleGenerator.getRandomKey();
        while (redisTemplate.opsForValue().get(key) != null) {
            key = SimpleGenerator.getRandomKey();
        }
        ShortUrl toStore = new ShortUrl();
        toStore.setUrl(url);
        toStore.setCreated(LocalDateTime.now());
        redisTemplate.opsForValue().set(key, toStore);
        return key;
    }
}
