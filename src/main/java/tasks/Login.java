package tasks;

import models.LoginModel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.LoginPage;

public class Login implements Task {

    private final LoginModel loginModel;

    public Login(LoginModel loginModel) {
          this.loginModel = loginModel;
    }

    public static Login onThePage(LoginModel loginModel){
        return Instrumented.instanceOf(Login.class).withProperties(loginModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.LOGIN_BUTTON, WebElementStateMatchers.isVisible()).forNoMoreThan(5000).milliseconds(),
                DoubleClick.on(LoginPage.USERNAME),
                Enter.theValue(loginModel.getUsername()).into(LoginPage.USERNAME),
                WaitUntil.the(LoginPage.LOGIN_BUTTON, WebElementStateMatchers.isVisible()).forNoMoreThan(1000).milliseconds(),
                DoubleClick.on(LoginPage.PASSWORD),
                Enter.theValue(loginModel.getPassword()).into(LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN_BUTTON));
    }
}
