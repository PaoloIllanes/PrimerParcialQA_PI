package ejercicio2StaticTest;

import ejercicio2Static.PermissionStatic;
import ejercicio2Static.ValidUserStatic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ValidUserStaticTest {

    @BeforeAll
    public static void before(){
        MockedStatic<PermissionStatic> mocked = Mockito.mockStatic(PermissionStatic.class);
        mocked.when(()->PermissionStatic.validUser("andres","123")).thenReturn(true);
        mocked.when(()->PermissionStatic.getPermission("andres")).thenReturn("CR -  01/02/2022");
        mocked.when(()->PermissionStatic.validUser("sergio","123")).thenReturn(true);
        mocked.when(()->PermissionStatic.getPermission("sergio")).thenReturn("CRUD -  01/02/2022");
        mocked.when(()->PermissionStatic.validUser("juan","123")).thenReturn(false);


    }

    @Test
    public void verifyUser1(){
        ValidUserStatic validUserStatic = new ValidUserStatic();
        String expected ="PERMISSION ROLE : CR -  01/02/2022 09:20:00";
        String actual = validUserStatic.getPermission("andres","123");
        Assertions.assertTrue(expected.contains(actual),"Error respuesta incorrecta");
    }
    @Test
    public void verifyUser2(){
        ValidUserStatic validUserStatic = new ValidUserStatic();
        String expected ="PERMISSION ROLE : CRUD -  01/02/2022 09:20:00";
        String actual = validUserStatic.getPermission("sergio","123");
        Assertions.assertTrue(expected.contains(actual),"Error respuesta incorrecta");
    }

    @Test
    public void invalidUser(){
        ValidUserStatic validUserStatic = new ValidUserStatic();
        String expected ="Invalid user or password";
        String actual = validUserStatic.getPermission("juan","123");
        Assertions.assertEquals(expected,actual,"Error respuesta incorrecta");
    }

}
