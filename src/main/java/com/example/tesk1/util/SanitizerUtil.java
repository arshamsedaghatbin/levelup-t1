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



    public static  String validateForbiddenChar(String text) {
        return text.codePoints()
                .filter(c -> (char) c != '&')
                .filter(c -> (char) c != '!')
                .filter(c -> (char) c != '@')
                .filter(c -> (char) c != '$')
                .filter(c -> (char) c != '%')
                .filter(c -> (char) c != '^')
                .filter(c -> (char) c != '*')
                .filter(c -> (char) c != '#')
                .collect(StringBuilder::new,            // supplier
                        StringBuilder::appendCodePoint, // accumulator
                        StringBuilder::append)            // combiner
                .toString();
    }
}
