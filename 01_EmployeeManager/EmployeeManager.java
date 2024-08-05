import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    // Метод для добавления нового сотрудника через ввод данных
    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        int id;

        // Цикл для ввода уникального идентификатора
        while (true) {
            System.out.print("Введите идентификатор сотрудника: ");
            id = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            if (isUniqueId(id)) {
                break;
            } else {
                System.out.println("Сотрудник с таким идентификатором уже существует. Пожалуйста, введите другой идентификатор.");
            }
        }

        // Ввод других данных сотрудника
        System.out.print("Введите имя сотрудника: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите фамилию сотрудника: ");
        String lastName = scanner.nextLine();
        System.out.print("Введите год рождения сотрудника: ");
        int birthYear = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        System.out.print("Введите место рождения сотрудника: ");
        String birthPlace = scanner.nextLine();
        System.out.print("Введите зарплату сотрудника: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера
        System.out.print("Введите семейное положение сотрудника: ");
        String maritalStatus = scanner.nextLine();

        // Создание и добавление нового сотрудника
        Employee employee = new Employee(id, firstName, lastName, birthYear, birthPlace, salary, maritalStatus);
        employees.add(employee);
        System.out.println("Сотрудник добавлен успешно.");
    }

    // Перегруженный метод для добавления сотрудника через объект Employee
    public void addEmployee(Employee employee) {
        if (isUniqueId(employee.getId())) {
            employees.add(employee);
            System.out.println("Сотрудник добавлен успешно.");
        } else {
            System.out.println("Сотрудник с таким идентификатором уже существует.");
        }
    }

    // Метод для проверки уникальности идентификатора
    private boolean isUniqueId(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return false;
            }
        }
        return true;
    }

    // Метод для поиска сотрудника по идентификатору
    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // Метод для поиска сотрудников по имени
    public List<Employee> findEmployeesByName(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getFirstName().equalsIgnoreCase(name)) {
                result.add(employee);
            }
        }
        return result;
    }

    // Метод для поиска сотрудников по году рождения
    public List<Employee> findEmployeesByBirthYear(int birthYear) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getBirthYear() == birthYear) {
                result.add(employee);
            }
        }
        return result;
    }

    // Метод для изменения информации о сотруднике
    public void updateEmployee(int id, String field, String newValue) {
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Сотрудник с таким идентификатором не найден.");
            return;
        }

        switch (field.toLowerCase()) {
            case "имя":
                employee.setFirstName(newValue);
                break;
            case "фамилия":
                employee.setLastName(newValue);
                break;
            case "год рождения":
                try {
                    int newBirthYear = Integer.parseInt(newValue);
                    employee.setBirthYear(newBirthYear);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Неверный формат года рождения.");
                }
                break;
            case "место рождения":
                employee.setBirthPlace(newValue);
                break;
            case "зарплата":
                try {
                    double newSalary = Double.parseDouble(newValue);
                    employee.setSalary(newSalary);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Неверный формат зарплаты.");
                }
                break;
            case "семейное положение":
                employee.setMaritalStatus(newValue);
                break;
            default:
                System.out.println("Ошибка: Некорректное поле.");
                return;
        }

        System.out.println("Информация о сотруднике обновлена.");
    }

    // Метод для расчета общей суммы заработной платы
    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    // Вспомогательный метод для печати информации о сотруднике
    public void printEmployeeInfo(Employee employee) {
        if (employee == null) {
            System.out.println("Сотрудник не найден.");
            return;
        }
        System.out.println("Информация о сотруднике:");
        System.out.println("ID: " + employee.getId());
        System.out.println("Имя: " + employee.getFirstName());
        System.out.println("Фамилия: " + employee.getLastName());
        System.out.println("Год рождения: " + employee.getBirthYear());
        System.out.println("Место рождения: " + employee.getBirthPlace());
        System.out.println("Зарплата: " + employee.getSalary());
        System.out.println("Семейное положение: " + employee.getMaritalStatus());
        System.out.println("-----------------------------");
    }

    // Метод main для запуска программы
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        // Примеры использования программы
        manager.addEmployee(); // Добавление нового сотрудника

        // Поиск сотрудника по идентификатору
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите идентификатор сотрудника для поиска: ");
        int searchId = scanner.nextInt();
        manager.printEmployeeInfo(manager.findEmployeeById(searchId));

        // Поиск сотрудников по имени
        scanner.nextLine(); // Очистка буфера
        System.out.print("Введите имя сотрудника для поиска: ");
        String searchName = scanner.nextLine();
        List<Employee> employeesByName = manager.findEmployeesByName(searchName);
        for (Employee e : employeesByName) {
            manager.printEmployeeInfo(e);
        }

        // Поиск сотрудников по году рождения
        System.out.print("Введите год рождения для поиска сотрудников: ");
        int searchYear = scanner.nextInt();
        List<Employee> employeesByYear = manager.findEmployeesByBirthYear(searchYear);
        for (Employee e : employeesByYear) {
            manager.printEmployeeInfo(e);
        }

        // Изменение информации о сотруднике
        System.out.print("Введите идентификатор сотрудника для изменения: ");
        int updateId = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        System.out.print("Введите поле для изменения (Имя, Фамилия, Год рождения, Место рождения, Зарплата, Семейное положение): ");
        String field = scanner.nextLine();
        System.out.print("Введите новое значение: ");
        String newValue = scanner.nextLine();
        manager.updateEmployee(updateId, field, newValue);

        // Расчет общей суммы заработной платы
        double totalSalary = manager.calculateTotalSalary();
        System.out.println("Общая сумма заработной платы всех сотрудников: " + totalSalary);
    }
}
