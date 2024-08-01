package com.replicon.bookTimeOff;

import com.replicon.base.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyTimeOffPage extends WebPage {
    @FindBy(css = "div[id='ember46'] > form > button")
    protected WebElement bookTimeOffSection;
    @FindBy(css = "div[class='mdc-button__ripple']")
    protected WebElement allTimeOffBookings;
    @FindBy(css = "a[class='fakeButtonBase cardAddBooking'] > span")
    protected WebElement bookTimeOffButton;
    @FindBy(css = "li[class='timeOffType enableSearchForSelect'] > span:nth-child(3) > span:first-child > " +
                    "span:nth-child(1) > span:nth-child(2)")
    protected WebElement typeDropdown;
    @FindBy(css = "ul[class='select2-results__options'] > li:first-child")
    protected WebElement selectLeaveType;
    @FindBy(css = "input[id='startDate']")
    protected WebElement startDateField;
    @FindBy(css = "tbody[role='application'] > tr:nth-child(5) > td:nth-child(5) > a")
    protected WebElement selectStartDate;
    @FindBy(css = "input[id='endDate']")
    protected WebElement endDateField;
    @FindBy(css = "tbody[role='application'] > tr:first-child > td:nth-child(6) > a")
    protected WebElement selectEndDate;
    @FindBy(css = "input[id='timeOffSubmit']")
    protected WebElement submitForApproval;
    @FindBy(css = "a[id='All'] > span:nth-child(2)")
    protected WebElement beforeCountOfAllRequests;
    @FindBy(css = "ul[class='select2-results__options'] > li:first-child")
    protected WebElement leaveType;
    @FindBy(css = "a[id='substituteBannerActionButton']")
    protected WebElement returnToMenu;
    @FindBy(css = "i[class='material-icons iconAddBooking']")
    protected WebElement plusIcon;
    @FindBy(css = "button[id='bookTimeOffBtn']")
    protected WebElement timeOffButton;
    @FindBy(css = "li[id='calenderTab'] > a")
    protected WebElement calendar;
    @FindBy(css = "table[class='fc-border-separate'] > tbody > tr:nth-child(2) > td:nth-child(2) > div > div:nth-child(1)")
    protected WebElement selectDateFromCalendar;

    public MyTimeOffPage(WebDriver driver) {
        super(driver);
    }

    public void bookTimeOffFromMyTimeOff() {
        returnToMenu.click();
        bookTimeOffSection.click();
        bookTimeOffButton.click();
        waitForElementToBeVisible(typeDropdown);
        typeDropdown.click();
        waitForElementToBeVisible(selectLeaveType);
        selectLeaveType.click();
        startDateField.click();
        waitForElementToBeClickable(selectStartDate);
        selectStartDate.click();
        endDateField.click();
        waitForElementToBeClickable(selectEndDate);
        selectEndDate.click();
        submitForApproval.click();
        pause(3);
    }

    public int beforeCount() {
        bookTimeOffSection.click();
        allTimeOffBookings.click();
        return Integer.parseInt(beforeCountOfAllRequests.getText());
    }

    public int afterCount() {
        pause(3);
        allTimeOffBookings.click();
        return Integer.parseInt(beforeCountOfAllRequests.getText());
    }

    public int allTimeOffBookingsAfterCount() {
        pause(3);
        returnToMenu.click();
        pause(2);
        bookTimeOffSection.click();
        allTimeOffBookings.click();
        return Integer.parseInt(beforeCountOfAllRequests.getText());
    }

    public void bookTimeOffFromMyTimeOffByPlusIcon() {
        returnToMenu.click();
        bookTimeOffSection.click();
        plusIcon.click();
        waitForElementToBeVisible(typeDropdown);
        typeDropdown.click();
        waitForElementToBeVisible(leaveType);
        leaveType.click();
        startDateField.click();
        waitForElementToBeClickable(selectStartDate);
        selectStartDate.click();
        endDateField.click();
        waitForElementToBeClickable(selectEndDate);
        selectEndDate.click();
        submitForApproval.click();
    }

    public void bookTimeOffByAllTimeOffBookings() {
        returnToMenu.click();
        bookTimeOffSection.click();
        allTimeOffBookings.click();
        timeOffButton.click();
        waitForElementToBeVisible(typeDropdown);
        typeDropdown.click();
        waitForElementToBeVisible(leaveType);
        leaveType.click();
        startDateField.click();
        waitForElementToBeClickable(selectStartDate);
        selectStartDate.click();
        endDateField.click();
        waitForElementToBeClickable(selectEndDate);
        selectEndDate.click();
        submitForApproval.click();
    }

    public void bookTimeOffThroughCalendar() {
        returnToMenu.click();
        bookTimeOffSection.click();
        allTimeOffBookings.click();
        calendar.click();
        waitForElementToBeVisible(selectDateFromCalendar);
        selectDateFromCalendar.click();
        waitForElementToBeVisible(typeDropdown);
        typeDropdown.click();
        waitForElementToBeVisible(leaveType);
        leaveType.click();
        startDateField.click();
        waitForElementToBeClickable(selectStartDate);
        selectStartDate.click();
        endDateField.click();
        waitForElementToBeClickable(selectEndDate);
        selectEndDate.click();
        submitForApproval.click();
    }
}
