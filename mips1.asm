	.data
newline: 	.asciiz "\n"
	.text 
sub	$t0, $t0, 88
addi	$t1, $zero, -88
sub	$t2, $zero, -88
li	$v0, 1
la 	$a0, ($t0)
syscall 

n:
li 	$v0, 4
la	$a0, newline
syscall 

li 	$v0, 1
la 	$a0, ($t1)
syscall 
la	$t1, ($t2)
j	n