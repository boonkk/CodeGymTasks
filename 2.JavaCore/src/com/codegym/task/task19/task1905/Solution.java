package com.codegym.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Reinforce the adapter

*/

public class Solution {
    public static Map<String,String> countries = new HashMap<>();
    static{
        countries.put("UA","Ukraine");
        countries.put("US","United States");
        countries.put("FR","France");
    }
    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            for(Map.Entry<String,String> entry : countries.entrySet()){
                if(entry.getValue().equals(customer.getCountryName())){
                    return entry.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {

            String[] lastName = contact.getName().split(" ");
            return lastName[1];
        }

        @Override
        public String getContactLastName() {
            String[] firstName = contact.getName().split(",");
            return firstName[0];
        }

        @Override
        public String getDialString() {
            String pNo = contact.getPhoneNumber();
            char[] letters = pNo.toCharArray();
            StringBuffer sb = new StringBuffer();
            sb.append("callto://");
            for(int i=0;i<letters.length;i++){
                if(letters[i]!='('&&letters[i]!=')'&&letters[i]!='-'){
                    sb.append(letters[i]);
                }
            }
            return sb.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        // For example: US
        String getCompany();            // For example: CodeGym Ltd.
        String getContactFirstName();   // For example: John
        String getContactLastName();    // For example: Peterson
        String getDialString();         // For example: callto://+11112223333
    }

    public static interface Customer {
        String getCompanyName();        // For example: CodeGym Ltd.
        String getCountryName();        // For example: United States
    }

    public static interface Contact {
        String getName();               // For example: Peterson, John
        String getPhoneNumber();        // For example: +1(111)222-3333, +3(805)0123-4567, +380(50)123-4567, etc.
    }
}