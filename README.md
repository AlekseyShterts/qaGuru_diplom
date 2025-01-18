# Проект автоматизации тестирования сервиса HeadHunter

<a href="https://hh.ru/">
<img alt="HeadHunter" src="images/hh.jpg" style="width:100%;" />
</a>

## Содержание
1. [Описание](#описание)
2. [Ссылки](#ссылки)
3. [Использованные технологии и инструменты](#использованные-технологии-и-инструменты)
4. [Запуск тестов](#запуск-тестов)
   - [Локальный запуск тестов](#локальный-запуск-тестов)
   - [Параметры web тестов](#параметры-web-тестов)
   - [Сборка тестов в Jenkins](#сборка-тестов-в-jenkins)
5. [Интеграции](#интеграции)
   - [Интеграция с Allure](#интеграция-с-ba-target_blank-hrefhttpsjenkinsautotestscloudviewartemleallureab)
   - [Интеграция с Allure TestOps](#интеграция-с-ba-target_blank-hrefhttpsallureautotestscloudproject4450dashboardsallure-testopsab)
   - [Уведомления в Telegram](#уведомления-в-telegram-с-использованием-бота)
6. [Технические особенности](#технические-особенности)
7. [Примеры прохождения автотестов](#пример-прохождения-автотестов)
   - [Web](#web)

## Описание

Данный проект направлен на автоматизацию Web и API тестов для сервиса [HeadHunter](https://hh.ru/).  <br/>
Headhunter - сервис, который помогает найти работу и подобрать персонал. <br/>

## Ссылки

### Jenkins: 
- Джоба запуска [api автотестов](https://jenkins.autotests.cloud/job/AShterts%20api/)
- Джоба запуска [web автотестов](https://jenkins.autotests.cloud/job/qaGuru_Diplom/)

### Test ops
- Проект [api автотестов](https://allure.autotests.cloud/launch/43985)
- Проект [web автотестов](https://allure.autotests.cloud/project/4574/dashboards)

## Использованные Технологии и инструменты

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/Idea.svg" width="50"/></a>
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/Java.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/Gradle.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/Junit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="images/Selenide.svg" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="RestAssured" height="50" src="images/RestAssured.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/Jenkins.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="images/Allure_TO.svg" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/Telegram.png" width="50"/></a>
<a href="https://projectlombok.org/"><img alt="Lombok" height="50" src="images/lombok.png" width="50"/></a>
</div>

## Запуск тестов
### Локальный запуск тестов

Для запуска следует открыть IntelliJ IDEA и выполнить в терминале:

- Для запуска всех тестов
```
gradle clean test
```
или
```
gradle clean test -Dtag=all
```
- WEB
```
gradle clean test -Dtag=web
```
- API
```
gradle clean test -Dtag=api 
```


#### Параметры web тестов

```
-Dbrowser - наименование браузера (значение по умолчанию: chrome)
-DbrowserSize - размер окна браузера.(значение по умолчанию: 1980x1080)
-DremoteUrl - адрес удаленного сервера, на котором будут запускаться тесты
```

<details>
   <summary>Дополнительные команды:</summary>

1. Выполнить запрос на формирование отчета:

```
gradle allureReport
```

2. Открыть отчет в браузере:

```
gradle allureServe
```

</details>

### Сборка тестов в Jenkins
>#### <b><a target="_blank" href="https://jenkins.autotests.cloud/job/qaGuru_Diplom/">Web</a></b>
> Для запуска сборки необходимо перейти в раздел `Build with Parameters`, если требуется выбрать нужные параметры
> BROWSER или BROWSERSIZE и нажать кнопку `Build`

> #### <b><a target="_blank" href="https://jenkins.autotests.cloud/job/AShterts%20api/">Api</a></b>
> У сборки нет параметров, достаточно нажать  `Build Now`.

## Интеграции
### Интеграция с <b><a target="_blank" href="https://jenkins.autotests.cloud/job/qaGuru_Diplom/allure/">Allure</a></b>

#### Пример прохождения автотестов:

   <img src="images/allure_example1.png">
   <img src="images/allure_example2.png">

### Интеграция с <b><a target="_blank" href="https://allure.autotests.cloud/project/4574/jobs">Allure TestOps</a></b>
#### Пример прохождения автотестов:

 <img src="images/test_ops_example.png">

### Уведомления в [Telegram](https://t.me/+CFuoB1UND083MTVi) с использованием бота

> Бот, созданный в Telegram, после завершения сборки отправляет сообщение с отчетом о прохождении тестов
   
   <img src="images/tg_example.png">
 
## Примеры прохождения автотестов
### Web
   
   <img src="images/web_test_example.gif">

## Технические особенности

> [!NOTE]
> Убедитесь, что у вас установлены Java, Gradle, IntelliJ IDEA.

