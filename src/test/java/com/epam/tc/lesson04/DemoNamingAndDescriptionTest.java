package com.epam.tc.lesson04;

import static io.qameta.allure.Allure.step;

import com.epam.tc.lesson04.utils.AttachmentUtils;
import io.qameta.allure.Description;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import lombok.SneakyThrows;
import org.apache.tika.io.IOUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoNamingAndDescriptionTest {

    public static final String CAT_URL =
        "https://upload.wikimedia.org/wikipedia/commons/b/b6/Felis_catus-cat_on_snow.jpg";

    @BeforeMethod
    public void setUp() {
        step("setup name");
    }

    @Test
    public void testWithoutTestName() {
        step("nop");
    }

    @Test(description = "This is test name (@Test)")
    @Description("This is test description (@Description")
    public void descriptionAnnotationJavadocDescriptionTest() {
        step("step 1");
    }

    @Test
    public void textAttachmentTest() {
        AttachmentUtils.attachString("attachment name",
            "attachment text");
    }

    @Test
    public void attachCollectionTestTest() {
        List<String> input = List.of("1", "a", "9t");
        AttachmentUtils.makeStringAttachment(input);
    }

    @SneakyThrows
    @Test
    public void attachCatPicture() {
        try (InputStream is = new URL(CAT_URL).openStream()) {
            AttachmentUtils.attachPngImage("Everybody loves cat", IOUtils.toByteArray(is));
        }
    }
}
