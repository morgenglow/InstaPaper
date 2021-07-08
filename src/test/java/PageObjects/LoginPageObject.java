package PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
    protected AppiumDriver driver;

    public LoginPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    //Ожидание элемента с указанием времени
    public WebElement waitForElement(By by, String errormessage, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(errormessage + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    //Ожидание с временем по умолчанию 5 секунд
    public WebElement waitForElement(By by, String errormessage) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.withMessage(errormessage + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    //Ожидание отсутствия элемента с временем по умолчанию 5 секунд
    public boolean waitForElementNotPresent(By by, String errormessage) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withMessage(errormessage + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    //Ожидание элемента с указанием времени
    public boolean waitForElementNotPresent(By by, String error_message, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    //Ожидание элемента и его очищение
    private WebElement waitForElementAndClear(By by, String error_message, long timeOutInSeconds) {
        WebElement element = waitForElement(by, error_message, timeOutInSeconds);
        element.clear();
        return element;
    }

    //Ожидание элемента и клик на него
    public WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElement(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    //Ожидание элемента и отправка данных
    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElement(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    //Ожидание элемента и отправка данных
    public void assertElementPresent(By by) {
        try {
            WebElement element = driver.findElement(by);
        } catch (org.openqa.selenium.NoSuchElementException exception) {
            throw new AssertionError("Element " + by.toString() + " Not found on the page");
        }
    }

    public void clickRegisterButton() {
        waitForElementAndClick(By.id("com.instapaper.android:id/show_signup_button"), "Can't find and click on Register button", 5);
    }

    public void clickSignInButton() {
        waitForElementAndClick(By.id("com.instapaper.android:id/show_login_button"), "Can't find and click on SignIn button", 5);
    }

    public void typeEmail(String email) {
        waitForElementAndSendKeys(By.id("com.instapaper.android:id/login_email"), email, "Can't send the email key", 5);
    }

    public void typePassword(String password) {
        waitForElementAndSendKeys(By.id("com.instapaper.android:id/login_password"), password, "Can't send the password key", 5);
    }

    public void clickSighUpOrSignIn() {
        waitForElementAndClick(By.id("com.instapaper.android:id/login_button"), "Can't find and click on Login button", 5);
    }

    public String getErrorTitleText(){
        return waitForElement(By.id("android:id/alertTitle"),"Can't find error window", 5).getText();
    }

    public void assertSignInPresent(){
        assertElementPresent(By.id("com.instapaper.android:id/login_button"));
    }
}
