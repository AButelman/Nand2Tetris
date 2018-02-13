// PUSH CONSTANT 7
@7
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 8
@8
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
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
