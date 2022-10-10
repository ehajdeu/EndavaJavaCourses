package collections.session2;

public class ParameterizedClass {

    public static void main(String[] args) {
        Info<Integer> inf2 = new Info<>(12);
        System.out.println(inf2);
        Info<String> inf1 = new Info<>("Vasile");
        System.out.println(inf1);

        Pair<Integer,String> p1 = new Pair<>(1,"Andrei");
        System.out.println(p1);
    }
}

class Info <T>{
    private T fValue;

    public Info(T fValue) {
        this.fValue = fValue;
    }

    public T getfValue() {
        return fValue;
    }

    @Override
    public String toString() {
        return "Info{" +
            "fValue=" + fValue +
            '}';
    }
}

class Pair <T1, T2>{
    private T1 fValue;
    private T2 SValue;

    public Pair(T1 fValue, T2 SValue) {
        this.fValue = fValue;
        this.SValue = SValue;
    }

    @Override
    public String toString() {
        return "Pair{" +
            "fValue=" + fValue +
            ", SValue=" + SValue +
            '}';
    }
}
