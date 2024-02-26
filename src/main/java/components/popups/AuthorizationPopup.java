package components.popups;

import common.AbsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class AuthorizationPopup extends AbsCommon implements IPopup {
    private String authPopupSelector = "#__PORTAL__ > div";
    private String login = System.getProperty("login");
    private String password = System.getProperty("password");

    public AuthorizationPopup(WebDriver driver) {

        super(driver);
    }
    @Override
    public void popupShouldBeVisible() {
        waitTools.waitElementPresent(By.cssSelector(authPopupSelector));
    }

    @Override
    public void popupShouldNotBeVisible() {
        waitTools.waitNotElementPresent(By.cssSelector(authPopupSelector));
    }

    public void enterEmail() {
        this.driver.findElement(By.xpath("//div[./input[@name='email']]")).click();
        WebElement mailClick = this.driver.findElement(By.xpath("//input[@name='email']"));
        this.waitTools.waitForCondition(ExpectedConditions.visibilityOf(mailClick));
        mailClick.sendKeys(login);
    }

    public void enterPassword() {
        this.driver.findElement(By.xpath("//div[./input[@type='password']]")).click();
        this.driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
    }

    public void enterLoginButton() {

        this.driver.findElement(By.cssSelector("#__PORTAL__ button")).click();
    }
}