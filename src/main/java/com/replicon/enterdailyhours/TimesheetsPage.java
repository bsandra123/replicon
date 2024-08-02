package com.replicon.enterdailyhours;

import com.replicon.base.WebPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimesheetsPage extends WebPage {
    @FindBy(css = "div[id='ember25'] > form > button")
    protected WebElement enterDailyHours;
    @FindBy(css = "span[class='mdc-button__ripple']")
    protected WebElement allTimesheetsButton;
    @FindBy(css = "a[id='All'] > span:nth-child(3)")
    protected WebElement allButton;
    @FindBy(css = "a[id='All'] > span:nth-child(2)")
    protected WebElement allRecords;
    @FindBy(css = "div[id='jqgh_grid_urn:replicon:timesheet-list-column:timesheet-period'] + a")
    protected WebElement timesheetsRecord;
    @FindBy(css = "div[id='toggleList'] > div:nth-child(2) > a > span:nth-child(3)")
    protected WebElement notSubmittedButton;
    @FindBy(css = "div[id='toggleList'] > div:nth-child(2) > a > span:nth-child(2)")
    protected WebElement notSubmittedRecords;
    @FindBy(css = "div[id='toggleList'] > div:nth-child(3) > a > span:nth-child(3)")
    protected WebElement overdueButton;
    @FindBy(css = "div[id='toggleList'] > div:nth-child(3) > a > span:nth-child(2)")
    protected WebElement overdueRecords;
    @FindBy(css = "div[id='toggleList'] > div:nth-child(4) > a > span:nth-child(3)")
    protected WebElement rejectedButton;
    @FindBy(css = "div[id='toggleList'] > div:nth-child(4) > a > span:nth-child(2)")
    protected WebElement rejectedRecords;
    @FindBy(css = "div[id='toggleList'] > div:nth-child(5) > a > span:nth-child(3)")
    protected WebElement waitingForApprovalButton;
    @FindBy(css = "div[id='toggleList'] > div:nth-child(5) > a > span:nth-child(2)")
    protected WebElement waitingForApprovalRecords;
    @FindBy(css = "div[id='toggleList'] > div:nth-child(6) > a > span:nth-child(3)")
    protected WebElement approvedButton;
    @FindBy(css = "div[id='toggleList'] > div:nth-child(6) > a > span:nth-child(2)")
    protected WebElement approvedRecords;
    @FindBy(css = "a[class='displayName']")
    protected WebElement timesheetPeriod;

    public TimesheetsPage(WebDriver driver) {
        super(driver);
    }

    public void viewAllTimesheetsOfAnEmployee() {
        waitForElementToBeVisible(enterDailyHours);
        enterDailyHours.click();
        allTimesheetsButton.click();
        allButton.click();
    }

    public int getTimesheets() {
        waitForElementToBeVisible(timesheetsRecord);
        String text = timesheetsRecord.getText().trim();
        return Integer.parseInt(StringUtils.substringAfter(text, "/").trim());
    }

    public String records() {
        return allRecords.getText();
    }

    public void viewOnlyNotSubmittedTimesheets() {
        waitForElementToBeVisible(enterDailyHours);
        enterDailyHours.click();
        allTimesheetsButton.click();
        notSubmittedButton.click();
    }

    public String notSubmittedTimesheets() {
        return notSubmittedRecords.getText();
    }

    public void viewOnlyOverdueTimesheets() {
        waitForElementToBeVisible(enterDailyHours);
        enterDailyHours.click();
        allTimesheetsButton.click();
        overdueButton.click();
    }

    public String overdueTimesheets() {
        return overdueRecords.getText();
    }

    public void viewOnlyRejectedTimesheets() {
        waitForElementToBeVisible(enterDailyHours);
        enterDailyHours.click();
        allTimesheetsButton.click();
        rejectedButton.click();
    }

    public String rejectedTimesheets() {
        return rejectedRecords.getText();
    }

    public void viewOnlyWaitingForApprovalTimesheets() {
        waitForElementToBeVisible(enterDailyHours);
        enterDailyHours.click();
        allTimesheetsButton.click();
        waitingForApprovalButton.click();
    }

    public String waitingForApprovalTimesheets() {
        return waitingForApprovalRecords.getText();
    }

    public void viewOnlyApprovedTimesheets() {
        waitForElementToBeVisible(enterDailyHours);
        enterDailyHours.click();
        allTimesheetsButton.click();
        approvedButton.click();
    }

    public String approvedTimesheets() {
        return approvedRecords.getText();
    }

    public String getTimesheetPeriod() {
        waitForElementToBeVisible(timesheetsRecord);
        String text = timesheetPeriod.getText().trim();
        return StringUtils.substringAfter(text, "-").trim();
    }
}




