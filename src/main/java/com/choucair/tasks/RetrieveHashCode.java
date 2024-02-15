package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.choucair.ui.QuestionsForm.HASHCODE;

public class RetrieveHashCode implements Task {
    public static RetrieveHashCode isScheduled(){
        return Tasks.instrumented(RetrieveHashCode.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        String result;
        actor.attemptsTo(
                WaitUntil.the(HASHCODE, WebElementStateMatchers.isVisible()).forNoMoreThan(3000).milliseconds());


   }

}
