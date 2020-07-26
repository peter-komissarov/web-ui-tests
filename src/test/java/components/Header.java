package components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public abstract class Header {

    @Step("Logout")
    public final void logout() {
        $("#PH_logoutLink").click();
    }
}
