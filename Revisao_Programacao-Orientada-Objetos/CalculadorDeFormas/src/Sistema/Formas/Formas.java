package Sistema.Formas;

import java.util.ArrayList;

public abstract class Formas {

    private static final ArrayList<Formas> formas = new ArrayList<>();

    public static void addForma(Formas forma) {
        formas.add(forma);
    }
}
