package com.example.tesk1.util;


import com.example.tesk1.service.TestData;
import com.example.tesk1.util.HtmlUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HtmlUtilTest extends TestData {

    @Test
    void html_remove_tag(){
        assertEquals(HtmlUtil.removeHtmTag(strHTML),result);
    }
}
