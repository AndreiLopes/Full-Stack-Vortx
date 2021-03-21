package br.com.vortx.tariff.dto;

import br.com.vortx.tariff.model.Tariff;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

@SpringBootTest
public class RequestDTOTest {

    @Test
    public void requestDtoTest() {

        assertPojoMethodsFor(RequestDTO.class).testing(Method.GETTER, Method.SETTER, Method.TO_STRING)
                .testing(Method.EQUALS)
                .testing(Method.HASH_CODE)
                .testing(Method.CONSTRUCTOR)
                .areWellImplemented();
    }
}
