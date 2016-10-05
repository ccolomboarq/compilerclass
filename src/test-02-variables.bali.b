.source Test.j
.class  public Test
.super  java/lang/Object

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V


		ldc 2
		istore 1
	getstatic java/lang/System/out Ljava/io/PrintStream;
		iload 1
		ldc 5
		imul
	invokevirtual java/io/PrintStream/println(I)V

		iload 1
		ldc 2
		idiv
		istore 2
	getstatic java/lang/System/out Ljava/io/PrintStream;
		ldc 4
		iload 1
		ldc 3
		iload 2
		isub
		imul
		iadd
	invokevirtual java/io/PrintStream/println(I)V

	return

.limit stack 5
.limit locals 3
.end method

; symbols: [args, x, y]
