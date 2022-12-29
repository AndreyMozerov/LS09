package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class AtachmentsTest {
    private static final String REPOZITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;
    @Test
    void testLambdaAtachments(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step ("Открываем главную страницу", () -> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });

    }

    @Test
    public  void testAnnotatedAttachments(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.takeScreenshot();

    }
}
