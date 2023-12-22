package com.scaler.bookmyshow;

import com.scaler.bookmyshow.models.BaseModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication {

    public static void main(String[] args) {
        BaseModel baseModel = new BaseModel();
        baseModel.getId();
        SpringApplication.run(BookMyShowApplication.class, args);
    }

}
