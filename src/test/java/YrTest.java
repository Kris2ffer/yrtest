import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YrTest {
    WebDriver driver;
    String baseUrl = "https://www.yr.no/";


    @BeforeTest
    public void setUp() {
        String geckoDriverPath = "C:\\Users\\Kris\\Downloads\\geckodriver-v0.18.0-win64\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", geckoDriverPath);

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSearch() {
        String expectedPlaceName = "Oslo";
        YrHeader yrHeader = new YrHeader(driver);
        String txtPlaceName = yrHeader.enterPlaceName(expectedPlaceName)
                .clickSearchButton()
                .clickOnFirstResult()
                .getPlaceName();

        // assert place name
        Assert.assertEquals(txtPlaceName, expectedPlaceName);
    }

    @Test
    public void testSearchAndHittingEnter() {
        String placeName = "Drammen";
        YrHeader yr = new YrHeader(driver);
        PlacePage place = yr.enterPlaceNameAndHitEnter(placeName).clickOnFirstResult();

        // find and assert place name
        String txtPlaceName = place.getPlaceName();
        Assert.assertEquals(txtPlaceName, placeName);
    }

    @Test
    public void testSearchAndNavigateLinks() {
        String placeName = "Oslo";
        YrHeader yrHeader = new YrHeader(driver);
        yrHeader.enterPlaceName(placeName);
        SearchResultsPage searchResult = yrHeader.clickSearchButton();
        PlacePage place = searchResult.clickOnFirstResult();

        // find and assert place name
        String txtPlaceName = place.getPlaceName();
        Assert.assertEquals(txtPlaceName, placeName);

        // navigate to hour by hour page and assert title
        place.clickOnHourByHourLink();
        String txtHourTitle = driver.findElement(By.cssSelector("#point>h2>strong")).getText();
        String expectedHourtitle = "Meteogram";
        Assert.assertEquals(txtHourTitle, expectedHourtitle);

        // navigate to to detailed page and assert title
        place.clickOnHourByHourDetailsLink();
        String txtHourDetailsTitle = driver.findElement(By.cssSelector("#detaljert>h2>strong")).getText();
        String expectedHourDetailstitle = "Detaljert meteogram";
        Assert.assertEquals(txtHourDetailsTitle, expectedHourDetailstitle);

        place.clickOnLongTermLink()
                .clickOnWeatherRadarLink()
                .clickOnPastWeatherStatsLink()
                .clickOnStatsDetailsLink()
                .clickOnStatsDateSearchLink()
                .clickOnStatsClimateLink();
    }


    @Test
    public void testSearchAndNavigateLinks2() {
        String placeName = "Oslo";
        driver.get(baseUrl);
        PlacePage2 place = new PlacePage2(driver)
                .enterPlaceName(placeName)
                .clickSearchButton()
                .clickOnFirstResult();

        // find and assert place name
        String txtPlaceName = place.getPlaceName();
        Assert.assertEquals(txtPlaceName, placeName);

        // navigate to hour by hour page and assert title
        place.clickOnHourByHourLink();
        Assert.assertEquals(place.getHourByHourTitle(), "Meteogram");

        // navigate to to detailed page and assert title
        place.clickOnHourByHourDetailsLink();
        String txtHourDetailsTitle = driver.findElement(By.cssSelector("#detaljert>h2>strong")).getText();
        String expectedHourDetailstitle = "Detaljert meteogram";
        Assert.assertEquals(txtHourDetailsTitle, expectedHourDetailstitle);

        place.clickOnLongTermLink()
                .clickOnWeatherRadarLink()
                .clickOnPastWeatherStatsLink()
                .clickOnStatsDetailsLink()
                .clickOnStatsDateSearchLink()
                .clickOnStatsClimateLink();
    }
}
