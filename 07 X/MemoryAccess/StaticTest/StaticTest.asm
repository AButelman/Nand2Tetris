// PUSH CONSTANT 111
@111
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 333
@333
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 888
@888
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// POP STATIC 8
@SP
M=M-1	// SP--
A=M
D=M	// D = *SP
@StaticTest.asm.8
M=D	// static i = *SP
// POP STATIC 3
@SP
M=M-1	// SP--
A=M
D=M	// D = *SP
@StaticTest.asm.3
M=D	// static i = *SP
// POP STATIC 1
@SP
M=M-1	// SP--
A=M
D=M	// D = *SP
@StaticTest.asm.1
M=D	// static i = *SP
// PUSH STATIC 3
@StaticTest.asm.3
D=M	// D = static i
@SP
A=M
M=D	// *SP = static i
@SP
M=M+1	// SP++
// PUSH STATIC 1
@StaticTest.asm.1
D=M	// D = static i
@SP
A=M
M=D	// *SP = static i
@SP
M=M+1	// SP++
// SUB
@SP
M=M-1
AM=M-1	// SP - 2
D=M	// D = *(SP - 2)
@SP
M=M+1	// SP + 1
A=M
D=D-M	// D = D - *SP
@SP
AM=M-1	// SP - 1
M=D	// *SP = D
@SP
M=M+1	// SP++
// PUSH STATIC 8
@StaticTest.asm.8
D=M	// D = static i
@SP
A=M
M=D	// *SP = static i
@SP
M=M+1	// SP++
// ADD
@SP
AM=M-1	//SP--
D=M	// D = *SP
@SP
AM=M-1	//SP--
D=D+M	// D = D + *SP
@SP
A=M
M=D	// *SP = D
@SP
M=M+1	// SP++
