package com.replicon.booktimeoff;

import com.replicon.base.WebPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewTimeOffRequestsPage extends WebPage {

    @FindBy(css = "div[id='ember46'] > form > button")
    protected WebElement bookTimeOffSection;

    @FindBy(css = "div[class='mdc-button__ripple']")
    protected WebElement allTimeOffBookingsButton;

    @FindBy(css = "a[id='All'] > span:nth-child(3)")
    protected WebElement allRequestsButton;

    @FindBy(css = "a[id='All'] > span:nth-child(2)")
    protected WebElement allRequestsCount;

    @FindBy(css = "th[id='grid_urn:replicon:time-off-list-column:time-off-type'] > a:nth-child(3)")
    protected WebElement leaveType;

    @FindBy(css = "table[id='grid'] > tbody > tr:nth-child(2) > td > a")
    protected WebElement searchLeaveType;

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

    @FindBy(css = "div[id='toggleList'] > div:nth-child(2) > a")
    protected WebElement rejectedButton;

    @FindBy(css = "a[id='sysGeneratedListFilter1urn:replicon:time-off-booking-status:rejected'] > span:nth-child(2)")
    protected WebElement rejectedRequests;

    @FindBy(css = "a[title='Jump to Row']")
    protected WebElement rejectedLeaveType;

    @FindBy(css = "a[id='sysGeneratedListFilter2urn:replicon:time-off-booking-status:waiting'] > span:nth-child(3)")
    protected WebElement waitingForApprovalButton;

    @FindBy(css = "a[id='sysGeneratedListFilter2urn:replicon:time-off-booking-status:waiting'] > span:nth-child(2)")
    protected WebElement waitingRequestsCount;

    @FindBy(css = "a[id='sysGeneratedListFilter2urn:replicon:time-off-booking-status:waiting'] > span:nth-child(3)")
    protected WebElement approvedButton;

    @FindBy(css = "a[id='sysGeneratedListFilter2urn:replicon:time-off-booking-status:waiting'] > span:nth-child(2)")
    protected WebElement approvedRequestsCount;

    public ViewTimeOffRequestsPage(WebDriver driver) {
        super(driver);
    }

    public void viewAllTimeOffRequests() {
        bookTimeOffSection.click();
        allTimeOffBookingsButton.click();
        waitForElementToBeVisible(allRequestsButton);
        allRequestsButton.click();
    }

    public String getResult() {
        return allRequestsCount.getText();
    }

    public String getLeaveTypeCountForAllRequests() {
        pause(3);
        String text = leaveType.getText();
        return StringUtils.substringAfter(text, "/ ");
    }

    public void viewCurrentBalanceForAllMyTimeOffCategories() {
        bookTimeOffSection.click();
        allTimeOffBookingsButton.click();
        allBalances.click();
    }

    public String getCurrentBalanceResult() {
        String currentText = currentBalance.getText();
        return StringUtils.substringAfter(currentText, "t ");
    }

    public String getBalanceSummaryResult() {
        String balanceText = balanceSummary.getText();
        return StringUtils.substringBefore(balanceText, " S");
    }

    public void searchAndViewLeavesAppliedInEachCategory() {
        bookTimeOffSection.click();
        allTimeOffBookingsButton.click();
        pause(3);
        typeDropdown.click();
        waitForElementToBeVisible(selectLeaveType);
        selectLeaveType.click();
    }

    public void viewRejectedTimeOffRequests() {
        bookTimeOffSection.click();
        allTimeOffBookingsButton.click();
        rejectedButton.click();
    }
    public String getRejectedRequestsCount() {
         return rejectedRequests.getText();
    }

    public String getLeaveTypeCount() {
        waitForElementToBeVisible(rejectedLeaveType);
        String text = rejectedLeaveType.getText();
        return StringUtils.substringAfter(text,"/ ");
    }

    public void viewWaitingForApprovalRequests() {
        bookTimeOffSection.click();
        allTimeOffBookingsButton.click();
        waitingForApprovalButton.click();
    }

    public String getWaitingRequestsCount() {
        return waitingRequestsCount.getText();
    }

    public void viewApprovedRequests() {
        bookTimeOffSection.click();
        allTimeOffBookingsButton.click();
        approvedButton.click();
    }

    public String getApprovedCount() {
        return approvedRequestsCount.getText();
    }


}
