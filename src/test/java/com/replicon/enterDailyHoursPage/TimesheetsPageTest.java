package com.replicon.enterDailyHoursPage;

import com.replicon.base.BaseTest;
import com.replicon.enterDailyHours.TimesheetsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimesheetsPageTest extends BaseTest {
    @Test(priority = 1)
    public void viewAllTimesheetsOfAnEmployeeTest() {
        TimesheetsPage timesheetsPage = PageFactory.initElements(driver, TimesheetsPage.class);
        timesheetsPage.viewAllTimesheetsOfAnEmployee();
        String recordsText = timesheetsPage.records();
        int timesheetCount = timesheetsPage.getTimesheets();
        Assert.assertEquals(recordsText,Integer.toString(timesheetCount));
    }
    @Test(priority = 2)
    public void viewOnlyNotSubmittedTimesheetsTest() {
        TimesheetsPage timesheetsPage = PageFactory.initElements(driver, TimesheetsPage.class);
        timesheetsPage.viewOnlyNotSubmittedTimesheets();
        String recordsText = timesheetsPage.notSubmittedTimesheets();
        int timesheetCount = timesheetsPage.getTimesheets();
        Assert.assertEquals(recordsText,Integer.toString(timesheetCount));
    }
    @Test(priority = 3)
    public void viewOnlyOverdueTimesheetsTest() {
        TimesheetsPage timesheetsPage = PageFactory.initElements(driver, TimesheetsPage.class);
        timesheetsPage.viewOnlyOverdueTimesheets();
        String recordsText = timesheetsPage.overdueTimesheets();
        int timesheetCount = timesheetsPage.getTimesheets();
        Assert.assertEquals(recordsText,Integer.toString(timesheetCount));
    }

    @Test(priority = 4)
    public void viewOnlyRejectedTimesheetsTest() {
        TimesheetsPage timesheetsPage = PageFactory.initElements(driver, TimesheetsPage.class);
        timesheetsPage.viewOnlyRejectedTimesheets();
        String recordsText = timesheetsPage.rejectedTimesheets();
        int timesheetCount = timesheetsPage.getTimesheets();
        Assert.assertEquals(recordsText,Integer.toString(timesheetCount));
    }

    @Test(priority = 4)
    public void viewOnlyWaitingForApprovalTimesheetsTest() {
        TimesheetsPage timesheetsPage = PageFactory.initElements(driver, TimesheetsPage.class);
        timesheetsPage.viewOnlyWaitingForApprovalTimesheets();
        String recordsText = timesheetsPage.waitingForApprovalTimesheets();
        int timesheetCount = timesheetsPage.getTimesheets();
        Assert.assertEquals(recordsText,Integer.toString(timesheetCount));
    }

    @Test(priority = 5)
    public void viewOnlyApprovedTimesheetsTest() {
        TimesheetsPage timesheetsPage = PageFactory.initElements(driver, TimesheetsPage.class);
        timesheetsPage.viewOnlyApprovedTimesheets();
        String recordsText = timesheetsPage.approvedTimesheets();
        int timesheetCount = timesheetsPage.getTimesheets();
        Assert.assertEquals(recordsText,Integer.toString(timesheetCount));
    }
}
