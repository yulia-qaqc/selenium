## Автоматизация тестирования Selenium WebDriver

### [1. Сценарий, проходящий по всем разделам админки в приложении litecart](https://github.com/yulia-qaqc/selenium/tree/main/LoginScript/src/test/java)

Сценарий выполняет следующие действия:
1) входит в панель администратора
2) прокликивает последовательно все пункты меню, включая вложенные пункты
3) для каждой страницы проверяет наличие заголовка

### [2. Сценарий, проверяющий наличие стикеров у всех товаров на главной странице в приложении litecart](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/FirstTest.java)

[Инициализация драйвера](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/MainClass.java)

Стикеры - это полоски в левом верхнем углу изображения товара, на которых написано New или Sale. Сценарий проверяет, что у каждого товара имеется ровно один стикер.

### [3. Сценарий проверяет сортировку стран и геозон на странице стран в приложении litecart](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/SecondTest.java)

[Инициализация драйвера](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/MainClass.java)

1) проверяет, что страны расположены в алфавитном порядке
2) для тех стран, у которых количество зон отлично от нуля - открывает страницу этой страны и там проверяет, что геозоны расположены в алфавитном порядке

### [4. Сценарий проверяет сортировку геозон на странице геозон](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/ThirdTest.java)

[Инициализация драйвера](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/MainClass.java)

Сценарий заходит в каждую из стран и проверяет, что зоны расположены в алфавитном порядке.

