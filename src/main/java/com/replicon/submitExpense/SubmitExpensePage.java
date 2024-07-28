package com.replicon.submitExpense;

import com.replicon.base.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SubmitExpensePage extends WebPage {
    @FindBy(css = "div[id='ember43'] > form > button")
    protected WebElement submitExpense;
    @FindBy(css = "input[id='addNewExpenseButton']")
    protected WebElement addExpense;
    @FindBy(css = "input[id='expenseDescription']")
    protected WebElement descriptionField;
    @FindBy(css = "a[class='divDropdown drpdwnMargin']")
    protected WebElement project;
    @FindBy(xpath = "//a[text()='Administration']")
    protected WebElement administrationOption;
    @FindBy(css = "table[class='dataGrid dataGridSilent'] > tbody > tr:nth-child(1) > td:nth-child(2) > input")
    protected WebElement dateIncurred;
    @FindBy(css = "a[value='2024-07-02']")
    protected WebElement selectDate;
    @FindBy(css = "input[id^='description_n0']")
    protected WebElement descriptionColumn;
    @FindBy(css = "select[id^='expenseType_n0'] > option:nth-child(2)")
    protected WebElement type;
    @FindBy(css = "input[id='amount_n0']")
    protected WebElement amount;
    @FindBy(css = "button[title='Submit']")
    protected WebElement submitButton;

    public SubmitExpensePage(WebDriver driver) {
        super(driver);
    }

    public void goToAddExpense() {
        pause(3);
        WebElement submitExpensesButton = driver.findElement(By.cssSelector("div[id='ember43'] > form > button"));
        submitExpensesButton.click();
        pause(1);
        WebElement addExpensesButton = driver.findElement(By.cssSelector("input[id='addNewExpenseButton"));
        addExpensesButton.click();
    }

    public void addExpense(String descriptionField, String descriptionColumn, String amount) {
        pause(2);
        this.descriptionField.sendKeys(descriptionField);
        pause(2);
        project.click();
        pause(1);
        administrationOption.click();
        pause(1);
        dateIncurred.click();
        pause(1);
        selectDate.click();
        pause(1);
        this.descriptionColumn.sendKeys(descriptionColumn);
        pause(1);
        type.click();
        pause(1);
        this.amount.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        this.amount.sendKeys(Keys.DELETE);
        this.amount.sendKeys(amount);
        pause(1);
        submitButton.click();
        pause(1);
    }

    public String result() {
        pause(5);
        WebElement cellInLastRow = driver.findElement(By.cssSelector("table[class='ui-jqgrid-btable'] > tbody >" + " tr:last-child > td:nth-child(4)"));
        return cellInLastRow.getText();
    }


}
