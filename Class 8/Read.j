.source Read.j
.class  public Read
.super  java/lang/Object

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V

    invokestatic Runtime/readInt()I ; deixa o valor inteiro lido no topo da pilha
    istore 1   ; armazena o topo da pilha na variavel #1 (#0 e o parametro String[] args)

    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload  1 ; coloca na pilha o valor da variável #1
    invokevirtual java/io/PrintStream/println(I)V
    
    return
    
    .limit stack  2
    .limit locals 2
.end method
