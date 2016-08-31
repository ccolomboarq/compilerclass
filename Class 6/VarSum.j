.source VarSum.j
.class  public VarSum
.super  java/lang/Object

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V

    ldc    2   ; carrega valor 2 na pilha
    istore 1   ; armazena o topo da pilha na variavel #1 (#0 e o parametro String[] args)

    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload  1   ; coloca na pilha o valor da variavel #1
    ldc    4   ; carrega valor 4 na pilha
    iadd       ; soma os dois valores e empilha o resultado
    invokevirtual java/io/PrintStream/println(I)V

    return
.limit stack  3 ; numero maximo da altura que a pilha atinge
.limit locals 2 ; numero de parametros e variaveis locais
.end method
