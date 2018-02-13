// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.

// Put your code here.

// brocha = RAM[0]

(PRINCIPIO)
	@i
	M=0	// i=0, reiniciamos el contador

(LOOP)
	@i
	D=M	// D = i

	@8193	// Final de la pantalla
	D=D-A;	// D = i - Final de la pantalla
	@PRINCIPIO
	D;JEQ	// Si i - Final de la pantalla = 0, entonces la brocha llegó al final de la pantalla, reseteamos
	
	@i
	D=M	// D = i

	@SCREEN
	D=A+D	// D = SCREEN + i = principio de la pantalla + offset = posición de la brocha
	
	@R0
	M=D	// RAM[0] = posición de la brocha

	@KBD	// Chequeamos el teclado
	D=M;	// D=teclado
	@PINTARNEGRO
	D;JNE	// Si se apretó una tecla, pintamos de negro (saltamos), si no, de blanco (seguimos)

(PINTARBLANCO)
	@R0	// RAM[0] = posición de la brocha
	A=M	// Posicionamos la brocha
	M=0	// Pintamos de blanco
	@SEGUIR
	0;JMP	// Saltamos para no pintar de negro

(PINTARNEGRO)
	@R0	// RAM[0] = posición de la brocha
	A=M	// Posicionamos la brocha
	M=-1	// Pintamos de negro

(SEGUIR)
	@i
	M=M+1	// i++

	@LOOP
	0;JMP	// Seguimos pintando
