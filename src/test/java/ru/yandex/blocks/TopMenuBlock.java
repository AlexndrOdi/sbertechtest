package ru.yandex.blocks;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


public class TopMenuBlock extends HtmlElement {

    @Name("Компьютеры")
    @FindBy(linkText = "Компьютеры")
    public Button compButton;

    @ActionTitle("нажимает кнопку")
    public void clickButton() {
        compButton.click();
    }
}
