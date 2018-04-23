package ru.yandex.pages.Yandex;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Яндекс")
public class YandexPage extends Page{

    @ElementTitle("Строка поиска")
    @FindBy(css = ".topmenu__item i-bem topmenu__item_mode_current topmenu__item_js_inited a")
    public TextInput search;

    @ElementTitle("Маркет")
    @FindBy(css = "div > a:nth-child(5)")
    public Button toMarket;

    public YandexPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)),this);
    }

    @ActionTitle("ищет")
    public void searching(String searchText){
        search.sendKeys(searchText);
        search.sendKeys(Keys.ENTER);
    }

    @ActionTitle("переходит на маркет")
    public void navigateToMarket(){
        toMarket.click();
    }

    public boolean checkTitle(String expectedTitle){
        return getTitle().equals(expectedTitle);
    }
}
