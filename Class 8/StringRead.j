.source StringRead.j
.class  public StringRead
.super  java/lang/Object

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V

    invokestatic Runtime/readString()Ljava/lang/String;
    astore 1

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload  1 ; coloca na pilha o valor da variável #1
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    
    return
    
    .limit stack  2
    .limit locals 2
.end method

