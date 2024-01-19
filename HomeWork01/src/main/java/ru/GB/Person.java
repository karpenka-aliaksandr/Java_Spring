package ru.GB;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Person person)) return false;

        return new EqualsBuilder().append(firstName, person.firstName).append(lastName, person.lastName).isEquals();
    }
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName)
                .append(firstName)
                .toHashCode();
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("Firstname", firstName)
                .append("Lastname", lastName)
                .toString();
    }

}
