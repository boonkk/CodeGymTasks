package com.codegym.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Reading and writing to a file: CodeGym

*/
public class Solution {
    public static void main(String[] args) {
        // You can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            CodeGym codeGym = new CodeGym();
            // Initialize users field for the codeGym object here
            codeGym.users.add(new User());

            codeGym.users.add(new User());
            codeGym.save(outputStream);
            outputStream.flush();

            CodeGym loadedObject = new CodeGym();
            loadedObject.load(inputStream);
            // Here check that the codeGym object is equal to the loadedObject object
            codeGym.equals(loadedObject);
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class CodeGym {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            byte[] lineSeparator = System.getProperty("line.separator").getBytes();

            outputStream.write(String.valueOf(users.size()).getBytes());
            outputStream.write(lineSeparator);
            outputStream.flush();

            if (!users.isEmpty()) {
                for (User user : users) {
                    boolean hasFirstName = user.getFirstName() != null;
                    outputStream.write(String.valueOf(hasFirstName).getBytes());
                    outputStream.write(lineSeparator);

                    if (hasFirstName) {
                        outputStream.write(String.valueOf(user.getFirstName()).getBytes());
                        outputStream.write(lineSeparator);
                    }

                    boolean hasLastName = user.getLastName() != null;
                    outputStream.write(String.valueOf(hasLastName).getBytes());
                    outputStream.write(lineSeparator);

                    if (hasLastName) {
                        outputStream.write(String.valueOf(user.getLastName()).getBytes());
                        outputStream.write(lineSeparator);
                    }

                    boolean hasBirthDate = user.getBirthDate() != null;
                    outputStream.write(String.valueOf(hasBirthDate).getBytes());
                    outputStream.write(lineSeparator);

                    if (hasBirthDate) {
                        outputStream.write(String.valueOf(user.getBirthDate().getTime()).getBytes());
                        outputStream.write(lineSeparator);
                    }

                    boolean isMale = user.isMale();
                    outputStream.write(String.valueOf(isMale).getBytes());
                    outputStream.write(lineSeparator);

                    if (isMale) {
                        outputStream.write(String.valueOf(user.isMale()).getBytes());
                        outputStream.write(lineSeparator);
                    }

                    boolean hasCountry = user.getCountry() != null;
                    outputStream.write(String.valueOf(hasCountry).getBytes());
                    outputStream.write(lineSeparator);

                    if (hasCountry) {
                        outputStream.write(String.valueOf(user.getCountry().getDisplayName()).getBytes());
                        outputStream.write(lineSeparator);
                    }

                    outputStream.flush();
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            int userCount = Integer.parseInt(reader.readLine());

            if (userCount > 0) {
                for (int i = 0; i < userCount; i++) {
                    User user = new User();

                    boolean hasFirstName =  Boolean.parseBoolean(reader.readLine());

                    if (hasFirstName ) {
                        user.setFirstName(reader.readLine());
                    }

                    boolean hasLastName = Boolean.parseBoolean(reader.readLine());

                    if( hasLastName ) {
                        user.setLastName(reader.readLine());
                    }

                    boolean hasBirthDate = Boolean.parseBoolean(reader.readLine());

                    if( hasBirthDate ) {
                        Date birthDate = new Date(Long.parseLong(reader.readLine()));
                        user.setBirthDate(birthDate);
                    }

                    boolean isMale = Boolean.parseBoolean(reader.readLine());

                    if( isMale ) {
                        user.setMale(Boolean.parseBoolean(reader.readLine()));
                    }

                    boolean hasCountry = Boolean.parseBoolean(reader.readLine());

                    if( hasCountry ) {
                        user.setCountry(getCountry(reader.readLine()));
                    }

                    users.add(user);
                }
            }

            reader.close();
        }

        private static boolean isUserNull(User user) {
            return user.getFirstName() == null &&
                    user.getLastName() == null &&
                    user.getBirthDate() == null &&
                    user.getCountry() == null;
        }

        private static User.Country getCountry(String country) {
            switch (country) {
                case "United States":
                    return User.Country.UNITED_STATES;
                case "United Kingdom":
                    return User.Country.UNITED_KINGDOM;
                default:
                    return User.Country.OTHER;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CodeGym codeGym = (CodeGym) o;

            return users != null ? users.equals(codeGym.users) : codeGym.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
