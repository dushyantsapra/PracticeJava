package com.protoSampleCode;

import com.protos.AddressBookProtos;
import com.protos.CustomerDataProtos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProtobufMain {
    public static void main(String[] args) throws IOException {
        String email = "protobuf@gmail.com";
        int id = new Random().nextInt();
        String name = "Protobuf";
        String number = "01234567890";
        AddressBookProtos.Person person =
                AddressBookProtos.Person.newBuilder()
                        .setId(id)
                        .setName(name)
                        .setEmail(email)
                        .addNumbers(number)
                        .build();

        String filePath = "src/main/resources/person.txt";

        AddressBookProtos.AddressBook addressBook
                = AddressBookProtos.AddressBook.newBuilder().addPeople(person).build();
        FileOutputStream fos = new FileOutputStream(filePath);
        addressBook.writeTo(fos);


        AddressBookProtos.AddressBook deserialized
                = AddressBookProtos.AddressBook.newBuilder()
                .mergeFrom(new FileInputStream(filePath)).build();

        System.out.println(deserialized);

        String filePath1 = "src/main/resources/customer.txt";

        List<String> addresses = Arrays.asList("Rewari", "Gurgaon", "Delhi");

        CustomerDataProtos.CustomerData customerData = CustomerDataProtos.CustomerData.newBuilder().setId(1).setName("Dushyant").addAllAddress(addresses).build();
        FileOutputStream fop = new FileOutputStream(filePath1);

        customerData.writeTo(fop);

        CustomerDataProtos.CustomerData cd = CustomerDataProtos.CustomerData.newBuilder().mergeFrom(new FileInputStream(filePath1)).build();
        System.out.println(cd);
    }

}