import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YrHeader {
    public WebDriver driver;
    private String baseUrl;

    @FindBy(id = "sted")
    private WebElement inSearch;

    @FindBy(id = "queryknapp")
    private WebElement btnSearch;

    public YrHeader(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        baseUrl = "https://www.yr.no/";
        driver.get(baseUrl);
    }

    public YrHeader enterPlaceName(String place) {
        inSearch.sendKeys(place);
        return this;
    }

    public SearchResultsPage enterPlaceNameAndHitEnter(String place) {
        enterPlaceName(place);
        inSearch.submit();
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage clickSearchButton() {
        btnSearch.click();
        return new SearchResultsPage(driver);
    }
}
