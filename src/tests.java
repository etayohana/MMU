public class tests {
    String email;
    public void setEmail(String email) throws Exception{
        if( ! email.contains("@") )
            throw new Exception();
        this.email=email;
    }

    public static void main(String[] args) throws Exception {

    }
}


