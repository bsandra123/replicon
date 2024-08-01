package com.replicon.bookTimeOff;

import com.replicon.base.WebPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewTimeOffRequestsPage extends WebPage {
    @FindBy(css = "div[id='ember46'] > form > button")
    protected WebElement bookTimeOffSection;
    @FindBy(css = "div[class='mdc-button__ripple']")
    protected WebElement allTimeOffBookings;
    @FindBy(css = "a[id='All'] > span:nth-child(2)")
    protected WebElement allRequests;
    @FindBy(css = "a[class='itemPosition']")
    protected WebElement typeOfLeave;
    @FindBy(css = "table[id='grid'] > tbody > tr:nth-child(2) > td > a")
    protected WebElement typeLeave;
    @FindBy(css = "li[class='last clickable'] > a")
    protected WebElement allBalances;
    @FindBy(css = "span[class='currentLocation']")
    protected WebElement balanceSummary;
    @FindBy(css = "th[id='grid_balance'] > div")
    protected WebElement currentBalance;
    @FindBy(css = "li[role='presentation'] > span > a")
    protected WebElement typeDropdown;
    @FindBy(css = "li[class='selected cursor'] > a")
    protected WebElement selectLeaveType;

    public ViewTimeOffRequestsPage(WebDriver driver) {
        super(driver);
    }

    public void viewAllTimeOffRequests() {
        bookTimeOffSection.click();
        allTimeOffBookings.click();
    }

    public String result() {
        return allRequests.getText();
    }

    public String leaveTypeCount() {
        String text = typeOfLeave.getText();
        return StringUtils.substringAfter(text, "/ ");
    }

    public void viewCurrentBalanceForAllMyTimeOffCategories() {
        bookTimeOffSection.click();
        allTimeOffBookings.click();
        allBalances.click();
    }

    public String currentBalanceResult() {
        String currentText = currentBalance.getText();
        return StringUtils.substringAfter(currentText, "t ");
    }

    public String balanceSummaryResult() {
        String balanceText = balanceSummary.getText();
        return StringUtils.substringBefore(balanceText, " S");
    }

    public void searchAndViewLeavesAppliedForInEachCategory() {
        bookTimeOffSection.click();
        allTimeOffBookings.click();
        pause(3);
        typeDropdown.click();
        waitForElementToBeVisible(selectLeaveType);
        selectLeaveType.click();
    }
}
