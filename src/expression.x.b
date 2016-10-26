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
		ldc "Type a number:"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	invokestatic Runtime/readInt()I ;
		istore 1
		iload 1
		ldc 5
if_icmpge NOT_IF_1 ;
	getstatic java/lang/System/out Ljava/io/PrintStream;
		ldc "The variable a is lesser than 5"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

		goto END_ELSE_1 ;
NOT_IF_1:
		iload 1
		ldc 5
if_icmpne NOT_IF_2 ;
	getstatic java/lang/System/out Ljava/io/PrintStream;
		ldc "The variable is equal to 5"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

		goto END_ELSE_2 ;
NOT_IF_2:
	getstatic java/lang/System/out Ljava/io/PrintStream;
		ldc "The variable is greater than 5"
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

END_ELSE_2:
END_ELSE_1:
	getstatic java/lang/System/out Ljava/io/PrintStream;
		ldc "End of program."
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	return

.limit stack 2
.limit locals 2
.end method

; symbols: [args, a]
