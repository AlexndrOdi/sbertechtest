package ru.yandex.pages.Yandex;

import org.openqa.selenium.WebDriver;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.blocks.HeaderBlock;
import ru.yandex.blocks.TopMenuBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Яндекс Маркет")
public class YmMainPage extends Page {

    @ElementTitle("Меню поиска")
    public HeaderBlock headerBlock;

    @ElementTitle("Меню разделов")
    public TopMenuBlock topMenuBlock;

    public YmMainPage(WebDriver driver){
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)),this);
    }

    @ActionTitle("выбирает раздел комьютеры")
    public void chooseComp(){
        topMenuBlock.clickButton();
    }
    @ActionTitle("осуществляет поиск")
    public void searchItem(){
        headerBlock.startSearch("почему не переходит на компьютеры?");
    }
}
