package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileUtilsTest {

    @Test
    public void addressesFromProfiles() {
        List<Profile> profileList = Arrays.asList(
                new Profile("Patricia", new Address("SPb", "Ushakova", 55, 234)),
                new Profile("Petr", new Address("Moscow", "Sadovaya", 2, 112))
        );
        List<Address> expected = Arrays.asList(
                new Address("SPb", "Ushakova", 55, 234),
                new Address("Moscow", "Sadovaya", 2, 112)
        );
        assertThat(new ProfileUtils().collect(profileList), is(expected));
    }

    @Test
    public void getSortedUniqueAddresses() {
        List<Address> addresses = Arrays.asList(
                new Address("SPb", "Ushakova", 55, 234),
                new Address("SPb", "Ushakova", 55, 234),
                new Address("Los Angeles", "Moskovskaya", 87, 1234),
                new Address("Moscow", "Sadovaya", 2, 112)
        );
        List<Address> expected = Arrays.asList(
                new Address("Los Angeles", "Moskovskaya", 87, 1234),
                new Address("Moscow", "Sadovaya", 2, 112),
                new Address("SPb", "Ushakova", 55, 234)
        );
        assertThat(new ProfileUtils().uniqueAddress(addresses), is(expected));
    }
}