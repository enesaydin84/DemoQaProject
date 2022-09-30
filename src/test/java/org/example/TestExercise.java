package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestExercise {
    //Driver tanımı
    WebDriver driver=new ChromeDriver();

    //gideceğimiz sayfa ve sayfanın ekranı kaplaması test başlamadan önce
    @BeforeMethod
    public void getPage()  {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

    }

    //Bir elemente doğru scroll işlemi
    public void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }


    public void testProcess() throws InterruptedException {
        //WebDriverWait wait=new WebDriverWait(driver,10);
        //WebElement btnJoinNow= driver.findElement(new By.ByCssSelector(".banner-image[alt='Selenium Online Training']"));
        //wait.until(ExpectedConditions.elementToBeClickable(btnJoinNow));
        //btnJoinNow.click();
    }

    //Anasayfadaki Elements linkine tıkla ve açılan sayfadan Textbox linkine tıkla
    public void scrollToAndClick(){
        WebElement elements=driver.findElement(new By.ByXPath("//h5[normalize-space()='Elements']"));
        scrollToElement(elements);
        elements.click();
        WebElement linkTextBox=driver.findElement( new By.ById("item-0"));
        scrollToElement(linkTextBox);
        linkTextBox.click();
    }
    //test süreci.asıl çalışan kodlar burada
    @Test
    public void formControl(){
        //formu doldur ve submit butonuna tıkla
        scrollToAndClick();
        WebElement txtUserName=driver.findElement(new By.ById("userName"));
        txtUserName.click();
        txtUserName.sendKeys("lkflslkrslkrs");
        WebElement txtUserEmail=driver.findElement(new By.ById("userEmail"));
        txtUserEmail.click();
        txtUserEmail.sendKeys("test@mail.com");
        WebElement txtAddress=driver.findElement(new By.ById("currentAddress"));
        txtAddress.click();
        txtAddress.sendKeys("lksfjşlsdşlsjdieşdişsişsşlfeşlsdkfşlsd");
        WebElement txtPaddress=driver.findElement(new By.ById("permanentAddress"));
        txtPaddress.click();
        txtPaddress.sendKeys("lksfjşlsdşlsjdieşdişsişsşlfeşlsdkfşlsd");
        WebElement btnSubmit=driver.findElement(new By.ById("submit"));
        scrollToElement(btnSubmit);
        btnSubmit.click();
        //p taglı elementte yazan değerin konsola yazdırılması
        WebElement pName= driver.findElement(new By.ByXPath("//div/p[@id='name']"));
        String name=pName.getText();
        System.out.println(name);
        //checkbox sayfası
        WebElement linkCheckBox=driver.findElement(new By.ById("item-1"));
        linkCheckBox.click();
        WebElement chckHome=driver.findElement(new By.ByCssSelector("label[for='tree-node-home'] span.rct-checkbox svg"));
        chckHome.click();
        chckHome=driver.findElement(new By.ByCssSelector("label[for='tree-node-home'] span.rct-checkbox svg"));
        String chckHomeClass=chckHome.getAttribute("class");
        if (chckHomeClass.equals("rct-icon rct-icon-check")){
            System.out.println("Checkbox is checked");
        }else {
            System.out.println("Checkbox is not checked");
        }
        //forms-practice form sayfasının açılması ve sportsCheckbox kontrolü
        WebElement formsLink=driver.findElement(new By.ByXPath("//div[normalize-space()='Forms']"));
        scrollToElement(formsLink);
        formsLink.click();
        WebElement practiceFormLink=driver.findElement(new By.ByXPath("//span[normalize-space()='Practice Form']"));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(practiceFormLink)).click();
        //practiceFormLink.click();
        WebElement sportsCheckBoxLabel=driver.findElement(new By.ByCssSelector("label[for='hobbies-checkbox-1']"));
        scrollToElement(sportsCheckBoxLabel);
        scrollToElement(sportsCheckBoxLabel);
        sportsCheckBoxLabel.click();
        boolean isEnabled=sportsCheckBoxLabel.isEnabled();
        WebElement sportCheckBox=driver.findElement(new By.ById("hobbies-checkbox-1"));
        if (isEnabled){
        try {
            sportCheckBox.click();
            System.out.println("Try block");
        }catch (ElementClickInterceptedException e){
            sportsCheckBoxLabel.click();
            System.out.println("Catch block");
        }
        }
        //Elements-Radio Button sayfasına yönlendirme ve işlemler.
        WebElement elements=driver.findElement(new By.ByXPath("(//div[contains(@class,'header-wrapper')])[1]"));
        //scrollToElement(elements);
        WebElement linkRadioButton=driver.findElement(new By.ByXPath("(//li[@id='item-2'])[1]"));
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(elements)).click();
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(linkRadioButton)).click();
        try {
            WebElement yesRadio=driver.findElement(new By.ById("yesRadio"));
            new WebDriverWait(driver,2).until(ExpectedConditions.elementToBeClickable(yesRadio)).click();
            System.out.println("Radio'ya tıkladı.");
            if (yesRadio.isSelected()){
                System.out.println("selected");
            }
        }catch (Exception e){
            WebElement yesRadioLabel=driver.findElement(new By.ByCssSelector("label[for='yesRadio']"));
            yesRadioLabel.click();
            System.out.println("Label'a tıkladı");
            WebElement afterClickRadioPtag=driver.findElement(new By.ByXPath("//p[@class='mt-3']"));
            Assert.assertTrue(afterClickRadioPtag.isDisplayed());
            }
        buttonsPageDoubleClickRightClick();
        findDynamicElement();
        gotoDynamicProperties();
        }
        //Buttons sayfası çift tıklama, sağ tıklama ve tıklama
    public void buttonsPageDoubleClickRightClick(){
        Actions action=new Actions(driver);
        WebElement linkButtons=driver.findElement(new By.ByXPath("(//li[@id='item-4'])[1]"));
        scrollToElement(linkButtons);
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(linkButtons)).click();
        WebElement btnDblClickButton=driver.findElement(new By.ByXPath("//button[@id='doubleClickBtn']"));
        action.doubleClick(btnDblClickButton).perform();
        WebElement dblClickMessage=driver.findElement(new By.ById("doubleClickMessage"));
        Assert.assertTrue(dblClickMessage.isDisplayed());
        System.out.println(dblClickMessage.getText());
        WebElement btnRightClick=driver.findElement(new By.ById("rightClickBtn"));
        action.contextClick(btnRightClick).perform();
        WebElement rightClickMessage=driver.findElement(new By.ById("rightClickMessage"));
        Assert.assertTrue(rightClickMessage.isDisplayed());
        System.out.println(rightClickMessage.getText());
    }
    //Dinamik element bulma ve click me butonuna tıklama
    public void findDynamicElement(){
        WebElement dynamicClickMeButton=driver.findElement(new By.ByXPath("//div/button[starts-with(text(),'Click Me')]"));
        dynamicClickMeButton.click();
        WebElement dynamicButtonMessage=driver.findElement(new By.ById("dynamicClickMessage"));
        Assert.assertTrue(dynamicButtonMessage.isDisplayed());
        System.out.println(dynamicButtonMessage.getText());
    }

    public void gotoDynamicProperties(){
        WebElement linkDynamicProperties=driver.findElement(new By.ByXPath("(//li[@id='item-8'])[1]"));
        scrollToElement(linkDynamicProperties);
        new WebDriverWait(driver,2).until(ExpectedConditions.elementToBeClickable(linkDynamicProperties)).click();
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }

}
