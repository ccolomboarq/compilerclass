.source Test.j
.class  public Test
.super  java/lang/Object


.method public static cubo()V
		ldc 4
		istore 0
	getstatic java/lang/System/out Ljava/io/PrintStream;
		iload 0
		iload 0
		imul
		iload 0
		imul
	invokevirtual java/io/PrintStream/println(I)V

	return

.limit stack 3
.limit locals 1
.end method

.method public static quadrado()V
		ldc 4
		istore 0
	getstatic java/lang/System/out Ljava/io/PrintStream;
		iload 0
		iload 0
		imul
	invokevirtual java/io/PrintStream/println(I)V

	return

.limit stack 3
.limit locals 1
.end method

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V


		ldc 1
		istore 1
		invokestatic Test/cubo()V
		invokestatic Test/quadrado()V
	getstatic java/lang/System/out Ljava/io/PrintStream;
		iload 1
	invokevirtual java/io/PrintStream/println(I)V

	return

.limit stack 2
.limit locals 2
.end method

; symbols: [args, n]
