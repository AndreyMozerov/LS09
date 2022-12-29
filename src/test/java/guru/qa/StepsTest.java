package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class StepsTest {
    private static final String REPOZITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;
    @Test
    void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step ("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOZITORY, () ->{
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOZITORY);
            $(".header-search-input").submit();
        });
        step("Кликаем по вкладке репозитория" + REPOZITORY, () ->{
            $(linkText(REPOZITORY)).click();
        });

        step("Открываем tab Issues", () ->{
            $("#issues-tab").click();
        });
        step("ПРоверяем наличие Issue с номером" + ISSUE, () ->{
            $(withText("#"+ ISSUE)).should(visible);
        });
    }

    @Test
    public  void testAnnotatedStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOZITORY);
        steps.clickOnRepositoryLink(REPOZITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);

    }
}
