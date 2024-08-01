package com.replicon.bookTimeOff;

import com.replicon.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTimeOffPageTest extends BaseTest {

    @Test(priority = 1)
    public void bookTimeOffFromMyTimeOffTest() {
        MyTimeOffPage myTimeOffPage = PageFactory.initElements(driver, MyTimeOffPage.class);
        int requestsBeforeCount = myTimeOffPage.getBeforeCount();
        myTimeOffPage.bookTimeOffFromMyTimeOff();
        int requestsAfterCount = myTimeOffPage.getAfterCount();
        Assert.assertTrue(requestsBeforeCount < requestsAfterCount);
    }

    @Test(priority = 2)
    public void bookTimeOffFromMyTimeOffByPlusIcon() {
        MyTimeOffPage myTimeOffPage = PageFactory.initElements(driver, MyTimeOffPage.class);
        int requestsBeforeCount = myTimeOffPage.getBeforeCount();
        myTimeOffPage.bookTimeOffFromMyTimeOffByPlusIcon();
        int requestsAfterCount = myTimeOffPage.getAfterCount();
        Assert.assertTrue(requestsBeforeCount < requestsAfterCount);
    }

    @Test(priority = 3)
    public void bookTimeOffByAllTimeOffBookingsTest() {
        MyTimeOffPage myTimeOffPage = PageFactory.initElements(driver, MyTimeOffPage.class);
        int requestsBeforeCount = myTimeOffPage.getBeforeCount();
        myTimeOffPage.bookTimeOffByAllTimeOffBookings();
        int requestsAfterCount = myTimeOffPage.getAllTimeOffBookingsAfterCount();
        Assert.assertTrue(requestsBeforeCount < requestsAfterCount);
    }

    @Test(priority = 4)
    public void bookTimeOffThroughCalendarTest() {
        MyTimeOffPage myTimeOffPage = PageFactory.initElements(driver, MyTimeOffPage.class);
        int requestsBeforeCount = myTimeOffPage.getBeforeCount();
        myTimeOffPage.bookTimeOffThroughCalendar();
        int requestsAfterCount = myTimeOffPage.getAllTimeOffBookingsAfterCount();
        Assert.assertTrue(requestsBeforeCount < requestsAfterCount);
    }

}
