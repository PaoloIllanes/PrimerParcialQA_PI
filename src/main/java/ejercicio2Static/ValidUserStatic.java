package ejercicio2Static;

public class ValidUserStatic {
    public String getPermission(String user, String pwd){
        String msg="";

        if(PermissionStatic.validUser(user,pwd)){
            String per = PermissionStatic.getPermission(user);
            msg="PERMISSION ROLE : "+per;

        }else{
            msg="Invalid user or password";
        }

        return msg;
    }
}
