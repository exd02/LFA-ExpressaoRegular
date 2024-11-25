import ExpressaoRegular.ExpressaoRegular;

public class Main {
    public static void main(String[] args) {
        ExpressaoRegular ER = new ExpressaoRegular();

//        ER.confere(ER.ASSINATURA_FUNCAO, " void test2 (int a, float b);");
//        ER.confere(ER.PARAMETROS_FUNCAO, " (int a, float b)");
//        ER.confere(ER.CONDICIONAL, " if ( ano < 199 ) ");
//        ER.confere(ER.CONDICIONAL, " if ( 3 * ano > 4 + ano ) ");
//        ER.confere(ER.EXPRESSAO_ARITMETICA, "3 + media/3");
//        ER.confere(ER.EXPRESSAO_ARITMETICA, "-4 + beta * media[1].x * soma(a,b)/4 * vetor[5].idade");
        ER.confere(ER.LFA13_EX2, "abzajksa");
        ER.confere(ER.LFA13_EX3, "teste@gmail.com");
        ER.confere(ER.LFA13_EX3, "testegmail.com");
    }
}