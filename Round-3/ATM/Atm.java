import java.util.Scanner;

class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO INDIAN BANK ATM ");
        System.out.println("----------------------------");
        System.out.print("ENTER YOUR NAME = ");
        String customer_name = sc.nextLine();
        int ATM_pin = 6381;
        int account_balance = 100000;
        int wrong_choices = 3;
        int account_number = 784514667;
        long phone_number = 6381064479L;
        String bank_name = "INDIAN BANK";
        boolean condition = true;
        while (condition && wrong_choices > 0) {
            System.out.print("ENTER YOUR 4 DIGIT ATM PIN  : ");
            int user_pin = sc.nextInt();
            if (user_pin == ATM_pin) {
                boolean innerCondition = true;
                while (innerCondition) {
                    System.out.println("1. ACCOUNT BALANCE");
                    System.out.println("2. DEPOSIT");
                    System.out.println("3. WITHDRAWAL");
                    System.out.println("4. RECEIPT");
                    System.out.println("5. EXIT");
                    System.out.print("SELECT YOUR CHOICE : ");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("BALANCE : " + account_balance);
                            System.out.println("---------------------------");
                            break;
                        case 2:
                            System.out.print("ENTER THE AMOUNT YOU NEED TO DEPOSIT : ");
                            int deposit_amount = sc.nextInt();
                            account_balance += deposit_amount;
                            System.out.println("CURRENT BALANCE = " + account_balance);
                            System.out.println("SUCESSFULLY CREDITED");
                            System.out.println("---------------------------");
                            break;
                        case 3:
                            System.out.print("ENTER THE AMOUNT YOU NEED TO WITHDRAW : ");
                            int withdrawal_amount = sc.nextInt();
                            if (withdrawal_amount <= account_balance) {
                                account_balance -= withdrawal_amount;
                                System.out.println("CURRENT BALANCE = " + account_balance);
                                System.out.println("SUCESSFULLY DEBITED");
                                System.out.println("---------------------------");
                            } else {
                                System.out.println("INSUFFICIENT BALANCE ");
                                System.out.println("YOU HAVE ONLY " + account_balance + " AMOUNT IN YOUR ACCOUNT");
                                System.out.println("---------------------------");
                            }
                            break;
                        case 4:
                            System.out.println("BANK NAME           = " + bank_name);
                            System.out.println("ACCOUNT HOLDER NAME = " + customer_name);
                            System.out.println("ACCOUNT NUMBER      = " + account_number);
                            System.out.println("ACCOUNT BALANCE     = " + account_balance);
                            System.out.println("PHONE NUMBER        = " + phone_number);
                            System.out.println("---------------------------");
                            break;
                        case 5:
                            System.out.println("ARE YOU SURE? YOU WANT TO EXIT!!");
                            System.out.println("1.YES 2. NO");
                            System.out.print("SELECT ANY ONE CHOICE = ");
                            int exit_num = sc.nextInt();
                            if (exit_num == 1) {
                                System.out.println("THANK YOU FOR VISITING OUR ATM, HAVE A NICE DAY.");
                                System.out.println("---------------------------");
                                innerCondition = false;
                                condition = false;
                            }
                            break;
                        default:
                            System.out.println("PLEASE ENTER A VALID CHOICE!!");
                            break;
                    }
                }
            } else {
                wrong_choices--;
                System.out.println("Wrong ATM PIN");
                if (wrong_choices > 0) {
                    System.out.println("YOU HAVE ONLY " + wrong_choices + " ATTEMPTS LEFT");
                } else {
                    System.out.println("YOU HAVE REACHED THE MAXIMUM LIMIT OF ATTEMPTS, CONTACT YOUR BRANCH MANAGER.");
                }
            }
        }
        sc.close();
    }
}