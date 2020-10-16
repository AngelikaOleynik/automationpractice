package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateAccountPage{
    private WebDriver driver;

    //TODO: Personal info

    @FindBy(xpath = "//*[@id=\"noSlide\"]/h1")
    private WebElement headerCreateAnAccount;

    @FindBy(xpath = "//*[@id=\"id_gender1\"]")
    protected WebElement radioButtonMr;

    @FindBy(xpath = "//*[@id=\"id_gender2\"]")
    protected WebElement radioButtonMrs;

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private WebElement fieldFirstName;

    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    private WebElement fieldLastName;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement fieldEmail;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement fieldPassword;

    //TODO: Birth date

    @FindBy(xpath = "//*[@id=\"days\"]")
    private WebElement fieldDayOfBirth;

    @FindBy(xpath = "//*[@id=\"days\"]/option[5]")
    private WebElement dayOfBirth;

    @FindBy(xpath = "//*[@id=\"months\"]")
    private WebElement fieldMonthsOfBirth;

    @FindBy(xpath = "//*[@id=\"months\"]/option[4]")
    private WebElement monthOfBirth;

    @FindBy(xpath = "//*[@id=\"years\"]")
    private WebElement fieldYearsOfBirth;

    @FindBy(xpath = "//*[@id=\"years\"]/option[35]")
    private WebElement yearOfBirth;

    //TODO: Address

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement fieldFirstNameInAddress;

    @FindBy(xpath = "//*[@id=\"lastname\"]")
    private WebElement fieldLastNameInAddress;

    @FindBy(xpath = "//*[@id=\"company\"]")
    private WebElement fieldCompany;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement fieldAddress;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement fieldCity;

    @FindBy(css = "[id=\"id_state\"]")
    private WebElement fieldState;

    @FindBy(css = "[id=\"id_state\"] > option") //выбор штата
    private List<WebElement> fieldStateList;

    @FindBy(xpath = "//*[@id=\"postcode\"]")
    private WebElement fieldPostalCode;

    @FindBy(xpath = "//*[@id=\"id_country\"]")
    private WebElement fieldCountry;

    @FindBy(css = "[id=\"id_country\"]> option:nth-child(2)") // одна страна в выпадающем списке
    private WebElement countryUSA;

    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    private WebElement fieldMobilePhone;

    @FindBy(xpath = "//*[@id=\"alias\"]")
    private WebElement fieldAddressAlias;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]/span")
    private WebElement buttonRegister;

    public CreateAccountPage(WebDriver driver) {
      PageFactory.initElements(driver, this);
    }


    public CreateAccountPage checkPageAfterNegativeTry() {
        return this;
    }

    public CreateAccountPage clickRadioButtonMrs() {
        radioButtonMrs.click();
        return this;
    }

    public CreateAccountPage clickRadioButtonMr() {
        radioButtonMr.click();
        return this;
    }

    public CreateAccountPage typeFirstName(String firstName) {
        fieldFirstName.sendKeys(firstName);
        return this;
    }

    public CreateAccountPage typeLastName(String lastName) {
        fieldLastName.sendKeys(lastName);
        return this;
    }

    public CreateAccountPage typeEmail(String email) {
        fieldEmail.sendKeys(email);
        return this;
    }

    public CreateAccountPage typePassword(String password) {
        fieldPassword.sendKeys(password);
        return this;
    }

    public CreateAccountPage selectDateOfBirth(){
        fieldDayOfBirth.click();
        dayOfBirth.click();
        fieldMonthsOfBirth.click();
        monthOfBirth.click();
        fieldYearsOfBirth.click();
        yearOfBirth.click();
        return this;
    }

    public CreateAccountPage typeFirstNameInAddress(String firstnameInAddress) {
        fieldFirstNameInAddress.sendKeys(firstnameInAddress);
        return this;
    }

    public CreateAccountPage typeLastNameInAddress(String lastnameInAddress) {
        fieldLastNameInAddress.sendKeys(lastnameInAddress);
        return this;
    }


    public CreateAccountPage typeAddress(String addres) {
        fieldAddress.sendKeys(addres);
        return this;
    }

    public CreateAccountPage typeCity(String city) {
        fieldCity.sendKeys(city);
        return this;
    }

    public CreateAccountPage selectState() {
        fieldState.click();
        fieldStateList.get(6).click();
        return this;
    }

    public CreateAccountPage typePostalCode(String postalCode) {
        fieldPostalCode.sendKeys(postalCode);
        return this;
    }

    public CreateAccountPage selectCountry() {
        fieldCountry.click();
        countryUSA.click();
        return this;
    }

    public CreateAccountPage typeMobilePhone(String mobilePhone) {
        fieldMobilePhone.sendKeys(mobilePhone);
        return this;
    }

    public CreateAccountPage typeAliasAddress(String aliasAddress) {
        fieldAddressAlias.sendKeys(aliasAddress);
        return this;
    }

    public MyAccountPage clickRegisterButton() {
        buttonRegister.click();
        return new MyAccountPage(driver);
    }

    public String getHeaderCreateAccountPage(){
        return  headerCreateAnAccount.getText();
    }

}
