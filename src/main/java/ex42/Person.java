package ex42;
import org.apache.commons.lang3.StringUtils;

public class Person {

    int salary;
    String firstName;
    String lastName;

    public Person(int salary, String firstName, String lastName) {
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("");
        output.append(StringUtils.rightPad(lastName , 20));
        output.append(StringUtils.rightPad(firstName, 20));
        output.append(StringUtils.rightPad("" + salary, 10));

        return output.toString();
    }
}
