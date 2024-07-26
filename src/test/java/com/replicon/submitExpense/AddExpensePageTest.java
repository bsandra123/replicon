package com.replicon.submitExpense;

import com.replicon.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddExpensePageTest extends BaseTest {

    @Test(priority = 1, dataProvider = "values")
    public void addExpensesTest(String descriptionField, String descriptionColumn, String amount) {
        SubmitExpensePage submitExpensePage = PageFactory.initElements(driver, SubmitExpensePage.class);
        submitExpensePage.goToAddExpense();
        submitExpensePage.addExpense(descriptionField, descriptionColumn, amount);
        Assert.assertEquals(submitExpensePage.result(), "Waiting for Approval");
    }

    @DataProvider(name = "values")
    public Object[][] enterDataIntoAddExpenses() {
        return new String[][]{{"Interview Expenses", "interview", "200"}, {"Onsite Expenses", "onsite", "2000"}, {"Implementation Expenses", "implementation", "500"}, {"Team Building Event", "team event", "300"}};
    }
}
