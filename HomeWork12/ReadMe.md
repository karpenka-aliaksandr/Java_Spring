#Proxy (Заместитель)

Паттерн Proxy широко используется в AOP .

Прокси предоставляет заместителя для другого объекта, чтобы контролировать доступ к нему.

#Singleton (Одиночка)

Паттерн Singleton гарантирует, что в памяти будет существовать только один экземпляр объекта, который будет предоставлять сервисы.

В Spring область видимости бина (scope) по умолчанию равна singleton и IoC-контейнер создаёт ровно один экземпляр объекта на Spring IoC-контейнер.

Spring-контейнер будет хранить этот единственный экземпляр в кэше синглтон-бинов, и все последующие запросы и ссылки для этого бина получат кэшированный объект.

Рекомендуется использовать область видимости singleton для бинов без состояния.

Область видимости бина можно определить как singleton или как prototype (создаётся новый экземпляр при каждом запросе бина).

#Factory (Фабрика)

Этот паттерн позволяет инициализировать объект через публичный статический метод, называемый фабричным методом.

Spring использует паттерн Factory для создания объекта бина с использованием следующих двух подходов.

###BeanFactory

Простой контейнер, который обеспечивает базовую поддержку DI (Dependency Injection, инъекция зависимостей). Для работы с этим контейнером используется интерфейс org.springframework.beans.factory.BeanFactory.

###ApplicationContext

Другой контейнер, присутствующий в Spring, который добавляет специфичные enterprise-функции. Эти функции включают в себя возможность чтения параметров из property-файлов и публикацию событий приложения для слушателей событий.


Для работы с этим контейнером используется интерфейс org.springframework.context.ApplicationContext.


#Model View Controller (Модель-Представление-Контроллер)

Преимущество Spring MVC в том, что ваши контроллеры являются POJO, а не сервлетами. Это облегчает тестирование контроллеров. Стоит отметить, что от контроллеров требуется только вернуть логическое имя представления, а выбор представления остаётся за ViewResolver. Это облегчает повторное использование контроллеров при различных вариантах представления.

#Front Controller (Контроллер запросов)

Spring предоставляет DispatcherServlet, чтобы гарантировать, что входящий запрос будет отправлен вашим контроллерам.

Паттерн Front Controller используется для обеспечения централизованного механизма обработки запросов, так что все запросы обрабатываются одним обработчиком. Этот обработчик может выполнить аутентификацию, авторизацию, регистрацию или отслеживание запроса, а затем передать запрос соответствующему контроллеру.


#Dependency injection и inversion of control (IOC) (Внедрение зависимостей и инверсия управления)

IoC-контейнер в Spring, отвечает за создание объекта, связывание объектов вместе, конфигурирование объектов и обработку всего их жизненного цикла от создания до полного уничтожения.

В контейнере Spring используется инъекция зависимостей (Dependency Injection, DI) для управления компонентами приложения. Эти компоненты называются "Spring-бины" (Spring Beans).


#Observer-Observable (Наблюдатель)

Используется в механизме событий ApplicationContext.
Определяет зависимость "один-ко-многим" между объектами, чтобы при изменении состояния одного объекта все его подписчики уведомлялись и обновлялись автоматически.


#Context Object (Контекстный объект)

Паттерн Context Object, инкапсулирует системные данные в объекте-контексте для совместного использования другими частями приложения без привязки приложения к конкретному протоколу.

ApplicationContext является центральным интерфейсом в приложении Spring для предоставления информации о конфигурации приложения.

