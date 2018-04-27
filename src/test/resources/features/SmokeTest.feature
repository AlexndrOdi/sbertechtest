# language: ru
  Функционал: тестирование поиска в Яндекс

  @test
    Сценарий: тестирование перехода пользователя на yandex.ru
      Когда пользователь открывает браузер и нажимает полноэкранные режим
      И пользователь переходит на yandex.ru
      Тогда открывается страница yandex.ru

#    Сценарий: тестирование перехода на яндекс маркет в раздел ноутбуки
      Когда пользователь нажимает маркет
      Тогда переходит на яндекс маркет

#    Сценарий: тестирование выбора раздела на яндекс маркет
      Когда пользователь выбирает раздел комьютеры
      И выбирает раздел Ноутбуки
      Тогда пользователь находится в разделе Ноутбуки

#    Сценарий: тестирование расширенного поиска яндекс маркета
      Когда пользователь переходит в расширенный поиск
      И выбирает производителя HP и Lenovo
      И нажимает кнопку Применить
      Тогда отображается 10 элементов на странице