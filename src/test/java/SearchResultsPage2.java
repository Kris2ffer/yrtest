import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage2 extends YrHeader2 {
    //private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id='directories']/table[1]/tbody/tr[1]/td[2]/a")
    WebElement firstResult;

    public SearchResultsPage2(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PlacePage2 clickOnFirstResult() {
        firstResult.click();
        return new PlacePage2(driver);
    }
}
