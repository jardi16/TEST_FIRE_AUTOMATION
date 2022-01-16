package pages;

import org.openqa.selenium.TimeoutException;

public class TransferPage extends BasePage{

    String fromDropDown = "//select[@id='fromAccount']";
    String toDropDown = "//select[@id='toAccount']";
    String amountBox = "//input[@id='transferAmount']";
    String transferButton = "//input[@id='transfer']";
    String transferResult = "//span[@style='color: Red']";

    public TransferPage(){
        super(driver);
    }

    public void enterTransferData(String from, String to, int amount){
        try{
            dropDown(fromDropDown,from);
            dropDown(toDropDown,to);
            String amountString = String.valueOf(amount);
            write(amountBox, amountString);
        }catch (TimeoutException e){
            System.out.println("Transfer WebElement not found");
            e.printStackTrace();
        }

    }
    public void transferMoney(){
        try{
            click(transferButton);
        }catch (TimeoutException e){
            System.out.println("Web Element transferButton not found");
        }

    }

    public String validateTransfer() {
        String result = null;
        try {
            result = getTextFromElement(transferResult);
        } catch (TimeoutException e) {
            System.out.println("Web element transferResult not found");
            e.printStackTrace();
        }
        return result;
    }
}
