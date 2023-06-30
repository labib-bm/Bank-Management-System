package com.company;

import java.util.Scanner;

public class Customer {
    private String customerName;
    private String customerAddress;
    public String bankAccountNumber;
    private double accountBalance;
    public boolean isAccountOpened;
    public Customer(String customerName, String customerAddress, String bankAccountNumber){
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.bankAccountNumber = bankAccountNumber;
        this.accountBalance = 0.00;
        this.isAccountOpened = false;
    }
    public void openAccount() {
        if (isAccountOpened) {
            System.out.println("Account already opened.");
        } else {
            System.out.println("Account opening in process.");
            isAccountOpened = true;
            System.out.println("Account Holder Name: " + customerName);
            System.out.println("Account Number: " + bankAccountNumber);
            System.out.println("Account Balance: " + accountBalance);
        }
    }
    public void cashIn(String senderAccountNumber, double balance){
        if(isAccountOpened){
            System.out.println("Balance Amount: "+ balance + " cash in from Account Number: " + senderAccountNumber);
            accountBalance += balance;
            System.out.println("Current Balance: " + accountBalance);
        }
        else {
            System.out.println("Please open an account first.");
        }
    }
    public void balanceTransfer(String receiverAccountNumber, double balanceTransferred){
        if(isAccountOpened){
            System.out.println("Balance Transferring Account Number: " + bankAccountNumber);
            System.out.println("Balance will be transferred to Account Number: " + receiverAccountNumber);
            if(accountBalance<balanceTransferred) {
                System.out.println("Insufficient Balance for transfer.");
                System.out.println("Your Account balance: " + accountBalance);
            }
            else{
                System.out.println("Transferred amount: " + balanceTransferred + " to Account No: "+ receiverAccountNumber);
                accountBalance = accountBalance - balanceTransferred;
                System.out.println("Account Balance: " + accountBalance);
            }
        }
        else {
            System.out.println("Please open an account first.");
        }
    }
    public void checkBalance(){
        if(isAccountOpened){
            System.out.println("Customer Name: " + customerName);
            System.out.println("Customer Bank Account Number: " + bankAccountNumber);
            System.out.println("Customer Bank Balance: " + accountBalance);
        }
        else {
            System.out.println("Please open an account first.");
        }
    }
    public void updateAccountInformation(String AccountNumber){
        //System.out.println(isAccountOpened);
        if(isAccountOpened){
//            System.out.println(this.bankAccountNumber);
//            System.out.println(AccountNumber);
//            System.out.println(this.bankAccountNumber==AccountNumber);
            if(this.bankAccountNumber.equals(AccountNumber)){
//                System.out.println("Hello Check");
                Scanner sc = new Scanner(System.in);
                int select = inputValidityChecker.getValidMarkInput("Change account: \n   1. Name\n   2. Address\n   3. Name and Address\n",3);
                if(select==1){
                    System.out.print("Account Holder Name: ");
                    String accountHolderName = sc.nextLine();
                    this.customerName = accountHolderName;
                }
                else if(select==2){
                    System.out.print("Account Holder Address: ");
                    String accountHolderAddress = sc.nextLine();
                    this.customerAddress = accountHolderAddress;
                }
                else if(select==3){
                    System.out.print("Account Holder Name: ");
                    String accountHolderName = sc.nextLine();
                    this.customerName = accountHolderName;
                    System.out.print("Account Holder Address: ");
                    String accountHolderAddress = sc.nextLine();
                    this.customerAddress = accountHolderAddress;
                }
            }
        }
        else {
            System.out.println("Please open an account first.");
        }
    }
    public void displayAccountInformation(){
        if(isAccountOpened){
            System.out.println("Customer Name: " + customerName);
            System.out.println("Customer Address: " + customerAddress);
            System.out.println("Customer Bank Account Number: " + bankAccountNumber);
            System.out.println("Customer Bank Balance: " + accountBalance);
        }
        else {
            System.out.println("Please open an account first.");
        }
    }
}
