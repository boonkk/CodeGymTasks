package com.codegym.task.task19.task1903;

/* 
Adapting multiple interfaces

*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<>();
    static{
        countries.put("UA","Ukraine");
        countries.put("US", "United States");
        countries.put("FR","France");

    }
    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;
        public IncomeDataAdapter(IncomeData data) {
            this.data=data;
        }
        @Override
        public String getCompanyName() {
           return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            StringBuffer sb = new StringBuffer();
            sb.append("+" + data.getCountryPhoneCode());

            int zerosCount = 10-Integer.toString(data.getPhoneNumber()).length();
            for(int i=0;i<zerosCount;i++){
                sb.append("0");
            }
            sb.append(data.getPhoneNumber());
            sb.insert(Integer.toString(data.getCountryPhoneCode()).length()+1,"(");
            sb.insert(Integer.toString(data.getCountryPhoneCode()).length()+5,")");
            sb.insert(sb.length()-4,"-");
            sb.insert(sb.length()-2, "-");
            return sb.toString() ;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        // For example: US

        String getCompany();            // For example: CodeGym Ltd.

        String getContactFirstName();   // For example: John

        String getContactLastName();    // For example: Smith

        int getCountryPhoneCode();      // For example: 1

        int getPhoneNumber();           // For example: 991234567
    }

    public static interface Customer {
        String getCompanyName();        // For example: CodeGym Ltd.

        String getCountryName();        // For example: United States
    }

    public static interface Contact {
        String getName();               // For example: Smith, John

        String getPhoneNumber();        // For example: +1(099)123-45-67
    }
}