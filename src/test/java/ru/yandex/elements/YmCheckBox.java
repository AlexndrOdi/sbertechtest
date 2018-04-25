package ru.yandex.elements;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class YmCheckBox extends HtmlElement {
    @Name("HP")
    @FindBy(css = "div:nth-child(6) > a > span > label")
    public Button hp;

    @Name("Lenovo")
    @FindBy(css = "div:nth-child(7) > a > span > label")
    public Button lenovo;

/*    public YmCheckBox(WebElement wrappedElement) {
        super(wrappedElement);
    }*/

    @ActionTitle("выбор элементов чекбокса")
    public void selectItem(String item){
        if (item.equals("HP")) {
            hp.click();
        }
        if (item.equals("Lenovo")) {
            lenovo.click();
        }
    }
}
