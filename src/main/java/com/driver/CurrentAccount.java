package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{

    private String tradeLicenseId; //consists of Uppercase English characters only
    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance,double minBalance,String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,minBalance);
        this.tradeLicenseId=tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean isValid=true;
        for(int i=1; i<tradeLicenseId.length(); i++){
            if(tradeLicenseId.charAt(i-1)==tradeLicenseId.charAt(i)){
                isValid=false;
                break;
            }
        }
        if(isValid){
            return;
        }
        char[] license=tradeLicenseId.toCharArray();
        Arrays.sort(license);
        for(int i=1; i< license.length;i++){
            if(license[i]==license[i-1]){
                throw new Exception("Valid License can not be generated");
            }
        }
    }

}