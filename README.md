# Full-Stack-Vortx | Calculate Tariffs
API developed in Java 11 and with Spring Boot 2.4.4

## Starting the Api
1. Import the project into any IDE of your choice, which supports Spring Boot;
2. Run the `Application.java` class;

## Using the API
1. Request by Postman:
Example:
    Endpoint (url): http://localhost:8080/tariffs
    Http Verb: POST
    Body (Json):

        {
            "origin": 11,
            "destiny": 17,
            "minutes": 80,
            "plan": 120
        }

    Response example:

        {
            "valueWithPlan": 0.00,
            "valueWithoutPlan": 136.00
        }

2. Request by Swagger:
Endpoint (url): http://localhost:8080/swagger-ui.html

3. JavaDoc
Endpoint (uri): file:/.../workspace/Calculate-Tariff-Vortx/doc/index.html

## Testing the API - Unitary Tests
Run the test classes with JUnit Test.

    `TariffsControllerTest.java`,
    `RequestDTOTest.java`,
    `ResponseDTOTest.java`,
    `ExceptionResponseTest.java`,
    `TariffTest.java` e 
    `CalculateTariffServiceTest.java`

## Covarage

`90% code coverage.`

## Developed By

`Andrei Luiz Lopes da Silva`
`Email: andreipsva@gmail.com`
`GitHub: https://github.com/andreilopes11`
