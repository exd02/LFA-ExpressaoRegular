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
    public String TIPO;
    public String PARAMETRO;
    public String PARAMETROS_FUNCAO;
    public String DECLARACAO;
    public String ASSINATURA_FUNCAO;
    public String OPERADOR_ARITMETICO;
    public String EXPRESSAO;
    public String EXPRESSAO_ARITMETICA;
    public String ATRIBUTO;
    public String INDEXACAO;
    public String CHAMADA_METODO;
    public String LFA13_EX2;
    public String LFA13_EX3;

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
        LETRAS = LETRA + "+";

        IDENT = "(" + LETRA + "(" + LETRA + "|" + DIGITO + ")*)";
        EXPONENCIAL = "(E(\\+|-)" + DIGITOS + ")?";
        REAL = "(\\-?" + DIGITOS + "\\.?" + DIGITOS + EXPONENCIAL + ")";
        INTEIRO = "(\\-?" + DIGITOS + ")";
        NUMEROS = "(" + INTEIRO + "|" + REAL + ")";
        PARAMETRO = "(" + IDENT + "|" + NUMEROS + ")";

        TIPO = "(void|int|float|double|char|boolean|long|short|byte|String)";
        DECLARACAO = TIPO + BRANCOS_MIN1 + IDENT;

        PARAMETROS_FUNCAO =
                BRANCOS + "\\("                                     // (
                    + BRANCOS + DECLARACAO + BRANCOS +              // int i
                    "(," + BRANCOS + DECLARACAO + BRANCOS + ")*" +  // , int x
                "\\)" + BRANCOS;                                    // );

        ASSINATURA_FUNCAO = BRANCOS + DECLARACAO + BRANCOS + PARAMETROS_FUNCAO + BRANCOS + ";";

        OPERADOR = "(<|>|<=|>=|==|!=)";
        OPERADOR_ARITMETICO = "(\\+|\\-|\\*|/)";

        EXPRESSAO = PARAMETRO +
                "(" + BRANCOS + OPERADOR_ARITMETICO + BRANCOS +
                PARAMETRO + ")*";

        CONDICIONAL = BRANCOS + "if" + BRANCOS + "\\(" + BRANCOS
                + EXPRESSAO + BRANCOS
                + OPERADOR + BRANCOS
                + EXPRESSAO + BRANCOS + "\\)" + BRANCOS;

        ATRIBUICAO = IDENT + BRANCOS + "=" + BRANCOS + REAL;

        ATRIBUTO = "(" + IDENT + "(\\." + IDENT + ")*)";
        INDEXACAO = IDENT + "\\[" + BRANCOS + DIGITOS + BRANCOS + "\\]";
        CHAMADA_METODO = IDENT + "\\(" + BRANCOS + "(" + PARAMETRO + "(" + BRANCOS + "," + BRANCOS + PARAMETRO + ")*)?" + BRANCOS + "\\)";

        EXPRESSAO_ARITMETICA = "(" +
                "(-?" + DIGITOS + "|" + IDENT + "|" + INDEXACAO + "|" + CHAMADA_METODO + "|" + ATRIBUTO + ")" +
                "(" + BRANCOS + OPERADOR_ARITMETICO + BRANCOS +
                "(-?" + DIGITOS + "|" + IDENT + "|" + INDEXACAO + "|" + CHAMADA_METODO + "|" + ATRIBUTO + "))*" +
                ")";

        LFA13_EX2 = "^a[a-zA-Z]*a$";
        LFA13_EX3 = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
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