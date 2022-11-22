package com.example.removeduplicateobject;

import com.example.removeduplicateobject.model.CustomerInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class RemoveDuplicateObjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemoveDuplicateObjectApplication.class, args);

        List<CustomerInfo> customerInfos = new ArrayList<>();
        CustomerInfo customerInfo = new CustomerInfo("AGE", "23");
        customerInfos.add(customerInfo);
        CustomerInfo customerInfo1 = new CustomerInfo("NAME", "HUNG");
        customerInfos.add(customerInfo1);
        CustomerInfo customerInfo2 = new CustomerInfo("NAME", "HUNG");
        customerInfos.add(customerInfo2);
        CustomerInfo customerInfo3 = new CustomerInfo("ADDRESS", "54_STREET");
        customerInfos.add(customerInfo3);
        customerInfos.forEach(x -> System.out.print("Key:" + x.getKey() + " Value:" + x.getValue() + "\n"));

        System.out.print("====HANDLE REMOVE DUPLICATE OBJECT====== \n");
        List<CustomerInfo> customerInfosUnique = customerInfos.stream().distinct().collect(Collectors.toList());
        customerInfosUnique.forEach(x -> System.out.print("Key:" + x.getKey() + " Value:" + x.getValue() + "\n"));
    }
}
