package ExpressaoRegular;

public class ExpressaoRegular {
    public String BRANCO, BRANCOS, BRANCOS_MIN1;
    public String DIGITO, DIGITOS;
    public String LETRA, LETRAS;
    public String IDENT;
    public String EXPONENCIAL;
    public String REAL;
    public String INTEIRO;
    public String NUMEROS;
    public String ATRIBUICAO;
    public String OPERADOR;
    public String CONDICIONAL;
    public String PARAMETRO;
    public String OPERADOR_ARITMETICO;
    public String EXPRESSAO;
    public String EXPRESSAO_ARITMETICA;
    public String INDEXACAO;
    public String CHAMADA_METODO;
    public String ATRIBUTO;

    // trabalho 02
    public String ASSINATURA_FUNCAO;

    /**
     * *****************************************
     * Trabalho 02
     *
     * Faças as Expressoes Regulares para reconhecer: 1. Assinatura de funções
     * ex: void funcao1(int a, float b) ex: String funcao2()
     *
     * 2. Parametros de funções ex: int a, float b ex: float media, String nome
     *
     * 3. Condicional ex: if(ano < 1990) ex: if(3*a != 4+t)
     *
     * 4. Expressão matemática ex: 3+media/3 ex: -4+beta*media[1].x ex: soma(a,
     * b)/4*vetor[5].idade
     *
     * OBS_1: Muitos erros ocorrem por falta de parenteses em torno da
     * expressão, logo use e abuse dos parenteses, eles nunca serão demais.
     *
     * OBS_2: A cada nova Expressao Regualar feita, teste-a.
     * ******************************************
     */
    public ExpressaoRegular() {
        BRANCO = "(\\s)";
        BRANCOS = BRANCO + "*";
        BRANCOS_MIN1 = BRANCO + "+";

        DIGITO = "([0-9])";
        DIGITOS = DIGITO + "+";
        LETRA = "([A-Za-z])";
        LETRAS = LETRA + "*";

        IDENT = "(" + LETRA + "(" + LETRA + "|" + DIGITO + ")*)";
        EXPONENCIAL = "(E(\\+|-)" + DIGITOS + ")?";
        REAL = "(\\-?" + DIGITOS + "\\.?" + DIGITOS + EXPONENCIAL + ")";
        INTEIRO = "(\\-?" + DIGITOS + ")";
        NUMEROS = "(" + INTEIRO + "|" + REAL + ")";
        PARAMETRO = "(" + IDENT + "|" + NUMEROS + ")";

        OPERADOR = "(<|>|<=|>=|==|!=)";
        OPERADOR_ARITMETICO = "(\\+|\\-|\\*|/)";

        ATRIBUTO = "(" + IDENT + "(\\." + IDENT + ")*)";

        INDEXACAO = IDENT + "\\[" + BRANCOS + DIGITOS + BRANCOS + "\\]";
        CHAMADA_METODO = IDENT + "\\(" + BRANCOS + "(" + PARAMETRO + "(" + BRANCOS + "," + BRANCOS + PARAMETRO + ")*)?" + BRANCOS + "\\)";

        EXPRESSAO = PARAMETRO +
                "(" + BRANCOS + OPERADOR_ARITMETICO + BRANCOS +
                PARAMETRO + ")*";

        CONDICIONAL = BRANCOS + "if" + BRANCOS + "\\(" + BRANCOS
                + EXPRESSAO + BRANCOS
                + OPERADOR + BRANCOS
                + EXPRESSAO + BRANCOS + "\\)" + BRANCOS;

        ATRIBUICAO = IDENT + BRANCOS + "=" + BRANCOS + REAL;
        ASSINATURA_FUNCAO = "[A-Za-z-_]+";

        EXPRESSAO_ARITMETICA = "(" +
                "(-?" + DIGITOS + "|" + IDENT + "|" + INDEXACAO + "|" + CHAMADA_METODO + "|" + ATRIBUTO + ")" +
                "(" + BRANCOS + OPERADOR_ARITMETICO + BRANCOS +
                "(-?" + DIGITOS + "|" + IDENT + "|" + INDEXACAO + "|" + CHAMADA_METODO + "|" + ATRIBUTO + "))*" +
                ")";
    }

    public void confere(String exp, String sentenca) {
        if ((sentenca != null) && !sentenca.isEmpty()) {
            if (sentenca.matches(exp)) {
                System.out.println("W:'" + sentenca + "'........ ACEITA!");
            } else {
                System.err.println("W:'" + sentenca + "'........ rejeitada.");
            }
        } else {
            System.err.println("Sentença vazia.");
        }
    }
}