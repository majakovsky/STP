public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int birthYear;
    private String birthPlace;
    private double salary;
    private String maritalStatus;

    // Конструктор
    public Employee(int id, String firstName, String lastName, int birthYear, String birthPlace, double salary, String maritalStatus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthPlace = birthPlace;
        this.salary = salary;
        this.maritalStatus = maritalStatus;
    }

    // Геттер для id
    public int getId() {
        return id;
    }

    // Геттер для firstName
    public String getFirstName() {
        return firstName;
    }

    // Сеттер для firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Геттер для lastName
    public String getLastName() {
        return lastName;
    }

    // Сеттер для lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Геттер для birthYear
    public int getBirthYear() {
        return birthYear;
    }

    // Сеттер для birthYear
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    // Геттер для birthPlace
    public String getBirthPlace() {
        return birthPlace;
    }

    // Сеттер для birthPlace
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    // Геттер для salary
    public double getSalary() {
        return salary;
    }

    // Сеттер для salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Геттер для maritalStatus
    public String getMaritalStatus() {
        return maritalStatus;
    }

    // Сеттер для maritalStatus
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
