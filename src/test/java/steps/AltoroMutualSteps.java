package steps;

import cucumber.api.java.en.*;
import org.junit.Assert;
import pages.*;

import java.util.concurrent.TimeUnit;


public class AltoroMutualSteps {


    HomePage home = new HomePage();
    LoginPage login = new LoginPage();
    MainPage main = new MainPage();
    TransferPage transfer = new TransferPage();

    @Given("^navego al portal de transferencias$")
    public void navigateToWeb(){
        home.navigateToWeb();
    }
    @And("^ingreso a la pagina de login$")
    public void enterLoginPage(){
        home.enterLoginPage();
    }
    @And("^me autentico correctamente con usuario valido$")
    public void loginValidUser(){
        login.loginValidUser("Jsmith","Demo1234");
    }
    @When("^ingreso a la opcion de transferencias$")
    public void clickTransferOption(){
        main.clickTransferOption();
    }
    @And("^selecciono las cuentas y (.+) a transferir$")
    public void enterTransferData(int amount) {
        transfer.enterTransferData("800003", "4539082039396288", amount);
    }

    @And("^presiono el boton de transferir$")
    public void transferMoney(){
        transfer.transferMoney();
    }
    @Then("^se observa confirmacion de la transferencia exitosa$")
    public void validateTransfer(){
        Assert.assertTrue("\nException: funds transfer error\n",transfer.validateTransfer().contains("successfully"));
    }
}
