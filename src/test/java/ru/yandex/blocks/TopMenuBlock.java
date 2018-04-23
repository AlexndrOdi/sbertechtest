package ru.yandex.blocks;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


public class TopMenuBlock extends HtmlElement {

    @Name("Компьютеры")
    @FindBy(css = "li.topmenu__item.i-bem.topmenu__item_js_inited.topmenu__item_hovered_yes.topmenu__item_opened_yes > a")
    public Button compButton;


    @ActionTitle("нажимает кнопку")
    public void clickButton() {
        compButton.click();
    }
}
