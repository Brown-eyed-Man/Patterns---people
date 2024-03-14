public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
            return this;
        }
        throw new IllegalArgumentException("Некорректное имя.");
    }

    public PersonBuilder setSurname(String surname) {
        if (!surname.trim().isEmpty()) {
            this.surname = surname;
            return this;
        }
        throw new IllegalArgumentException("Некорректная фамилия.");
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Некорректный возраст.");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (!address.trim().isEmpty()) {
            this.address = address;
            return this;
        }
        throw new IllegalArgumentException("Некорректный адрес.");
    }

    public Person build() {
        Person person;
        if (name != null && surname != null) {
            if (age < 0) {
                person = new Person(name, surname);
            } else {
                person = new Person(name, surname, age);
            }
            person.setAddress(address);
            return person;
        }
        throw new IllegalStateException("Не хватает данных.");
    }
}