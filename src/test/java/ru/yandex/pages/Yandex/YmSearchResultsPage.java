package ru.yandex.pages.Yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.blocks.HeaderBlock;
import ru.yandex.elements.ProductCard;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

@PageEntry(title = "Результаты поиска товаров")
public class YmSearchResultsPage extends Page {

    private HeaderBlock headerBlock;

    @ElementTitle("Список товаров")
    @FindBy(xpath = "//*[contains(@class,'n-snippet-card2 i-bem b-zone')]")
    public List<ProductCard> productCards;

    public YmSearchResultsPage(WebDriver driver){
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public List<ProductCard> getProductCards() {
        return productCards;
    }
}
