.source Test.j
.class  public Test
.super  java/lang/Object

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V


		ldc 1
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
		ldc 500
		ldc 10
		idiv
		imul
		ldc 3
		ldc 1000
		ldc 1000
		imul
		ldc 1000
		imul
		imul
		irem
		ldc 1000
		imul
		iadd
	invokevirtual java/io/PrintStream/println(I)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
		ldc 2
		ldc 9
		ldc 500
		ldc 8
		idiv
		imul
		ldc 3
		ldc 1000
		ldc 1000
		imul
		ldc 1000
		imul
		imul
		irem
		ldc 1000
		imul
		iadd
	invokevirtual java/io/PrintStream/println(I)V

	return

.limit stack 7
.end method

