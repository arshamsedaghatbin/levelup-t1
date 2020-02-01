package com.example.tesk1.util;


import com.example.tesk1.exceptions.ForbiddenCharException;
import com.example.tesk1.service.TestData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class HtmlUtilTest extends TestData {

    @Test
    void html_remove_tag(){
        assertEquals(SanitizerUtil.removeHtmTag(strHTML),result);
    }

    @Test
    void html_forbidden_char(){
        assertThrows(ForbiddenCharException.class, () -> {
            SanitizerUtil.validateForbiddenChar("testi&ii");
        });
    }
}
