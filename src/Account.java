public class Account {
    private String userName;
    private int passWord;
    private String email;
    private boolean loggendin = false;
    Account account = new Account(userName, passWord, email);
    storedFiles storedfiles = new storedFiles("acc_data.json");

    public String getUserName() {
        return userName;
    }

    public int getPassWord() {
        return passWord;
    }

    public Account(){}

    public Account(String userName, int passWord, String email){
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        
    }

    public void set_account(String userName, int passWord){
        this.userName = userName;
        this.passWord = passWord;
    }


    public void login(String userName, int passWord){
        check_loggedin(userName, passWord);
        if(loggendin == true){
            System.out.println("login sussesfully");
        } else {
            System.out.println("error!!! please re-enter userName and PassWord");
        }
    }

    private void check_loggedin(String userName2, int passWord2) {
    }

    public void logout(){
            System.out.println("logout account Sussecfully");
    }

    public void create_account(String userName, int passWord, String email){
        this.set_account(userName, passWord);
        this.email = email;
    }

    public boolean check_loggedin(){
        for(Account account: storedfiles.memory){
            if(account.getUserName().equals(userName) && passWord == account.getPassWord()) 
             System.out.println("You are logged in");
                loggendin = true;
        }
    
        return loggendin;
    }

    public void account_valib(String userName, String email){
        this.userName = userName;
        this.email = email;
        storedfiles.memory.add(account);
    }
}
