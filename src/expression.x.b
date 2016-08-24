.source Test.j
.class  public Test
.super  java/lang/Object

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V


	getstatic java/lang/System/out Ljava/io/PrintStream;

		ldc 1
		ldc 2
		iadd
		ldc 3
		ldc 1000
		imul
		ldc 5
		idiv
		iadd
	invokevirtual java/io/PrintStream/println(I)V


	getstatic java/lang/System/out Ljava/io/PrintStream;

		ldc 13
		ldc 4
		irem
	invokevirtual java/io/PrintStream/println(I)V


	getstatic java/lang/System/out Ljava/io/PrintStream;

		ldc 2
		ldc 9
		iadd
		ldc 1000
		imul
	invokevirtual java/io/PrintStream/println(I)V


	; finaliza o metodo
	return

; indica que no maximo tres itens podem ser colocados na pilha
.limit stack 10
.end method

