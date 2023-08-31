package cn.argento.askia.beans2;

public class Employee2 {
    private User2 user2;
    private Company company;
    private Area area;


    public Employee2() {
    }

    public Employee2(User2 user2, Company company, Area area) {
        System.out.println("Employee构造方法被调用");
        this.user2 = user2;
        this.company = company;
        this.area = area;
    }

    public Area getArea() {
        return area;
    }

    public Employee2 setArea(Area area) {
        this.area = area;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee2{");
        sb.append("user=").append(user2);
        sb.append(", company=").append(company);
        sb.append(", area=").append(area);
        sb.append('}');
        return sb.toString();
    }

    public User2 getUser() {
        return user2;
    }

    // 注解形式byType
    public Employee2 setUser(User2 user2) {
        this.user2 = user2;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    // 注解形式byName注入
    public Employee2 setCompany(Company company) {
        this.company = company;
        return this;
    }
}
