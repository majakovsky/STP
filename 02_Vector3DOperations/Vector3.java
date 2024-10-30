public class Vector3 {
    private double x;
    private double y;
    private double z;

    // Конструктор для создания вектора
    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Метод для вычисления скалярного произведения двух векторов
    public double dotProduct(Vector3 other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    // Метод для вычисления векторного произведения двух векторов
    public Vector3 crossProduct(Vector3 other) {
        double crossX = this.y * other.z - this.z * other.y;
        double crossY = this.z * other.x - this.x * other.z;
        double crossZ = this.x * other.y - this.y * other.x;
        return new Vector3(crossX, crossY, crossZ);
    }

    // Метод для сложения двух векторов
    public Vector3 add(Vector3 other) {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    // Метод для вычитания двух векторов
    public Vector3 subtract(Vector3 other) {
        return new Vector3(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    // Метод для вычисления модуля (длины) вектора
    public double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    // Метод для вычисления угла между двумя векторами в радианах
    public double angleBetween(Vector3 other) {
        double dotProd = this.dotProduct(other);
        double magnitudes = this.magnitude() * other.magnitude();
        return Math.acos(dotProd / magnitudes);
    }

    // Геттеры для значений x, y и z
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    // Пример использования
    public static void main(String[] args) {
        // Создаем два вектора
        Vector3 v1 = new Vector3(1.0, 2.0, 3.0);
        Vector3 v2 = new Vector3(4.0, 5.0, 6.0);

        // Скалярное произведение
        System.out.println("Скалярное произведение v1 и v2: " + v1.dotProduct(v2));

        // Векторное произведение
        Vector3 crossProduct = v1.crossProduct(v2);
        System.out.println("Векторное произведение v1 и v2: (" + crossProduct.getX() + ", " + crossProduct.getY() + ", " + crossProduct.getZ() + ")");

        // Сложение векторов
        Vector3 sum = v1.add(v2);
        System.out.println("Сложение v1 и v2: (" + sum.getX() + ", " + sum.getY() + ", " + sum.getZ() + ")");

        // Вычитание векторов
        Vector3 difference = v1.subtract(v2);
        System.out.println("Вычитание v1 и v2: (" + difference.getX() + ", " + difference.getY() + ", " + difference.getZ() + ")");

        // Модуль (длина) вектора
        System.out.println("Модуль вектора v1: " + v1.magnitude());

        // Угол между векторами в радианах
        System.out.println("Угол между v1 и v2: " + v1.angleBetween(v2) + " радиан");
    }
}

