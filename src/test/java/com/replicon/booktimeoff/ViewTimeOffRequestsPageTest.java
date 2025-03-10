package com.replicon.booktimeoff;

import com.replicon.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewTimeOffRequestsPageTest extends BaseTest {

    @Test(priority = 1)
    public void viewAllTimeOffRequestsTest() {
        ViewTimeOffRequestsPage viewTimeOffRequestsPage = PageFactory.initElements(driver, ViewTimeOffRequestsPage.class);
        viewTimeOffRequestsPage.viewAllTimeOffRequests();
        Assert.assertEquals(viewTimeOffRequestsPage.getResult(),viewTimeOffRequestsPage.getLeaveTypeCountForAllRequests());
    }

    @Test(priority = 2)
    public void viewCurrentBalanceForAllMyTimeOffCategoriesTest() {
        ViewTimeOffRequestsPage viewTimeOffRequestsPage = PageFactory.initElements(driver, ViewTimeOffRequestsPage.class);
        viewTimeOffRequestsPage.viewCurrentBalanceForAllMyTimeOffCategories();
        String balanceResult = viewTimeOffRequestsPage.getBalanceSummaryResult();
        String currentResult = viewTimeOffRequestsPage.getCurrentBalanceResult();
        Assert.assertEquals(balanceResult, currentResult);
    }

    @Test(priority = 3)
    public void searchAndViewLeavesAppliedInEachCategoryTest() {
        ViewTimeOffRequestsPage viewTimeOffRequestsPage = PageFactory.initElements(driver, ViewTimeOffRequestsPage.class);
        viewTimeOffRequestsPage.searchAndViewLeavesAppliedInEachCategory();
        String dropDownText = viewTimeOffRequestsPage.typeDropdown.getText();
        String leaveTypeText = viewTimeOffRequestsPage.searchLeaveType.getText();
        Assert.assertEquals(dropDownText,leaveTypeText);
    }

    @Test(priority = 4)
    public void viewRejectedTimeOffRequestsTest() {
        ViewTimeOffRequestsPage viewTimeOffRequestsPage = PageFactory.initElements(driver, ViewTimeOffRequestsPage.class);
        viewTimeOffRequestsPage.viewRejectedTimeOffRequests();
        String rejectedCount = viewTimeOffRequestsPage.getRejectedRequestsCount();
        String leaveTypeRejectedRequests = viewTimeOffRequestsPage.getLeaveTypeCount();
        Assert.assertEquals(rejectedCount, leaveTypeRejectedRequests);
    }

    @Test(priority = 5)
    public void viewWaitingForApprovalRequestsTest() {
        ViewTimeOffRequestsPage viewTimeOffRequestsPage = PageFactory.initElements(driver, ViewTimeOffRequestsPage.class);
        viewTimeOffRequestsPage.viewWaitingForApprovalRequests();
        String waitingRequestsCount = viewTimeOffRequestsPage.getWaitingRequestsCount();
        String leaveTypeRejectedRequests = viewTimeOffRequestsPage.getLeaveTypeCount();
        Assert.assertEquals(waitingRequestsCount, leaveTypeRejectedRequests);
    }

    @Test(priority = 6)
    public void viewApprovedRequestsTest() {
        ViewTimeOffRequestsPage viewTimeOffRequestsPage = PageFactory.initElements(driver, ViewTimeOffRequestsPage.class);
        viewTimeOffRequestsPage.viewApprovedRequests();
        String approvedRequestsCount = viewTimeOffRequestsPage.getApprovedCount();
        String leaveTypeRejectedRequests = viewTimeOffRequestsPage.getLeaveTypeCount();
        Assert.assertEquals(approvedRequestsCount, leaveTypeRejectedRequests);
    }
}
