import ExpressaoRegular.ExpressaoRegular;

public class Main {
    public static void main(String[] args) {
        ExpressaoRegular ER = new ExpressaoRegular();

        ER.confere(ER.DIGITOS, "000511200021");
        ER.confere(ER.ASSINATURA_FUNCAO, "void funcao1(int a, float b)");
    }
}