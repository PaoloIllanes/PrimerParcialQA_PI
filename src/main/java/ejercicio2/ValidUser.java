package ejercicio2;

public class ValidUser {
    Permission permission;

    public ValidUser(Permission objetoMock){

        permission =  objetoMock;

    }

    public String getPermission(String user, String pwd){
        String msg="";

        if(permission.validUser(user,pwd)){
            String per = permission.getPermission(user);
            msg="PERMISSION ROLE : "+per+" 09:20:00";

        }else{
            msg="Invalid user or password";
        }

    return msg;
    }
}
