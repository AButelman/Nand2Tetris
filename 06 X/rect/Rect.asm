// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/06/rect/Rect.asm

// Draws a rectangle at the top-left corner of the screen.
// The rectangle is 16 pixels wide and R0 pixels high.
// Los comentarios los puse yo
   @0
   D=M			// D=RAM[0]
   @INFINITE_LOOP
   D;JLE 		// Si RAM[0]<=0 (no se puso nada, o negativo, el rectángulo no tendría altura), saltamos al final (INFINITE_LOOP)
   @counter
   M=D			// counter=RAM[0]
   @SCREEN
   D=A			// D=dirección del primer pixel de la pantalla
   @address
   M=D			// address=dirección del primer pixel de la pantalla (va a ser utilizado como puntero)
(LOOP)
   @address
   A=M			// A (posicionamos el cursor de escritura) = address = en la dirección de pantalla del puntero
   M=-1			// Escribimos -1 (1111111111111111) en la word de la posición de escritura actual
   @address
   D=M			// D = puntero de pantalla
   @32
   D=D+A		// D = puntero de pantalla + 32 = puntero de pantalla en la siguiente fila
   @address
   M=D			// address = D = puntero de pantalla en la siguiente fila
   @counter
   MD=M-1		// counter = counter-1 , D = counter-1
   @LOOP
   D;JGT		// Si counter (D) es mayor que 0, todavía no escribimos la cantidad de líneas pedidas, loopeamos
(INFINITE_LOOP)
   @INFINITE_LOOP
   0;JMP		// Loop infinito, final
