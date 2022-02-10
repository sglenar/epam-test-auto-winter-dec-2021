package com.epam.tc.lesson04;

import static io.qameta.allure.Allure.step;

import com.epam.tc.lesson04.utils.AttachmentUtils;
import io.qameta.allure.Description;
import java.net.URL;
import java.util.List;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
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
    public void testWithoutTestNameTakesNameFromMethod() {
        step("nop");
        Assertions.assertThat(2 * 2)
                  .isEqualTo(4);
    }

    @Test(description = "This is test name (@Test)")
    @Description("This is test description (@Description)")
    public void descriptionAnnotationJavadocDescriptionTest() {
        step("step 1");
        Assertions.assertThat("abacabadabacaba")
                  .containsIgnoringCase("aBAc")
                  .doesNotStartWith("alpha");
    }

    @Test
    public void textAttachmentTest() {
        AttachmentUtils.attachString("attachment name", "attachment text");
        Assertions.assertThat(0)
                  .isCloseTo(1, Offset.offset(2));
    }

    @Test
    public void attachCollectionTestTest() {
        List<String> input = List.of("1", "a", "9t");
        AttachmentUtils.makeStringAttachment(input);
        Assertions.assertThat(new int[] {1, 2, 3, 4, 1, 4})
                  .containsOnlyOnce(2, 3);
    }

    @SneakyThrows
    @Test
    public void attachCatPicture() {
        byte[] source = IOUtils.toByteArray(new URL(CAT_URL));
        AttachmentUtils.attachPngImage("Everybody loves cat", source);
        Assertions.assertThat(123)
                  .isEqualTo(123);
    }
}
