package io.loop.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.LoginPage;
import io.loop.utilities.BrowserUtils;
import lombok.extern.java.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

public class ClientStepDefs {

    private Logger LOG = LogManager.getLogger();
    private SoftAssertions softAssertions = new SoftAssertions();
    LoginPage loginPage = new LoginPage();

    @Then("user validates {string} text is displayed")
    public void user_validates_text_is_displayed(String text) {
        String actual;
        String expected;
        switch (text.toLowerCase().trim()){
            case "login":
               // actual = loginPage.loginText.getText().trim().toLowerCase();
                actual = "nadir";
                expected = text.toLowerCase().trim();
                softAssertions.assertThat(actual).isEqualTo(expected);
                LOG.info(text + " - is displayed");
                break;
            case"docuport":
               // actual = loginPage.docuportText.getAttribute("alt").trim().toLowerCase();
                actual = "feyruz";
                expected = text.toLowerCase().trim();
                softAssertions.assertThat(actual).isEqualTo(expected);
                LOG.info(text + " - is displayed");
                break;
            case"choose account":
                BrowserUtils.waitForVisibility(loginPage.continueText,10);
              //  actual = loginPage.continueText.getText().trim().toLowerCase();
                actual = "loop";
                expected = text.toLowerCase().trim();
                softAssertions.assertThat(actual).isEqualTo(expected);
                LOG.info(text + " - is displayed");
                break;
        }

    }

    @When("user validates all assertions")
    public void user_validates_all_assertions() {
        softAssertions.assertAll();
    }


}