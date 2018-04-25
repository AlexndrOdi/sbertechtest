package ru.yandex.blocks;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class MainMenuBlock extends HtmlElement {

    @Name("Компьютерная техника и компьютеры")
    @FindBy(css = "a:nth-child(2)")
    public Button laptopButton;

    @ActionTitle("выбирает ноутбуки")
    public void chooseLaptop(){
        laptopButton.click();
    }
}
