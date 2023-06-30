package com.company;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private String address;
    private List<String> employeeList;

    public Bank(){
        this.employeeList = new ArrayList<>();

    }
    public void setBankName(String bankName){
        this.bankName = bankName;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void addEmployee(String employee){
        employeeList.add(employee);
    }
    public void displayBankInformation(){
        System.out.println("Bank Name: "+ bankName);
        System.out.println("Bank Address: "+ address);
        System.out.println("Bank Employee List: "+ employeeList);
    }
}
