package utils;

import net.datafaker.Faker;

public class FakeData {

    private static final Faker faker = new Faker();

    public String getId() {
        return faker.number().digits(7);
    }

    public static String getPostalCode() {
        return faker.number().digits(6);
    }

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    public String getCountry() {
        return faker.country().toString();
    }

    public String getCity() {
        return faker.address().cityName();
    }

    public String getYear() {
        return Integer.toString(faker.number().numberBetween(1950, 2000));
    }
}
