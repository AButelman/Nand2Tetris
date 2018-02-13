// PUSH CONSTANT 3030
@3030
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// POP POINTER 0
@3
D=A	// D = 3
@0
D=D+A	// D = 3 + i
@R15
M=D	// addr = 3 + i
@SP
AM=M-1	// SP--
D=M	// D = pop
@R15
A=M
M=D	// *addr = *SP
// PUSH CONSTANT 3040
@3040
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// POP POINTER 1
@3
D=A	// D = 3
@1
D=D+A	// D = 3 + i
@R15
M=D	// addr = 3 + i
@SP
AM=M-1	// SP--
D=M	// D = pop
@R15
A=M
M=D	// *addr = *SP
// PUSH CONSTANT 32
@32
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// POP THIS 2
@THIS
D=M	// D = THIS
@2
D=D+A	// D = THIS 2
@R15
M=D	// addr = THIS 2
@SP
M=M-1	// SP--
A=M
D=M	// D = *SP
@R15
A=M
M=D	// addr = *SP
// PUSH CONSTANT 46
@46
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// POP THAT 6
@THAT
D=M	// D = THAT
@6
D=D+A	// D = THAT 6
@R15
M=D	// addr = THAT 6
@SP
M=M-1	// SP--
A=M
D=M	// D = *SP
@R15
A=M
M=D	// addr = *SP
// PUSH POINTER 0
@3
D=A	// D = 3
@0
A=D+A	// D = 3 + i
D=M	// D = *(3 + i)
@SP
A=M
M=D	// *SP = *(3 + i)
@SP
M=M+1	// SP++
// PUSH POINTER 1
@3
D=A	// D = 3
@1
A=D+A	// D = 3 + i
D=M	// D = *(3 + i)
@SP
A=M
M=D	// *SP = *(3 + i)
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
// PUSH THIS 2
@THIS
D=M	// D = THIS
@2
D=D+A	// D = THIS + 2
A=D
D=M	// D = *(THIS + 2)
@SP
A=M
M=D	// *SP = *addr
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
// PUSH THAT 6
@THAT
D=M	// D = THAT
@6
D=D+A	// D = THAT + 6
A=D
D=M	// D = *(THAT + 6)
@SP
A=M
M=D	// *SP = *addr
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
