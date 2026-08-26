package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentFormBuyPage {
    private final SelenideElement cardNumberForm = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthForm = $("[placeholder='08']");
    private final SelenideElement yearForm = $("[placeholder='22']");
    private final SelenideElement ownerForm = $$(".input__inner").findBy(text("Владелец")).$(".input__control");
    private final SelenideElement cvcForm = $("[placeholder='999']");
    private final SelenideElement continueButton = $$(".button__content").findBy(text("Продолжить"));
    private final SelenideElement successfulNotification = $$(".notification__content").findBy(text("Операция одобрена Банком."));
    private final SelenideElement errorNotification = $$(".notification__content").findBy(text("Ошибка! Банк отказал в проведении операции."));
    private final SelenideElement emptyField = $$(".input__inner").findBy(text("Поле обязательно для заполнения"));
    private final SelenideElement wrongFormat = $$(".input__inner").findBy(text("Неверный формат"));
    private final SelenideElement wrongCardDate = $$(".input__inner").findBy(text("Неверно указан срок действия карты"));
    private final SelenideElement cardExpired = $$(".input__inner").findBy(text("Истёк срок действия карты"));

    public void filledForm(DataHelper.CardInfo cardInfo, DataHelper.MonthInfo monthInfo, DataHelper.YearInfo yearInfo, DataHelper.OwnerInfo ownerInfo, DataHelper.CvcInfo cvcInfo) {
        cardNumberForm.setValue(cardInfo.getCardNumber());
        monthForm.setValue(monthInfo.getMonth());
        yearForm.setValue(yearInfo.getYear());
        ownerForm.setValue(ownerInfo.getOwner());
        cvcForm.setValue(cvcInfo.getCvc());
        continueButton.click();
    }

    public void cleanFilledForm() {
        cardNumberForm.doubleClick().sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        monthForm.doubleClick().sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        yearForm.doubleClick().sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        ownerForm.doubleClick().sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        cvcForm.doubleClick().sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
    }

    public void waitSuccessfulNotification() {
        successfulNotification.should(Condition.visible, Duration.ofSeconds(15));
    }

    public void waitErrorNotification() {
        errorNotification.should(Condition.visible, Duration.ofSeconds(15));
    }

    public void waitEmptyField() {
        emptyField.should(Condition.visible, Duration.ofSeconds(15));
    }

    public void waitWrongFormat() {
        wrongFormat.should(Condition.visible, Duration.ofSeconds(15));
    }

    public void waitWrongCardDate() {
        wrongCardDate.should(Condition.visible, Duration.ofSeconds(15));
    }

    public void waitCardExpired() {
        cardExpired.should(Condition.visible, Duration.ofSeconds(15));
    }

    public void onlyCardField(DataHelper.CardInfo cardInfo) {
        cardNumberForm.setValue(cardInfo.getCardNumber());
    }

    public void emptyCardField() {
        cardNumberForm.should(Condition.empty);
    }

    public void onlyMonthField(DataHelper.MonthInfo monthInfo) {
        monthForm.setValue(monthInfo.getMonth());
    }

    public void emptyMonthField() {
        monthForm.should(Condition.empty);
    }

    public void onlyYearField(DataHelper.YearInfo yearInfo) {
        yearForm.setValue(yearInfo.getYear());
    }

    public void emptyYearField() {
        yearForm.should(Condition.empty);
    }

    public void onlyCVCField(DataHelper.CvcInfo cvcInfo) {
        cvcForm.setValue(cvcInfo.getCvc());
    }

    public void emptyCVCField() {
        cvcForm.should(Condition.empty);
    }
}