package pages;

import org.openqa.selenium.TimeoutException;

public class MainPage extends BasePage{

    String transferLink = "//a[@id='MenuHyperLink3']";

    public MainPage(){
        super(driver);
    }

    public void clickTransferOption(){
        try{
            click(transferLink);
        }catch (TimeoutException e){
            System.out.println("WebElement transferLink not found");
            e.printStackTrace();
        }

    }

}