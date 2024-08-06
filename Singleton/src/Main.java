public class Main {
    public static void main(String[] args) {
        Singleton x = Singleton.getInstance("Bernardo", 18,
                "bernardo@gmail.com", "789.789.789-45");
        String y = SingletonEnum.INSTANCE.test(3);

        System.out.println(x.toString());
        System.out.println(y);

        Singleton z = Singleton.getInstance("João", 15,
                "João@gmail.com", "123.123.123-12");

        System.out.println(z.toString());
    }
}