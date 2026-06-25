public class Person {
    private String name;
    private int age;

    // Default constructor
    public Person() {}

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() throws Exception {
        if(age < 0) {
            throw new Exception("Invalid Age!");
        }
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}