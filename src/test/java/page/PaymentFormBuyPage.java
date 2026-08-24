package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentFormBuyPage {
    private SelenideElement cardNumberForm = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthForm = $("[placeholder='08']");
    private SelenideElement yearForm = $("[placeholder='22']");
    private SelenideElement ownerForm = $$("[class='input__control']").get(3);
    private SelenideElement cvcForm = $("[placeholder='999']");
    private SelenideElement continueButton = $(byText("Продолжить"));
    private SelenideElement successfulNotification = $(byText("Операция одобрена Банком."));
    private SelenideElement errorNotification = $(byText("Ошибка! Банк отказал в проведении операции."));
    private SelenideElement emptyField = $(byText("Поле обязательно для заполнения"));
    private SelenideElement wrongFormat = $(byText("Неверный формат"));
    private SelenideElement wrongCardDate = $(byText("Неверно указан срок действия карты"));
    private SelenideElement cardExpired = $(byText("Истёк срок действия карты"));
}
