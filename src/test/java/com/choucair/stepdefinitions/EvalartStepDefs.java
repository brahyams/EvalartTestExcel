package com.choucair.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import com.choucair.questions.HashcodeQuestion;
import com.choucair.tasks.FillOutForm;
import com.choucair.tasks.Login;
import com.choucair.tasks.OpenUpWeb;
import com.choucair.models.LoginModel;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


public class EvalartStepDefs {

    @Given("that an user is on Evalart Home Page")
    public void thatAnUserIsOnEvalartHomePage() {
      OnStage.theActorCalled("Brahyam").wasAbleTo(
                OpenUpWeb.theMainPage()
        );
    }

    @When("he logs with correct credentials")
    public void heLogsWithCorrectCredentials(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.onThePage(LoginModel.setData(table).get(0))
        );

    }

    @And("he completes the math operations form")
    public void heCompletesTheMathOperationsForm() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                FillOutForm.isCompleted()
        );
    }

    @Then("he retrieves the hashcode")
    public void heRetrievesTheHashcode() {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(HashcodeQuestion.isShown(), equalTo(true)
                        )
                );
    }

}
