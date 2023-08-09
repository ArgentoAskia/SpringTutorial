package cn.argentoaskia.beans;

public class Employee {
    private User user;
    private Company company;

    public Employee() {
    }

    public Employee(User user, Company company) {
        System.out.println("Employee构造方法被调用");
        this.user = user;
        this.company = company;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("user=").append(user);
        sb.append(", company=").append(company);
        sb.append('}');
        return sb.toString();
    }

    public User getUser() {
        return user;
    }

    public Employee setUser(User user) {
        this.user = user;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Employee setCompany(Company company) {
        this.company = company;
        return this;
    }
}
