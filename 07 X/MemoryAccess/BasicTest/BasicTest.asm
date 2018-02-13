// PUSH CONSTANT 10
@10
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// POP LCL 0
@LCL
D=M	// D = LCL
@0
D=D+A	// D = LCL 0
@R15
M=D	// addr = LCL 0
@SP
M=M-1	// SP--
A=M
D=M	// D = *SP
@R15
A=M
M=D	// addr = *SP
// PUSH CONSTANT 21
@21
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 22
@22
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// POP ARG 2
@ARG
D=M	// D = ARG
@2
D=D+A	// D = ARG 2
@R15
M=D	// addr = ARG 2
@SP
M=M-1	// SP--
A=M
D=M	// D = *SP
@R15
A=M
M=D	// addr = *SP
// POP ARG 1
@ARG
D=M	// D = ARG
@1
D=D+A	// D = ARG 1
@R15
M=D	// addr = ARG 1
@SP
M=M-1	// SP--
A=M
D=M	// D = *SP
@R15
A=M
M=D	// addr = *SP
// PUSH CONSTANT 36
@36
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// POP THIS 6
@THIS
D=M	// D = THIS
@6
D=D+A	// D = THIS 6
@R15
M=D	// addr = THIS 6
@SP
M=M-1	// SP--
A=M
D=M	// D = *SP
@R15
A=M
M=D	// addr = *SP
// PUSH CONSTANT 42
@42
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 45
@45
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// POP THAT 5
@THAT
D=M	// D = THAT
@5
D=D+A	// D = THAT 5
@R15
M=D	// addr = THAT 5
@SP
M=M-1	// SP--
A=M
D=M	// D = *SP
@R15
A=M
M=D	// addr = *SP
// POP THAT 2
@THAT
D=M	// D = THAT
@2
D=D+A	// D = THAT 2
@R15
M=D	// addr = THAT 2
@SP
M=M-1	// SP--
A=M
D=M	// D = *SP
@R15
A=M
M=D	// addr = *SP
// PUSH CONSTANT 510
@510
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// POP TEMP 6
@5
D=A	// D = 5
@6
D=D+A	// D = 5 + i
@R15
M=D	// addr = 5 + i
@SP
AM=M-1	// SP--
D=M	// D = pop
@R15
A=M
M=D	// *addr = *SP
// PUSH LCL 0
@LCL
D=M	// D = LCL
@0
D=D+A	// D = LCL + 0
A=D
D=M	// D = *(LCL + 0)
@SP
A=M
M=D	// *SP = *addr
@SP
M=M+1	// SP++
// PUSH THAT 5
@THAT
D=M	// D = THAT
@5
D=D+A	// D = THAT + 5
A=D
D=M	// D = *(THAT + 5)
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
// PUSH ARG 1
@ARG
D=M	// D = ARG
@1
D=D+A	// D = ARG + 1
A=D
D=M	// D = *(ARG + 1)
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
// PUSH THIS 6
@THIS
D=M	// D = THIS
@6
D=D+A	// D = THIS + 6
A=D
D=M	// D = *(THIS + 6)
@SP
A=M
M=D	// *SP = *addr
@SP
M=M+1	// SP++
// PUSH THIS 6
@THIS
D=M	// D = THIS
@6
D=D+A	// D = THIS + 6
A=D
D=M	// D = *(THIS + 6)
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
// PUSH TEMP 6
@5
D=A	// D = 5
@6
A=D+A	// D = 5 + i
D=M	// D = *(5 + i)
@SP
A=M
M=D	// *SP = *(5 + i)
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
