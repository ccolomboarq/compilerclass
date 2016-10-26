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
		istore 1
BEGIN_WHILE_1:
		iload 1
		ldc 5
if_icmpgt END_WHILE_1 ;
	getstatic java/lang/System/out Ljava/io/PrintStream;
		iload 1
	invokevirtual java/io/PrintStream/println(I)V

		iload 1
		ldc 1
		iadd
		istore 1
		ldc 0
		istore 2
BEGIN_WHILE_2:
		iload 2
		ldc 2
if_icmpgt END_WHILE_2 ;
	getstatic java/lang/System/out Ljava/io/PrintStream;
		ldc "OK"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

		iload 2
		ldc 1
		iadd
		istore 2
		ldc 0
		istore 3
BEGIN_WHILE_3:
		iload 3
		ldc 2
if_icmpge END_WHILE_3 ;
	getstatic java/lang/System/out Ljava/io/PrintStream;
		ldc "NOT OK"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

		iload 3
		ldc 1
		iadd
		istore 3
		goto BEGIN_WHILE_3 ;
END_WHILE_3:
		goto BEGIN_WHILE_2 ;
END_WHILE_2:
		goto BEGIN_WHILE_1 ;
END_WHILE_1:
BEGIN_WHILE_4:
		iload 1
		ldc 10
if_icmpge END_WHILE_4 ;
		iload 1
		ldc 1
		iadd
		istore 1
	getstatic java/lang/System/out Ljava/io/PrintStream;
		ldc "Test"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

		goto BEGIN_WHILE_4 ;
END_WHILE_4:
	return

.limit stack 2
.limit locals 4
.end method

; symbols: [args, a, b, c]
