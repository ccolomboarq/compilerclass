.source StringVar.j
.class  public StringVar
.super  java/lang/Object

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V

    ldc    "abc" ; carrega string constante na pilha
    astore 1     ; armazena o topo da pilha na vari�vel #1

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload  1 ; coloca na pilha o valor da vari�vel #1
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    invokestatic Runtime/readString()Ljava/lang/String; ; deixa a string lida na pilha
    astore 2 ; armazena o topo da pilha na vari�vel #2
    
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload  2 ; coloca na pilha o valor da vari�vel #2
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
  
    return    
    
    .limit stack  2 ; n�mero m�ximo da altura que a pilha atinge 
    .limit locals 3 ; n�mero de par�metros e vari�veis locais 
.end method
