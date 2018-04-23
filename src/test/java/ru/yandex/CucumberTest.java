package ru.yandex;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import ru.sbtqa.tag.cucumber.TagCucumber;


@RunWith(TagCucumber.class)
@CucumberOptions(monochrome = true,
        format = {"pretty"},
        // Укажите здесь корневые пакеты, в которых хранятся шаги. Если вы написали свои классы с шагами, не забудьте указать здесь пакеты, в которых они находятся
        glue = {"ru.yandex.steps","ru.yandex.support"},
        // Укажите здесь путь до каталога с фичами
        features = {"src/test/resources/features"},
        // Здесь можно указать тэг теста или нескольких тестов, которые вы хотите запустить. Это удобно при отладке тестов
        tags = {"@test"}
        )
public class CucumberTest {

}
