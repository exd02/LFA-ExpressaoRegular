import ExpressaoRegular.ExpressaoRegular;

public class Main {
    public static void main(String[] args) {
        ExpressaoRegular ER = new ExpressaoRegular();

//        ER.confere(ER.DIGITOS, "000511200021");
//        ER.confere(ER.ASSINATURA_FUNCAO, "void funcao1(int a, float b)");
//        ER.confere(ER.BRANCO, "");
//        ER.confere(ER.BRANCOS, "");
        ER.confere(ER.CONDICIONAL, " if ( ano < 199 ) ");
        ER.confere(ER.CONDICIONAL, " if ( 3 * ano > 4 + ano ) ");
    }
}