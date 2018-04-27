package ru.yandex.pages.Yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.elements.YmCheckBox;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Страница фильтров")
public class YmSearchPage extends Page {

    public YmSearchPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    @ElementTitle("Применить")
    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div[1]/div[5]/a[2]")
    public Button apply;

    @ElementTitle("Фильтры чекбокс")
    @FindBy(css = "div:nth-child(2) > div.n-filter-block__body.i-bem.n-filter-block__body_js_inited > div > div.n-filter-block__list-items.i-bem")
    public YmCheckBox checkBox;

    @ActionTitle("выбор элементов чекбокса")
    public void setCheckBox(String item){
        checkBox.selectItem(item);
    }

    @ActionTitle("нажимает применить")
    public void pressApply(){
        apply.click();
    }
}
