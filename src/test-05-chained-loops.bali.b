.source Test.j
.class  public Test
.super  java/lang/Object

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V


		ldc 0
		istore 1
		ldc 0
		istore 2
BEGIN_WHILE_1:
		iload 2
		ldc 100
if_icmpge END_WHILE_1 ;
		ldc 1
		istore 3
BEGIN_WHILE_2:
		iload 3
		ldc 100
if_icmpge END_WHILE_2 ;
		iload 1
		iload 3
		iadd
		istore 1
		iload 3
		ldc 1
		iadd
		istore 3
		goto BEGIN_WHILE_2 ;
END_WHILE_2:
		ldc 100
		istore 4
BEGIN_WHILE_3:
		iload 4
		ldc 0
if_icmple END_WHILE_3 ;
		iload 1
		iload 4
		iadd
		istore 1
		iload 4
		ldc 1
		isub
		istore 4
		goto BEGIN_WHILE_3 ;
END_WHILE_3:
		iload 2
		ldc 1
		iadd
		istore 2
		goto BEGIN_WHILE_1 ;
END_WHILE_1:
	getstatic java/lang/System/out Ljava/io/PrintStream;
		iload 1
	invokevirtual java/io/PrintStream/println(I)V

	return

.limit stack 2
.limit locals 5
.end method

; symbols: [args, total, x, y, z]
