## Автоматизация тестирования Selenium WebDriver

### [1. Сценарий, проходящий по всем разделам админки в приложении litecart](https://github.com/yulia-qaqc/selenium/tree/main/LoginScript/src/test/java)

Сценарий выполняет следующие действия:
1) входит в панель администратора
2) прокликивает последовательно все пункты меню, включая вложенные пункты
3) для каждой страницы проверяет наличие заголовка

### [2. Сценарий, проверяющий наличие стикеров у всех товаров на главной странице в приложении litecart](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/Stickers.java)

[Инициализация драйвера](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/DriverClass.java)

Стикеры - это полоски в левом верхнем углу изображения товара, на которых написано New или Sale. Сценарий проверяет, что у каждого товара имеется ровно один стикер.

### [3. Сценарий проверяет сортировку стран и геозон на странице стран в приложении litecart](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/%D0%A1ountriesPageSorting.java)

[Инициализация драйвера](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/DriverClass.java)

1) проверяет, что страны расположены в алфавитном порядке
2) для тех стран, у которых количество зон отлично от нуля - открывает страницу этой страны и там проверяет, что геозоны расположены в алфавитном порядке

### [4. Сценарий проверяет сортировку геозон на странице геозон](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/GeozonesPageSorting.java)

[Инициализация драйвера](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/DriverClass.java)

Сценарий заходит в каждую из стран и проверяет, что зоны расположены в алфавитном порядке.

### [5. Проверки различных параметров товара в приложении litecart](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/ProductParameters.java)

[Инициализация драйвера](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/DriverClass.java)

1) Проверка совпадения текста на главной странице и странице товара
2) Проверка совпадения цен на главной странице и странице товара (обычной и акционной)
3) Тест проверяет, что обычная цена товара зачёркнутая и серая
4) Тест проверяет, что акционная цена товара жирная и красная. Для первого товара из блока Campaigns
5) Тест проверяет, что шрифт акционной цены крупнее, чем обычной. Для первого товара из блока Campaigns

Тесты работают в разных браузерах (Google Chrome, Microsoft Edge, Firefox).

### [6. Сценарий для регистрации нового пользователя в приложении litecart](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/UserRegistration.java)

[Инициализация драйвера](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/DriverClass.java)

Регистрация новой учётной записи с уникальным адресом электронной почты, выход, повторный вход в только что созданную учётную запись, и ещё раз выход.

### [7. Сценарий для добавления нового товара в приложении litecart (в админке)](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/AddProduct.java)

[Инициализация драйвера](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/DriverClass.java)

Сценарий открывает меню Catalog, в правом верхнем углу нажимает кнопку "Add New Product", заполняет поля с информацией о товаре и сохраняет товар.
После сохранения сценарий проверяет, что товар появился в каталоге (в админке). 

### [8. Сценарий для добавления товаров в корзину и удаления товаров из корзины](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/CartActions.java)

[Инициализация драйвера](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/DriverClass.java)

1) открывает главную страницу
2) добавляет товар в корзину
3) ждет, пока счётчик товаров в корзине обновится
4) возвращается на главную страницу, повторяет предыдущие шаги ещё два раза
5) открывает корзину
6) удаляет все товары из корзины один за другим, после каждого удаления ждет, пока внизу обновится таблица

### [9. Сценарий проверяет, что ссылки на странице редактирования страны открываются в новом окне](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/OpenNewWindows.java)

[Инициализация драйвера](https://github.com/yulia-qaqc/selenium/blob/main/Litecart/src/test/java/DriverClass.java)

1) входит в панель администратора
2) открывает пункт меню Countries
3) открывает страну на редактирование
4) проверяет, что ссылки с иконкой, которые расположены возле некоторых полей, открываются в новом окне

