package ejercicio1Test;

import ejercicio1.Descuento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DescuentoTest {
    @ParameterizedTest
    @CsvSource({
            "2000,El salario introduciodo no es valido",
            "2001,El descuento es de : 100 Bs",
            "3999,El descuento es de : 199 Bs",
            "4000,El descuento es de : 200 Bs",
            "4001,El descuento es de : 600 Bs",
            "4001,El descuento es de : 600 Bs",
            "4001,El descuento es de : 600 Bs",
            "4001,El descuento es de : 600 Bs",


    })
    public void verificarDescuento(int salario,String expectedRes) throws Exception {

        Descuento des  = new Descuento();
        String actualResult= des.getDescuento(salario);

        Assertions.assertEquals(actualResult,expectedRes);

    }
}
