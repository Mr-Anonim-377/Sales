# db - Схема баз данных 

Схема базы данных расположена в прокте в виде рисунка и документа pdf

# db - как создать базу локально

Для того чтобы создать базу данных локально нужно:
- установить postgresql - страница с установочниками https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
- запомнить логин и пароль при установке
- запустить из папки bin файл postgres
- через любую субд открыть нашу локальную базу данных с логином и паролем указанным при установке 
(ссылка для подключение через Intellij IDEA - jdbc:postgresql://localhost:5432 или же подключить через host:localhost и port:5432)
- накатить скрипт который создаст базу данных, лежит в проекте в дериктории с схемами бд
- после этого можно запускать наше приложение, flyway сделает необходимые скрипты при компиляции проекта 


