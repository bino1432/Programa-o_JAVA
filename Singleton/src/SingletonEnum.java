public enum SingletonEnum {
    INSTANCE;

    public String test(int escolha){
        return switch (escolha) {
            case 1 -> "Escolha 1";
            case 2 -> "Escolha 2";
            default -> "Outra Escolha";
        };
    }
}
