package pages;

import org.openqa.selenium.TimeoutException;

public class LoginPage extends BasePage {

    String userBox = "//input[@id='uid']";
    String passBox = "//input[@id='passw']";
    String loginButton = "//input[@name ='btnSubmit']";

    public LoginPage(){
        super(driver);
    }

    public void loginValidUser(String user,String pass){
        try{
            write(userBox,user);
            write(passBox,pass);
            click(loginButton);
        }catch (TimeoutException e){
            System.out.println("Login Web Element not found");
            e.printStackTrace();
        }

    }

}
