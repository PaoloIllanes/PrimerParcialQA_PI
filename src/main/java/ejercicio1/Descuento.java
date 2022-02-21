package ejercicio1;

public class Descuento {

    public String getDescuento(int salario) throws Exception {
        String msg="";
        int des = 0;

        if(salario<2000){
            throw new Exception("El salario introduciodo no es valido");
        }else if (salario < 4001){
            des =(salario/100) *5;

            msg="El descuento es de : "+des+" Bs";
        }
        else{
            des =(salario/100)*15;
            msg="El descuento es de : "+des+" Bs";
        }

        return msg;
    }
}
