import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PlacePage2 extends YrHeader2 {
    //WebDriver driver;

    @FindBy(how = How.CSS, using = ".yr-content-title.clearfix>h1>span>strong")
    private WebElement placeName;

    @FindBy(how = How.CSS, using = "#point>h2>strong")
    private WebElement hourByHourTitle;

    @FindBy(how = How.LINK_TEXT, using = "Time for time")
    private WebElement linkHourByHour;
    private WebElement linkHourByHourDetailed;

    @FindBy(how = How.LINK_TEXT, using = "Langtidsvarsel")
    private WebElement linkLongTerm;

    @FindBy(how = How.CLASS_NAME, using = "yr-icon-stats")
    private WebElement linkPastWeatherStats;
    private WebElement linkStatsDetails, linkStatsDateSearch, linkStatsClimate;

    @FindBy(how = How.CLASS_NAME, using = "yr-icon-radar")
    private WebElement linkWeatherRadar;


    public PlacePage2(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PlacePage2 clickOnHourByHourLink() {
        linkHourByHour.click();
        String detailedPath = "//*[@id='ctl00_ctl00_contentBody']/div[2]/div[1]/div/div[1]/ul/li[2]/ul/li/a";
        linkHourByHourDetailed = driver.findElement(By.xpath(detailedPath));
        return this;
    }

    public PlacePage2 clickOnLongTermLink() {
        linkLongTerm.click();
        return this;
    }

    public String getPlaceName() {
        return placeName.getText();
    }

    public String getHourByHourTitle() {
        return hourByHourTitle.getText();
    }

    public PlacePage2 clickOnHourByHourDetailsLink() {
        linkHourByHourDetailed.click();
        return this;
    }

    public PlacePage2 clickOnWeatherRadarLink() {
        linkWeatherRadar.click();
        return this;
    }

    public PlacePage2 clickOnPastWeatherStatsLink() {
        linkPastWeatherStats.click();
        linkStatsDetails = driver.findElement(By.linkText("Detaljert"));
        linkStatsDateSearch = driver.findElement(By.xpath("//a[contains(@href,'almanakk.html')]"));
        linkStatsClimate = driver.findElement(By.linkText("Klima"));
        return this;
    }

    public PlacePage2 clickOnStatsDetailsLink() {
        try {
            linkStatsDetails = driver.findElement(By.linkText("Detaljert"));
            linkStatsDetails.click();
        } catch (Exception e) { }
        return this;
    }

    public PlacePage2 clickOnStatsDateSearchLink() {
        try {
            linkStatsDateSearch = driver.findElement(By.xpath("//a[contains(@href,'almanakk.html')]"));
            linkStatsDateSearch.click();
        } catch (Exception e) { }
        return this;
    }

    public PlacePage2 clickOnStatsClimateLink() {
        try {
            linkStatsClimate = driver.findElement(By.linkText("Klima"));
            linkStatsClimate.click();
        } catch (Exception e) { }
        return this;
    }
}
