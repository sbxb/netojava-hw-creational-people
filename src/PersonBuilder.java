public class PersonBuilder {
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 125;
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age < MIN_AGE || age > MAX_AGE)
            throw new IllegalArgumentException("cannot set wrong age");
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || name.isEmpty() || surname == null || surname.isEmpty()) {
            throw new IllegalStateException("nonempty name and surname must be set for a person");
        }

        if (age == -1) {
            return new Person(name, surname);
        } else {
            return new Person(name, surname, age);
        }
    }
}
