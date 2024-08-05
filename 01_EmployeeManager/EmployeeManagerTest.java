import java.util.List; // Импорт интерфейса List
import java.util.ArrayList; // Импорт класса ArrayList для создания списка

public class EmployeeManagerTest {

    public static void main(String[] args) {
        EmployeeManagerTest test = new EmployeeManagerTest();
        test.testAddEmployee();
        test.testFindEmployeeById();
        test.testFindEmployeesByName();
        test.testFindEmployeesByBirthYear();
        test.testUpdateEmployee();
        test.testCalculateTotalSalary();
    }

    public void testAddEmployee() {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee(1, "Иван", "Иванов", 1980, "Москва", 50000, "Женат"));
        manager.addEmployee(new Employee(2, "Петр", "Петров", 1990, "Санкт-Петербург", 60000, "Холост"));

        Employee employee1 = manager.findEmployeeById(1);
        Employee employee2 = manager.findEmployeeById(2);

        assert employee1 != null : "Ошибка: Сотрудник с ID 1 не найден";
        assert employee2 != null : "Ошибка: Сотрудник с ID 2 не найден";

        System.out.println("Тест добавления сотрудников пройден.");
    }

    public void testFindEmployeeById() {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee(1, "Иван", "Иванов", 1980, "Москва", 50000, "Женат"));

        Employee employee = manager.findEmployeeById(1);
        assert employee != null : "Ошибка: Сотрудник с ID 1 не найден";
        assert "Иван".equals(employee.getFirstName()) : "Ошибка: Неверное имя сотрудника";

        System.out.println("Тест поиска сотрудника по ID пройден.");
    }

    public void testFindEmployeesByName() {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee(1, "Иван", "Иванов", 1980, "Москва", 50000, "Женат"));
        manager.addEmployee(new Employee(2, "Иван", "Петров", 1990, "Санкт-Петербург", 60000, "Холост"));

        List<Employee> employees = manager.findEmployeesByName("Иван");
        assert employees.size() == 2 : "Ошибка: Найдено неверное количество сотрудников с именем Иван";

        System.out.println("Тест поиска сотрудников по имени пройден.");
    }

    public void testFindEmployeesByBirthYear() {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee(1, "Иван", "Иванов", 1980, "Москва", 50000, "Женат"));
        manager.addEmployee(new Employee(2, "Петр", "Петров", 1990, "Санкт-Петербург", 60000, "Холост"));

        List<Employee> employees = manager.findEmployeesByBirthYear(1980);
        assert employees.size() == 1 : "Ошибка: Найдено неверное количество сотрудников, родившихся в 1980 году";

        System.out.println("Тест поиска сотрудников по году рождения пройден.");
    }

    public void testUpdateEmployee() {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee(1, "Иван", "Иванов", 1980, "Москва", 50000, "Женат"));

        manager.updateEmployee(1, "фамилия", "Сидоров");

        Employee updatedEmployee = manager.findEmployeeById(1);
        assert "Сидоров".equals(updatedEmployee.getLastName()) : "Ошибка: Обновление фамилии сотрудника не удалось";

        System.out.println("Тест обновления информации о сотруднике пройден.");
    }

    public void testCalculateTotalSalary() {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee(1, "Иван", "Иванов", 1980, "Москва", 50000, "Женат"));
        manager.addEmployee(new Employee(2, "Петр", "Петров", 1990, "Санкт-Петербург", 60000, "Холост"));

        double totalSalary = manager.calculateTotalSalary();
        assert totalSalary == 110000 : "Ошибка в расчете общей суммы заработной платы";

        System.out.println("Тест расчета общей суммы заработной платы пройден.");
    }
}

