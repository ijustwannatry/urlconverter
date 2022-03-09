package task.urlconverter.service;

import task.urlconverter.model.ShortUrl;

public interface ShortUrlServiceProvider {

    String getUrlByKey(String key);

    String convert(String url);
}
