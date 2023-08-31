package cn.argento.askia.beans2;

public class Area {
    private String address;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Area{");
        sb.append("address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Area(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Area setAddress(String address) {
        this.address = address;
        return this;
    }
}
