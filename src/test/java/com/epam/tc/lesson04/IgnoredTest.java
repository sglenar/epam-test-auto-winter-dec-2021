package com.epam.tc.lesson04;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/*
// Listener usage, Code configuration way
 @Listeners({ScreenshotListener.class})
*/
@Ignore
public class IgnoredTest {

    @Test
    public void driverAbsenceTest() {
        Assertions.assertThat((Object) null)
                  .isNull();
    }
}
