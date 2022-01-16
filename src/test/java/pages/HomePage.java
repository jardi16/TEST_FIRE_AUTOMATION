package pages;

import org.openqa.selenium.TimeoutException;

public class HomePage extends BasePage {

    String loginLink = "//a[@id='LoginLink']";

    public HomePage() {
        super(driver);
    }

    public void navigateToWeb() {

        navigateTo("https://demo.testfire.net");
    }

    public void enterLoginPage() {
        try {
            click(loginLink);
        } catch (TimeoutException e) {
            System.out.println("Web Element loginLink not found");
            e.printStackTrace();
        }
    }
}
