package com.replicon.booktimeoff;

import com.replicon.base.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyTimeOffPage extends WebPage {
    @FindBy(css = "div[id='ember46'] > form > button")
    protected WebElement bookTimeOffSection;
    @FindBy(css = "div[class='mdc-button__ripple']")
    protected WebElement allTimeOffBookingsButton;
    @FindBy(css = "a[class='fakeButtonBase cardAddBooking'] > span")
    protected WebElement bookTimeOffButton;
    @FindBy(css = "li[class='timeOffType enableSearchForSelect'] > span:nth-child(3) > span:first-child > " + "span:nth-child(1) > span:nth-child(2)")
    protected WebElement leaveTypeDropdown;
    @FindBy(css = "input[id='startDate']")
    protected WebElement startDateField;
    @FindBy(css = "tbody[role='application'] > tr:nth-child(5) > td:nth-child(5) > a")
    protected WebElement startDateElement;
    @FindBy(css = "input[id='endDate']")
    protected WebElement endDateField;
    @FindBy(css = "tbody[role='application'] > tr:first-child > td:nth-child(6) > a")
    protected WebElement endDateElement;
    @FindBy(css = "input[id='timeOffSubmit']")
    protected WebElement submitForApprovalButton;
    @FindBy(css = "a[id='All'] > span:nth-child(2)")
    protected WebElement beforeCountOfAllRequests;
    @FindBy(css = "ul[class='select2-results__options'] > li:first-child")
    protected WebElement leaveType;
    @FindBy(css = "a[id='substituteBannerActionButton']")
    protected WebElement returnToMenuButton;
    @FindBy(css = "i[class='material-icons iconAddBooking']")
    protected WebElement plusIcon;
    @FindBy(css = "button[id='bookTimeOffBtn']")
    protected WebElement timeOffButton;
    @FindBy(css = "li[id='calenderTab'] > a")
    protected WebElement calendar;
    @FindBy(css = "table[class='fc-border-separate'] > tbody > tr:nth-child(2) > td:nth-child(2) > div > div:nth-child(1)")
    protected WebElement dateRangeSelector;

    public MyTimeOffPage(WebDriver driver) {
        super(driver);
    }

    /*
    * This method will test the "Time off" booking from the "My Time off" page by,
    * */
    public void bookTimeOffFromMyTimeOff() {

        returnToMenuButton.click();
        bookTimeOffSection.click();
        bookTimeOffButton.click();
        waitForElementToBeVisible(leaveTypeDropdown);
        leaveTypeDropdown.click();

        waitForElementToBeVisible(leaveType);
        leaveType.click();
        pause(3);
        startDateField.click();
        waitForElementToBeClickable(startDateElement);
        startDateElement.click();
        endDateField.click();
        waitForElementToBeClickable(endDateElement);
        endDateElement.click();
        submitForApprovalButton.click();
    }

    public int getInitialCount() {
        bookTimeOffSection.click();
        allTimeOffBookingsButton.click();
        return Integer.parseInt(beforeCountOfAllRequests.getText());
    }

    public int getUpdatedCount() {
        pause(3);
        allTimeOffBookingsButton.click();
        return Integer.parseInt(beforeCountOfAllRequests.getText());
    }

    public int getAllTimeOffBookingsUpdatedCount() {
        pause(2);
        returnToMenuButton.click();
        bookTimeOffSection.click();
        allTimeOffBookingsButton.click();
        return Integer.parseInt(beforeCountOfAllRequests.getText());
    }

    public void bookTimeOffByPlusIcon() {
        returnToMenuButton.click();
        bookTimeOffSection.click();
        plusIcon.click();
        leaveTypeDropdown.click();
        waitForElementToBeVisible(leaveType);
        leaveType.click();
        startDateField.click();
        waitForElementToBeClickable(startDateElement);
        startDateElement.click();
        endDateField.click();
        waitForElementToBeClickable(endDateElement);
        endDateElement.click();
        submitForApprovalButton.click();
    }

    public void bookTimeOffByAllTimeOffBookings() {
        returnToMenuButton.click();
        bookTimeOffSection.click();
        allTimeOffBookingsButton.click();
        timeOffButton.click();
        leaveTypeDropdown.click();
        waitForElementToBeVisible(leaveType);
        leaveType.click();
        startDateField.click();
        waitForElementToBeClickable(startDateElement);
        startDateElement.click();
        endDateField.click();
        waitForElementToBeClickable(endDateElement);
        endDateElement.click();
        submitForApprovalButton.click();
    }

    public void bookTimeOffThroughCalendar() {
        returnToMenuButton.click();
        bookTimeOffSection.click();
        allTimeOffBookingsButton.click();
        calendar.click();
        waitForElementToBeVisible(dateRangeSelector);
        dateRangeSelector.click();
        leaveTypeDropdown.click();
        waitForElementToBeVisible(leaveType);
        leaveType.click();
        startDateField.click();
        waitForElementToBeClickable(startDateElement);
        startDateElement.click();
        endDateField.click();
        waitForElementToBeClickable(endDateElement);
        endDateElement.click();
        submitForApprovalButton.click();
    }


}
