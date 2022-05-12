import java.util.InputMismatchException;
import java.util.Scanner;

public class UITerminal {
    private Account accObj = new Account();
    public Scanner input = new Scanner(System.in);
    public Scanner sc = new Scanner(System.in);
    public void login_input(){
        System.out.print("input userName: ");
        String userName = input.nextLine();
        System.out.print("input passWord: ");
        int passWord = 0;
        try{
             passWord = input.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("error!! pw");
            e.printStackTrace();
        }
        input.nextLine();
        accObj.login(userName, passWord);
        
    }

    public void get_prompt(){
        
    }


	public void display_options(){
        int x;
        do{
            System.out.println("\t\t0. exit");
            System.out.println("\t\t1. login Accout");
            System.out.println("\t\t2. logut Accout");
            System.out.println("\t\t3. create Accout");
            x = sc.nextInt();
            switch(x){
                case 1:
                login_input();
                break;
                case 2:
                accObj.logout();
                break;
                case 3:
                create_account_inputs();
                break;
            }
        }while(x!=0);
        accObj.storedfiles.read();
        accObj.storedfiles.write();
    }

    public void create_account_inputs(){
        System.out.print("input userName: ");
        String userName = input.nextLine();
        System.out.print("input passWord: ");
        int passWord = 0;
        try {
            passWord = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e1) {
            System.out.println("error!!");
            e1.printStackTrace();
            //TODO: handle exception
        }
        System.out.print("input Email: ");
        String email = sc.nextLine();
        for (Account account : accObj.storedfiles.list) {
            if (userName.equals(account.getUserName())) {
                System.out.println("Username đã được sử dụng trước đó.");
                System.out.println("Tạo tài khoản thất bại!!!.");
                return;
            } else if (email.equals(account.getEmail())) {
                System.out.println("Email đã được sử dụng trước đó.");
                System.out.println("Tạo tài khoản thất bại!!!.");
                return;
            }
        }
        accObj.create_account(userName, passWord, email);
        accObj.storedfiles.write();
    }
}
