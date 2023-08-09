public class Login {
    private String username, pass, givenUsername,givenPass;

    public Login(String username, String pass){
        this.username = username;
        this.pass = pass;
    }

    public void takeCredentials(){
        givenUsername = In.readString("User Name");
        givenPass = In.readString("Password");

    }

    public boolean verify(){
        if(username.equals(givenUsername) && pass.equals(givenPass)){
            System.out.println("\n------------Login Successful!-----------");
            return true;
        }
        else System.out.println("\n----Incorrect username or password!----\n");
        return false;
    }
}
