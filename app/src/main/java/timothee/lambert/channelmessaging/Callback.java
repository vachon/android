package timothee.lambert.channelmessaging;

/**
 * Created by lambetim on 23/01/2017.
 */
public class Callback {

    private String username;
    private  String password;
    int code;
    String accesstokens;


    @Override
    public String toString(){
        return "Usurname :"+this.username+" Code :"+this.code+" accestoken : "+this.accesstokens;
    }
}