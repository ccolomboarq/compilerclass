.source Test.j
.class  public Test
.super  java/lang/Object

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

.method public static main([Ljava/lang/String;)V


	invokestatic Runtime/readInt()I ;
		istore 1
	invokestatic Runtime/readInt()I ;
		istore 2
	getstatic java/lang/System/out Ljava/io/PrintStream;
		iload 1
		iload 2
		iadd
	invokevirtual java/io/PrintStream/println(I)V

	return

.limit stack 3
.limit locals 3
.end method

; symbols: [args, a, b]
