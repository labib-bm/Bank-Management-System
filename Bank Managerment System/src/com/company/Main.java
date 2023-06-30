package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String getBankAccountNumber(){
        String accountNumber = "4";
        for(int i=0;i<9;i++){
            accountNumber = accountNumber + (char)(generateRandomDigit()+48);
        }
        return accountNumber;
    }
    public static int generateRandomDigit() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank BangladeshBank = new Bank();
        BangladeshBank.setBankName("Bangladesh Bank");
        BangladeshBank.setAddress("Motijheel, Dhaka, Bangladesh");
        boolean AddEmployee = true;
        while (AddEmployee) {
            int select = inputValidityChecker.getValidMarkInput("Add Employee?\n   1. Yes\n   2. No\n", 2);
            if(select==2) break;
            System.out.print("Employee Name: \n");
            String name = sc.nextLine();
            BangladeshBank.addEmployee(name);
        }
        BangladeshBank.displayBankInformation();
        System.out.print("Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Account Holder Address: ");
        String address = sc.nextLine();
        String bankAccountNumber = Main.getBankAccountNumber();
        Customer customer1 = new Customer(name, address, bankAccountNumber);
        System.out.println();
        boolean customerService = true;
        while(customerService) {
            int selection = inputValidityChecker.getValidMarkInput("Select:\n    1. Open Account\n    2. Check Balance\n    3. Display Information\n    4. Cash In\n    5. Transfer Balance\n    6. Update Information\n    7. Exit\n", 7);
            if(selection==7) break;
            if(selection==1){
                customer1.openAccount();
            }
            else if(selection==2){
                customer1.checkBalance();
            }
            else if(selection==3){
                customer1.displayAccountInformation();
            }
            else if(selection==4){
                if(customer1.isAccountOpened) {
                    System.out.print("Sender Account Number: ");
                    String accNumber = sc.next();
                    double amount = inputValidityChecker.getValidInputDouble("Sent Amount: ");
                    customer1.cashIn(accNumber, amount);
                    System.out.println("Amount Received Successfully");
                }
                else{
                    System.out.println("Please open an account first.");
                }
            }
            else if(selection==5){
                if(customer1.isAccountOpened) {
                    System.out.print("Receiver Account Number: ");
                    String accNumber = sc.next();
                    double amount = inputValidityChecker.getValidInputDouble("Transferring Amount: ");
                    customer1.balanceTransfer(accNumber, amount);
                }
                else{
                    System.out.println("Please open an account first.");
                }
            }
            else if(selection==6){
//                System.out.println(bankAccountNumber);
//                System.out.println(customer1.isAccountOpened);
                if(customer1.isAccountOpened) {
                    System.out.print("Enter Account Number: ");
                    String accNumber = sc.next();
//                    System.out.println("Hello "+ customer1.bankAccountNumber);
//                    System.out.println("Main "+ bankAccountNumber);
                    customer1.updateAccountInformation(accNumber);
                }
                else{
                    System.out.println("Please open an account first.");
                }
            }
        }
    }
}
