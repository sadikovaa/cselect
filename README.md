# Cselect

## Язык и стек

Java 21, Spring Boot 4.1.1 (Spring Data JPA, Lombok).

## СУБД

PostgreSQL, база данных `employees`.

Подключается к `jdbc:postgresql://localhost:5434/employees`  
(логин/пароль: `postgres`/`postgres`).

## Запуск

```bash
./mvnw spring-boot:run
```


## Запрос

Запрос выбирает всех сотрудников с отделами.

```sql
select e from Employee e
        left join fetch e.departments
```

## Комментарии

1. `@ToString` из Lombok не используется: при обращении к ленивым коллекциям возможен неожиданный N+1.
2. N+1 нет при `findAllFetchDepartments`: `departments` подгружаются явно через `left join fetch` (left — чтобы сотрудники без отделов тоже попали в выборку). Альтернатива — EntityGraph.
3. Для сборки строки используется `StringBuilder`: он дешевле конкатенации через `+` или `String.format`.
4. Отдельный DTO-слой не выделен (сущность с потенциально ленивыми коллекциями отдаётся из сервиса) — для этого задания избыточно.
5. Отдельное форматирование даты не добавлялось — `LocalDate` и так читаемо.
6. Транзакция не нужна: все данные вытягиваются одним запросом.
