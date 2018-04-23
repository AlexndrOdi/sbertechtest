package ru.yandex.blocks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class HeaderBlock extends HtmlElement {

    @Name("Строка поиска")
    @FindBy(css = "input#header-search")
    public TextInput searchString;

    @Name("Найти")
    @FindBy(css = "span.search2__button > button[type=submit]")
    public TextInput searchButton;

    @ActionTitle("выполняет поиск")
    public void startSearch(String text){
        searchString.sendKeys(text);
        searchString.sendKeys(Keys.ENTER);
        searchButton.click();
    }
}
