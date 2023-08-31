package cn.argentoaskia.beans;

public class Generics<T> {

    private T data;

    public Generics() {
    }

    public Generics(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Generics{");
        sb.append("data=").append(data);
        sb.append('}');
        return sb.toString();
    }

    public T getData() {
        return data;
    }

    public Generics<T> setData(T data) {
        this.data = data;
        return this;
    }
}
