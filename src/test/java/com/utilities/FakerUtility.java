package com.utilities;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

import java.util.Locale;

public class FakerUtility {

    private static Faker faker = new Faker(Locale.US);

    public static AddressPOJO getAddressDetails(){
        return new AddressPOJO(faker.company().name(),
                faker.address().buildingNumber(),
                faker.address().streetName(),
                faker.address().city(),
                faker.numerify("#####"),
                faker.phoneNumber().cellPhone(),
                faker.phoneNumber().cellPhone(),
                faker.lorem().sentence(1),
                faker.lorem().sentence(1),
                faker.address().state());
    }

}
