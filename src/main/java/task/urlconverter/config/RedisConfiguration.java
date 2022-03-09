package task.urlconverter.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import task.urlconverter.model.ShortUrl;

@Configuration
public class RedisConfiguration {
//
//    @Bean
//    LettuceConnectionFactory lettuceConnectionFactory() {
//        RedisStandaloneConfiguration config =
//            new RedisStandaloneConfiguration("localhost", 6379);
//
//        return new LettuceConnectionFactory(config);
//    }

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate<String, ShortUrl> redisTemplate() {
        final RedisTemplate<String, ShortUrl> template = new RedisTemplate<>();
        Jackson2JsonRedisSerializer<ShortUrl> valueSerializer =
            new Jackson2JsonRedisSerializer<>(ShortUrl.class);
        valueSerializer.setObjectMapper(objectMapper);
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(valueSerializer);
        return template;
    }


}
