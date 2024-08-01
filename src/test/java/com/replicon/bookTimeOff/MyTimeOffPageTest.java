package com.replicon.bookTimeOff;

import com.replicon.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTimeOffPageTest extends BaseTest {

    @Test(priority = 1)
    public void bookTimeOffFromMyTimeOffTest() {
        MyTimeOffPage myTimeOffPage = PageFactory.initElements(driver, MyTimeOffPage.class);
        int requestsBeforeCount = myTimeOffPage.beforeCount();
        myTimeOffPage.bookTimeOffFromMyTimeOff();
        int requestsAfterCount = myTimeOffPage.afterCount();
        Assert.assertTrue(requestsBeforeCount < requestsAfterCount);
    }

    @Test(priority = 2)
    public void bookTimeOffFromMyTimeOffByPlusIcon() {
        MyTimeOffPage myTimeOffPage = PageFactory.initElements(driver, MyTimeOffPage.class);
        int requestsBeforeCount = myTimeOffPage.beforeCount();
        myTimeOffPage.bookTimeOffFromMyTimeOffByPlusIcon();
        int requestsAfterCount = myTimeOffPage.afterCount();
        Assert.assertTrue(requestsBeforeCount < requestsAfterCount);
    }

    @Test(priority = 3)
    public void bookTimeOffByAllTimeOffBookingsTest() {
        MyTimeOffPage myTimeOffPage = PageFactory.initElements(driver, MyTimeOffPage.class);
        int requestsBeforeCount = myTimeOffPage.beforeCount();
        myTimeOffPage.bookTimeOffByAllTimeOffBookings();
        int requestsAfterCount = myTimeOffPage.allTimeOffBookingsAfterCount();
        Assert.assertTrue(requestsBeforeCount < requestsAfterCount);
    }

    @Test(priority = 4)
    public void bookTimeOffThroughCalendarTest() {
        MyTimeOffPage myTimeOffPage = PageFactory.initElements(driver, MyTimeOffPage.class);
        int requestsBeforeCount = myTimeOffPage.beforeCount();
        myTimeOffPage.bookTimeOffThroughCalendar();
        int requestsAfterCount = myTimeOffPage.allTimeOffBookingsAfterCount();
        Assert.assertTrue(requestsBeforeCount < requestsAfterCount);
    }

}
