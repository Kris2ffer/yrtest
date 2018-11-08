import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YrHeader2 {
    public WebDriver driver;
    private String baseUrl;

    @FindBy(id = "sted")
    public WebElement inSearch;

    @FindBy(id = "queryknapp")
    public WebElement btnSearch;

    public YrHeader2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        baseUrl = "https://www.yr.no/";
        //driver.get(baseUrl);
    }

    public YrHeader2 enterPlaceName(String place) {
        inSearch.sendKeys(place);
        return this;
    }

    public SearchResultsPage2 enterPlaceNameAndHitEnter(String place) {
        enterPlaceName(place);
        inSearch.submit();
        return new SearchResultsPage2(driver);
    }

    public SearchResultsPage2 clickSearchButton() {
        btnSearch.click();
        return new SearchResultsPage2(driver);
    }
}