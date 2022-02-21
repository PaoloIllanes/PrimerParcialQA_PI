package ejercicio2Test;

import ejercicio2.Permission;
import ejercicio2.ValidUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ValidUserTest {

    Permission permission = Mockito.mock(Permission.class);

    @Test
    public void verifyUser1()  {


        Mockito.when(permission.validUser("andres","123")).thenReturn(true);
        Mockito.when((permission.getPermission("andres"))).thenReturn("CR -  01/02/2022");
        ValidUser validUser = new ValidUser(permission);
        String actualResult = validUser.getPermission("andres","123");
        String expectedResult = "PERMISSION ROLE : CR -  01/02/2022 09:20:00";

        Assertions.assertTrue(expectedResult.contains(actualResult),"Error respuesta incorrecta");
        Mockito.verify(permission).getPermission("andres");
        Mockito.verify(permission).validUser("andres","123");



    }
    @Test
    public void verifyUser2()  {


        Mockito.when(permission.validUser("juan","232232")).thenReturn(true);
        Mockito.when((permission.getPermission("juan"))).thenReturn("CRUD -  01/02/2022");
        ValidUser validUser = new ValidUser(permission);
        String actualResult = validUser.getPermission("juan","232232");
        String expectedResult = "PERMISSION ROLE : CRUD -  01/02/2022 09:20:00";

        Assertions.assertTrue(expectedResult.contains(actualResult),"Error respuesta incorrecta");
        Mockito.verify(permission).getPermission("juan");
        Mockito.verify(permission).validUser("juan","232232");



    }
    @Test
    public void invalidUser()  {


        Mockito.when(permission.validUser("sergio","123")).thenReturn(false);
        ValidUser validUser = new ValidUser(permission);
        String actualResult = validUser.getPermission("sergio","123");
        String expectedResult = "Invalid user or password";

        Assertions.assertEquals(expectedResult,actualResult,"Error respuesta incorrecta");
        Mockito.verify(permission).validUser("sergio","123");



    }


}
