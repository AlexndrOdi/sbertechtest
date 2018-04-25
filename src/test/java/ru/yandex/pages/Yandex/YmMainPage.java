package ru.yandex.pages.Yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.blocks.HeaderBlock;
import ru.yandex.blocks.MainMenuBlock;
import ru.yandex.blocks.TopMenuBlock;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Яндекс Маркет")
public class YmMainPage extends Page {

    @ElementTitle("Меню поиска")
    public HeaderBlock headerBlock;

    @FindBy(css = "div#search-prepack div > div > a")
    public Button filters;

    @ElementTitle("Выбор компьютерной техники")
    @FindBy(css = "body > div.main > div:nth-child(4) > div.layout-grid__col.layout-grid__col_width_2")
    public MainMenuBlock mainMenuBlock;

    @ElementTitle("Меню разделов")
    @FindBy(tagName = "ul")
    public TopMenuBlock topMenuBlock;

    public YmMainPage(WebDriver driver){
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)),this);
    }

    @ActionTitle("выбирает все фильтры")
    public void pressFilters(){
        filters.click();
    }
    @ActionTitle("выбирает раздел комьютеры")
    public void pressComp(){
        topMenuBlock.clickButton();
    }

    @ActionTitle("выбирает ноутбуки")
    public void pressLaptop(){
        mainMenuBlock.chooseLaptop();
    }
    @ActionTitle("осуществляет поиск")
    public void searchItem(){
        headerBlock.startSearch("почему не переходит на компьютеры?");
    }
}
