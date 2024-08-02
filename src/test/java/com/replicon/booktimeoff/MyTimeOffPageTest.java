package com.replicon.booktimeoff;

import com.replicon.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTimeOffPageTest extends BaseTest {

    @Test(priority = 1)
    public void bookTimeOffFromMyTimeOffTest() {
        MyTimeOffPage myTimeOffPage = PageFactory.initElements(driver, MyTimeOffPage.class);
        int requestsBeforeCount = myTimeOffPage.getInitialCount();
        myTimeOffPage.bookTimeOffFromMyTimeOff();
        int requestsAfterCount = myTimeOffPage.getUpdatedCount();
        Assert.assertTrue(requestsBeforeCount < requestsAfterCount);
    }

    @Test(priority = 2)
    public void bookTimeOffByPlusIcon() {
        MyTimeOffPage myTimeOffPage = PageFactory.initElements(driver, MyTimeOffPage.class);
        int requestsBeforeCount = myTimeOffPage.getInitialCount();
        myTimeOffPage.bookTimeOffByPlusIcon();
        int requestsAfterCount = myTimeOffPage.getUpdatedCount();
        Assert.assertTrue(requestsBeforeCount < requestsAfterCount);
    }

    @Test(priority = 3)
    public void bookTimeOffByAllTimeOffBookingsTest() {
        MyTimeOffPage myTimeOffPage = PageFactory.initElements(driver, MyTimeOffPage.class);
        int requestsBeforeCount = myTimeOffPage.getInitialCount();
        myTimeOffPage.bookTimeOffByAllTimeOffBookings();
        int requestsAfterCount = myTimeOffPage.getAllTimeOffBookingsUpdatedCount();
        Assert.assertTrue(requestsBeforeCount < requestsAfterCount);
    }

    @Test(priority = 4)
    public void bookTimeOffThroughCalendarTest() {
        MyTimeOffPage myTimeOffPage = PageFactory.initElements(driver, MyTimeOffPage.class);
        int requestsBeforeCount = myTimeOffPage.getInitialCount();
        myTimeOffPage.bookTimeOffThroughCalendar();
        int requestsAfterCount = myTimeOffPage.getAllTimeOffBookingsUpdatedCount();
        Assert.assertTrue(requestsBeforeCount < requestsAfterCount);
    }

}
