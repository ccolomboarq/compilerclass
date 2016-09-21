.source StringPrint.j
.class  public StringPrint
.super  java/lang/Object

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc    "abc"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    return
.limit stack  2 ; numero maximo da altura que a pilha atinge
.limit locals 1 ; numero de parametros e variaveis locais
.end method









