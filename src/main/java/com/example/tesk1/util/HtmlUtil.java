package com.example.tesk1.util;

import com.example.tesk1.exceptions.ForbiddenCharException;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;


public class HtmlUtil {

    public static String removeHtmTag(String htmlStr){
       return Jsoup.clean(htmlStr, Whitelist.none());
    }

    public void validateForbiddenChar(String forbiddenChar,String text) {
            if (!text.matches(forbiddenChar)){
                throw new ForbiddenCharException("invalid car exist in html");
            }
    }
}
