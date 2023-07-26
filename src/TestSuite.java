import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestSuite extends BaseClass {
    //  1. Open the URL https://www.amazon.co.uk/
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void dellLaptop() {
        // pop-up handling
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();

        //  2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dell Laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();
        //  3. Click on the checkbox brand Dell on the left side.
        driver.findElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']")).click();
        //  4. Verify that the  30(Maybe different) products are displayed on the page.
        int expectedResult = 30;
        int actualResult = driver.findElements(By.xpath("//h2")).size();
        Assert.assertEquals(expectedResult, actualResult);
        //  5. Print all product names in the console.
        List<WebElement> PRODUCTName = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        System.out.println(PRODUCTName.size());
        for (WebElement product : PRODUCTName) {
            System.out.println(product.getText());
        }
        //  6. Click on the product name 'Dell Latitude 7420 Intel Core i5-1145G7 vPro 16GB RAM 256GB SSD 14" Ful HD Windows 10 Pro Laptop - CT22R
        driver.findElement(By.xpath("//a[@aria-label='Go to next page, page 2']//*[name()='svg']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Dell Latitude 7420 Intel Core i5-1145G7 vPro 16GB RAM 256GB SSD 14\" Ful HD Windows 10 Pro Laptop - CT22R']")).click();


    }

    //  5. Close the Browser.
    @After
    public void tearDown() {
        closeBrowser();
    }
}
