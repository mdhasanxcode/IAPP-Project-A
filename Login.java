public class Login {
    protected String username;
    protected String pwd;

    public Login(){
        
    }

    protected void takeCredentials(){
        username = In.readString("User Name");
        pwd = In.readString("Password");

    }

    protected boolean verify(){
        if(username.equals("Admin") && pwd.equals("1234")){
            System.out.println("Login Successful");
            return true;
        }
        else System.out.println("\n\n----Login Failed. Please Try again!----\n\n");
        return false;
    }
}
