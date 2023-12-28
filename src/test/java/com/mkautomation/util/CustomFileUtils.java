package com.mkautomation.util;

import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CustomFileUtils {

    private static final Logger log = LoggerFactory.getLogger(CustomFileUtils.class);
    static int n = 0;

    public void writeDataToCSVFile(String loginName, String password, String fileName, int noOfUsers,
                                   String firstName, String lastName, String passwordUsers, String emailId, List<String> roles) {

        List<String[]> valueFinal = new ArrayList<String[]>();
        try {
            String profileId = "";
            String userId = "";
            String role = "";
            String memberOfGroup = "";
            String ownGroup = "";

            if (roles.size() > 0) {
                for (int j = 0; j < roles.size(); j++) {
                    role = role + roles.get(j).toString() + ",";
                    log.info(role);
                }
            }
            role = "["+role.replaceAll(",$", "")+"]";
            log.info(role);

            String appendValue = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\" + fileName
                    + ".csv";
            log.info("CURRENT WORKING DIR: " + appendValue);

            File file = new File(appendValue);
            FileWriter fw = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fw);

            List<String[]> data = new LinkedList<String[]>();
            data.add(new String[]{"Login Id", "Last Name", "First Name",
                    "Password", "Roles", "Email"});
            for (int i = 0; i < noOfUsers; i++) {
                Random rand = new Random();
                n = rand.nextInt(50000);
                String v = String.valueOf(n);
                data.add(new String[]{v+loginName,v + lastName,
                        v + firstName, passwordUsers, role,
                        v + emailId});

            }
            writer.writeAll(data);
            writer.close();
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        String fileName = "user";

        List<String> roles=new ArrayList<String>();
        roles.add("Tester");
        roles.add("Developer");

        CustomFileUtils customFileUtils=new CustomFileUtils();
        customFileUtils.writeDataToCSVFile("mangeshkhaire","Test@1234",fileName,5,"Mangesh","Khaire","Test@1234","mangeshkhaire14@gmail.com",roles);
    }
}
