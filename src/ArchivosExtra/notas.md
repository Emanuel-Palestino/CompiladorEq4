# IMPORTANTE

Todo el programa se ejecuta desde la Clase Main que se encuentra en el paquete Main


# Crear Expresiónes Regulares Validas

## Nota
La expresión regular se debe escribir con espacios entre cada operador y palabra o simbolo del alfabeto
Así mismo, el alfabeto se debe escribir con espacios entre cada simbolo o palabra

## Simbolos validos para crear una expresión regular
- ┌: se usa para representar un parentesis que abre
- ┐: se usa para representar un parentesis que cierra
- ×: se usa para representar una cerradura de Klenee
- º: se usa para representar una cerradura opcional
- ß: se usa para representar una cerradura positiva
- ┼: se usa para representar una concatenación
- ı: se usa para representar una union

## Simbolos utilizados en los automatas
- Ɛ: se usa para representar epsilon

## Palabras que se pueden utilizar como alfabeto
- letra: para representar cualquier letra del alfabeto mayuscula o minuscula
- digito: para representar cualquier digito


# GRAMATICAS
Para crear una gramática válida se deben separar todos los simbolos gramaticales con espacios.

Se usa el simbolo » para representar una flecha en las reglas de producción. Este símbolo puede estar o no separado por un espacio de los símbolos gramaticales.

Se sigue usando el simbolo Ɛ para representar epsilon.

## El orden correcto para escribir un archivo con una gramatica es el siguiente
- Primera Línea: Todos los símbolos no terminales.
- Segunda Línea: Todos los símbolos terminales.
- Tercera Línea: El símbolo inicial de la gramatica.
- Cuarta Línea: A partir de esta línea se escriben las regla de producción.

# ACCIONES SEMANTICAS

Las acciones semánticas se escriben en un archivo .txt
Cada acción semántica debe estar en una sóla línea
Cada simbolo de una acción semántica debe estar separado por un espacio
Las condiciones deben estar encerradas por {}
Las constantes cadena deben estar encerradas por ''
Para denotar una asignación se usa: :=
Para denotar una concatenación se usa: ||
Los operadores lógicos disponibles son: == y !=
Los atributos disponibles de los simbolos gramaticales son: traduccion, temporal y valorLexico


## Ejemplo 1:
{ if A.traduccion != '' A.traduccion := 'var' || B.temporal else A.traduccion := B.valorLexico } A.traduccion := A.traduccion || ';'

## Ejemplo 2:
A.traduccion := 'let' || B.temporal || A.temporal