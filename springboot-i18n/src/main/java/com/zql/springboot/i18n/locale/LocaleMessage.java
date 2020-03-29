package com.zql.springboot.i18n.locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author lawliet.L
 */
@Component
public class LocaleMessage {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    /*public String getMessage(String key, String defaultMessage) {
        return this.getMessage(key, null, defaultMessage);
    }

    public String getMessage(String key, String defaultMessage, Locale locale) {
        return this.getMessage(key, null, defaultMessage, locale);
    }

    public String getMessage(String key, Locale locale) {
        return this.getMessage(key, null, "", locale);
    }

    public String getMessage(String key, Object[] args) {
        return this.getMessage(key, args, "");
    }

    public String getMessage(String key, Object[] args, Locale locale) {
        return this.getMessage(key, args, "", locale);
    }

    public String getMessage(String key, Object[] args, String defaultMessage) {
        return this.getMessage(key, args, defaultMessage, LocaleContextHolder.getLocale());
    }

    public String getMessage(String key, Object[] args, String defaultMessage, Locale locale) {
        return messageSource.getMessage(key, args, defaultMessage, locale);
    }*/
}
