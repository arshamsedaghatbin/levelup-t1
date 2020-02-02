package com.example.tesk1.util;

import com.example.tesk1.exceptions.ForbiddenCharException;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;


public class SanitizerUtil {

    public static String removeHtmTag(String htmlStr){
       return Jsoup.clean(htmlStr, Whitelist.none());
    }

        public static void validateForbiddenChar(String text) {
            if (text.chars().mapToObj((c->(char) c)).anyMatch(c ->  c=='#' || c=='!'
                    || c=='@'|| c=='#' ||c=='$' || c=='%' || c=='^' || c=='&' || c== '*')){
                throw new ForbiddenCharException("invalid char in text");
            }
    }
}
