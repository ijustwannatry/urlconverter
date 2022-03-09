package task.urlconverter.service;

public interface ShortUrlServiceProvider {

    String getUrlByKey(String key);

    String convert(String url);
}
