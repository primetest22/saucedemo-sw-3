package utilities;


import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    // this method will click on element
    public void clickOnElement(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }
    //this method will get text from element
    public String getTextFromElement(By by){
        return  driver.findElement(by).getText();
    }
    //this method will send text to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    /************** alerts methods *********************/
    //this method will switch to alert
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void dismissAlert(){

        driver.switchTo().alert().dismiss();
    }
    public void getTextFromAlert(){
        driver.switchTo().alert().getText();
    }
    public void sendKeysToAlert(){
        driver.switchTo().alert().sendKeys("india");
    }

    /******* select class methods ***********/
    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void selectByvalueDropDown(By by,String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);

    }
    public void selectByIndexFromDropDown(By by,int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    //********** mouse  methods *********/

    public void mouseHover(By by) throws InterruptedException {

        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHover).build().perform();
    }
    public void mouseHoverAndClick(By by) throws InterruptedException {

        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHover).click().build().perform();
    }

  public void verifyProducts(){

      int i;
      //create array to validate six products are present on page
      String[] products = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
              "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};

      for (i = 1; i < 7; i++) {

          //To verify element is present on page or not.
          String xPath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[" + i + "]";

          Boolean isElementPresent = driver.findElements(By.xpath(xPath)).size() != 0;

          if (isElementPresent == true) {
              System.out.println(i + " " + products[i - 1] + " is present");
          } else {
              System.out.print("\n" + i + " Product is Not Present On The Page");
          }
      }

  }






}
