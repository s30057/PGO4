import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class Program {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Developer dev = new Developer("John", "Doe", "New York", "john@doe.com", "123456789", 2020);
        dev.addTechnology(new Technology("Java", 800));
        employees.add(dev);
        Tester tester = new Tester("Jane", "Smith", "Los Angeles", "jane@smith.com", "987654321", 2021);
        tester.addTestType("UI/UX");
        employees.add(tester);
        Manager manager = new Manager("Bob", "Johnson", "Chicago", "bob@johnson.com", "1122334455", 2019);
        manager.addGoal(new Goal(2010, 10, 15, "Implementing FB login", 1000));
        employees.add(manager);
        int totalAmount = 0;
        for (Employee employee : employees) {
            totalAmount += employee.calculateSalary();
        }
        System.out.println("Total amount to be paid this month: " + totalAmount + " USD");
    }
}
class Employee {
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String email;
    protected String pesel;
    protected int employmentYear;
    public Employee(String firstName, String lastName, String address, String email, String pesel, int employmentYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.employmentYear = employmentYear;
    }
    public int calculateSalary() {
        int baseSalary = 3000 + (Calendar.getInstance().get(Calendar.YEAR) - employmentYear) * 1000;
        return baseSalary;
    }
}
class Developer extends Employee {
    private List<Technology> technologies = new ArrayList<>();
    public Developer(String firstName, String lastName, String address, String email, String pesel, int employmentYear) {
        super(firstName, lastName, address, email, pesel, employmentYear);
    }
    public void addTechnology(Technology technology) {
        technologies.add(technology);
    }
    @Override
    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        for (Technology tech : technologies) {
            baseSalary += tech.getBonus();
        }
        return baseSalary;
    }
}
class Tester extends Employee {
    private List<String> testTypes = new ArrayList<>();
    public Tester(String firstName, String lastName, String address, String email, String pesel, int employmentYear) {
        super(firstName, lastName, address, email, pesel, employmentYear);
    }
    public void addTestType(String testType) {
        testTypes.add(testType);
    }
    @Override
    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        baseSalary += testTypes.size() * 300;
        return baseSalary;
    }
}
class Manager extends Employee {
    private List<Goal> goals = new ArrayList<>();
    public Manager(String firstName, String lastName, String address, String email, String pesel, int employmentYear) {
        super(firstName, lastName, address, email, pesel, employmentYear);
    }
    public void addGoal(Goal goal) {
        goals.add(goal);
    }
    @Override
    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // Month starts from 0
        for (Goal goal : goals) {
            if (goal.getYear() == currentYear && goal.getMonth() == currentMonth) {
                baseSalary += goal.getBonus();
            }
        }
        return baseSalary;
    }
}
class Technology {
    private String name;
    private int bonus;
    public Technology(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }
    public int getBonus() {
        return bonus;
    }
}
class Goal {
    private int year;
    private int month;
    private int day;
    private String name;
    private int bonus;
    public Goal(int year, int month, int day, String name, int bonus) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
        this.bonus = bonus;
    }
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public int getBonus() {
        return bonus;
    }
}