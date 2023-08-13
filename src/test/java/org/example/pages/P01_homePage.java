package org.example.pages;

import org.example.stepDefs.Hooks;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class P01_homePage {

    //Steps to read data from the testdata.json file
    JSONParser jsonParser = new JSONParser();
    FileReader reader = new FileReader("src/test/java/testData/testdata.json");
    Object object = jsonParser.parse(reader);
    JSONObject jsonObject=(JSONObject)object;

    String searchWord =(String) jsonObject.get("searchWord");
    String eBayUrl = (String) jsonObject.get("eBayUrl");
    JSONArray webElements = (JSONArray) jsonObject.get("webElements");
    JSONObject locators = (JSONObject) webElements.get(0);

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(2));

    public P01_homePage() throws ParseException, IOException {
    }


    public void homePageAssertUrl(){
        String currentUrl = Hooks.driver.getCurrentUrl();
        assertEquals(eBayUrl, currentUrl);
    }
    public void homePageSearch()
    {
        By searchBar = By.xpath((String) locators.get("searchBar"));
        By searchBtn = By.xpath((String) locators.get("searchBtn"));
        By helpMessageCloseBtn = By.className((String) locators.get("helpMessageCloseBtn"));
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        Hooks.driver.findElement(searchBar).sendKeys(searchWord);
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        Hooks.driver.findElement(searchBtn).click();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(helpMessageCloseBtn)).click();
        } catch (TimeoutException e) {
        }
    }
    public void homePageClickManualTransmissionButton()
    {
        By manualTransmissionBtn = By.xpath((String) locators.get("manualTransmissionBtn"));
        wait.until(ExpectedConditions.elementToBeClickable(manualTransmissionBtn));
        Hooks.driver.findElement(manualTransmissionBtn).click();
    }
    public void homePageValidateSearchResults()
    {
        By searchResults = By.xpath((String) locators.get("searchResults"));
        List<WebElement> elements = Hooks.driver.findElements(searchResults);
        assertTrue(elements.get(0).isDisplayed());
    }

    public void homePageLogSearchResults()
    {
        By searchResults = By.xpath((String) locators.get("searchResults"));
        List<WebElement> elements = Hooks.driver.findElements(searchResults);
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText());
        }
    }
}