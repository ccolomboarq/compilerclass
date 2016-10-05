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
		ldc 0
	invokevirtual java/io/PrintStream/println(I)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
		ldc 123
	invokevirtual java/io/PrintStream/println(I)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
		ldc 45
		ldc 6
		irem
	invokevirtual java/io/PrintStream/println(I)V

	return

.limit stack 3
.limit locals 1
.end method

; symbols: [args]
