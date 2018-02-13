// PUSH CONSTANT 17
@17
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 17
@17
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// EQ
@SP
AM=M-1	// SP--
D=M	// D = *SP
@SP
AM=M-1	// SP--
D=D-M	// D = D - *SP
@IGUAL0
D;JEQ	// Si d = 0, entonces los números eran iguales, goto IGUAL
@SP	// Si no, eran diferentes, escribimos FALSE (0)
A=M
M=0	// *SP = FALSE (0)
@FIN0
0;JMP	// GOTO FIN
(IGUAL0)
@SP
A=M
M=-1	// *SP = TRUE (-1)
(FIN0)
@SP
M=M+1	// SP++
// PUSH CONSTANT 17
@17
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 16
@16
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// EQ
@SP
AM=M-1	// SP--
D=M	// D = *SP
@SP
AM=M-1	// SP--
D=D-M	// D = D - *SP
@IGUAL1
D;JEQ	// Si d = 0, entonces los números eran iguales, goto IGUAL
@SP	// Si no, eran diferentes, escribimos FALSE (0)
A=M
M=0	// *SP = FALSE (0)
@FIN1
0;JMP	// GOTO FIN
(IGUAL1)
@SP
A=M
M=-1	// *SP = TRUE (-1)
(FIN1)
@SP
M=M+1	// SP++
// PUSH CONSTANT 16
@16
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 17
@17
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// EQ
@SP
AM=M-1	// SP--
D=M	// D = *SP
@SP
AM=M-1	// SP--
D=D-M	// D = D - *SP
@IGUAL2
D;JEQ	// Si d = 0, entonces los números eran iguales, goto IGUAL
@SP	// Si no, eran diferentes, escribimos FALSE (0)
A=M
M=0	// *SP = FALSE (0)
@FIN2
0;JMP	// GOTO FIN
(IGUAL2)
@SP
A=M
M=-1	// *SP = TRUE (-1)
(FIN2)
@SP
M=M+1	// SP++
// PUSH CONSTANT 892
@892
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 891
@891
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// LT
@SP
M=M-1
AM=M-1	// SP-2
D=M	// D = *SP = x
@SP
AM=M+1	// SP++
D=D-M	//  D = D - *SP = x - y
@MENOR0
D;JLT	// Si d < 0 entonces x < y, goto MENOR
@SP	// Si no, escribimos FALSE (0)
AM=M-1	// SP--
M=0	// *SP = FALSE (0)
@FIN3
0;JMP	// GOTO FIN
(MENOR0)
@SP
AM=M-1	// SP--
M=-1	// *SP = TRUE (-1)
(FIN3)
@SP
M=M+1	// SP++
// PUSH CONSTANT 891
@891
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 892
@892
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// LT
@SP
M=M-1
AM=M-1	// SP-2
D=M	// D = *SP = x
@SP
AM=M+1	// SP++
D=D-M	//  D = D - *SP = x - y
@MENOR1
D;JLT	// Si d < 0 entonces x < y, goto MENOR
@SP	// Si no, escribimos FALSE (0)
AM=M-1	// SP--
M=0	// *SP = FALSE (0)
@FIN4
0;JMP	// GOTO FIN
(MENOR1)
@SP
AM=M-1	// SP--
M=-1	// *SP = TRUE (-1)
(FIN4)
@SP
M=M+1	// SP++
// PUSH CONSTANT 891
@891
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 891
@891
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// LT
@SP
M=M-1
AM=M-1	// SP-2
D=M	// D = *SP = x
@SP
AM=M+1	// SP++
D=D-M	//  D = D - *SP = x - y
@MENOR2
D;JLT	// Si d < 0 entonces x < y, goto MENOR
@SP	// Si no, escribimos FALSE (0)
AM=M-1	// SP--
M=0	// *SP = FALSE (0)
@FIN5
0;JMP	// GOTO FIN
(MENOR2)
@SP
AM=M-1	// SP--
M=-1	// *SP = TRUE (-1)
(FIN5)
@SP
M=M+1	// SP++
// PUSH CONSTANT 32767
@32767
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 32766
@32766
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// GT
@SP
M=M-1
AM=M-1	// SP-2
D=M	// D = *SP = x
@SP
AM=M+1	// SP++
D=D-M	//  D = D - *SP = x - y
@MAYOR0
D;JGT	// Si d > 0 entonces x > y, goto MAYOR
@SP	// Si no, escribimos FALSE (0)
AM=M-1	// SP--
M=0	// *SP = FALSE (0)
@FIN6
0;JMP	// GOTO FIN
(MAYOR0)
@SP
AM=M-1	// SP--
M=-1	// *SP = TRUE (-1)
(FIN6)
@SP
M=M+1	// SP++
// PUSH CONSTANT 32766
@32766
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 32767
@32767
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// GT
@SP
M=M-1
AM=M-1	// SP-2
D=M	// D = *SP = x
@SP
AM=M+1	// SP++
D=D-M	//  D = D - *SP = x - y
@MAYOR1
D;JGT	// Si d > 0 entonces x > y, goto MAYOR
@SP	// Si no, escribimos FALSE (0)
AM=M-1	// SP--
M=0	// *SP = FALSE (0)
@FIN7
0;JMP	// GOTO FIN
(MAYOR1)
@SP
AM=M-1	// SP--
M=-1	// *SP = TRUE (-1)
(FIN7)
@SP
M=M+1	// SP++
// PUSH CONSTANT 32766
@32766
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 32766
@32766
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// GT
@SP
M=M-1
AM=M-1	// SP-2
D=M	// D = *SP = x
@SP
AM=M+1	// SP++
D=D-M	//  D = D - *SP = x - y
@MAYOR2
D;JGT	// Si d > 0 entonces x > y, goto MAYOR
@SP	// Si no, escribimos FALSE (0)
AM=M-1	// SP--
M=0	// *SP = FALSE (0)
@FIN8
0;JMP	// GOTO FIN
(MAYOR2)
@SP
AM=M-1	// SP--
M=-1	// *SP = TRUE (-1)
(FIN8)
@SP
M=M+1	// SP++
// PUSH CONSTANT 57
@57
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 31
@31
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// PUSH CONSTANT 53
@53
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
// PUSH CONSTANT 112
@112
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
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
// NEG
@SP
AM=M-1	// SP--
M=-M	// *SP = -*SP
@SP
M=M+1	// SP++
// AND
@SP
AM=M-1	//SP--
D=M	// D = *SP = y
@SP
AM=M-1	//SP--
D=D&M	// D = D & *SP = y & x
@SP
A=M
M=D	// *SP = D
@SP
M=M+1	// SP++
// PUSH CONSTANT 82
@82
D=A	// D = lo que se haya pasado
@SP
A=M
M=D	// *SP = lo que se haya pasado
@SP
M=M+1	// SP++
// OR
@SP
AM=M-1	//SP--
D=M	// D = *SP = y
@SP
AM=M-1	//SP--
D=D|M	// D = D | *SP = y | x
@SP
A=M
M=D	// *SP = D
@SP
M=M+1	// SP++
// NOT
@SP
AM=M-1	// SP--
M=!M	// *SP = !*SP
@SP
M=M+1	// SP++
