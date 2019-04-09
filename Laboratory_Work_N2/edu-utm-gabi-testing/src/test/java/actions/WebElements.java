package actions;

import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.cssSelector;

public class WebElements extends PageObjects {


    @Getter
    @FindBy(xpath = "/html/body/div/div/div[1]/div[2]/button[3]")
    private WebElement europe;

    @Getter
    @FindBy(xpath = "//*[@id=\"exp-gridwall-wrapper\"]/div[2]/div[1]/div[3]/div[7]/div[2]/ul/a[9]")
    private WebElement redColor;

    @Getter
    @FindBy(xpath = "//*[@id=\"hotspot0\"]/a")
    private WebElement men;

    @Getter
    @FindBy(xpath = "/html/body/div/div/div[2]/div[3]/ul/li[22]/a")
    private WebElement romania;

    public WebElements(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getElementByName(String name) {
        switch (name) {
            case ("europe"):
                return getEurope();
            case ("romania"):
                return getRomania();
            case ("men"):
                return getMen();
            case ("redColor"):
                return getRedColor();
        }
        return null;
    }
}
