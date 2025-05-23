
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.start();
    }
}

/*
En esta kata sencilla, tu tarea es recrear una máquina expendedora.
Tendrás que crear una clase llamada VendingMachine con al menos un método llamado vend.
Al crear una nueva instancia de VendingMachine, se le pasan dos cosas: un array de artículos y la cantidad inicial de dinero en la máquina.
El método vend debe recibir dos argumentos:
El código de selección del artículo (no distingue entre mayúsculas y minúsculas), y
La cantidad de dinero que el usuario introduce en la máquina.

Reglas
Si el dinero introducido es menor que el precio del artículo, devuelve:
"¡Dinero insuficiente!"

Si la cantidad disponible de un artículo es 0, devuelve:
"Nombre del artículo: ¡Agotado!"
(donde "Nombre del artículo" es el nombre real del producto seleccionado)

Si el artículo se selecciona correctamente y hay cambio, devuelve:
"Entregando Nombre del artículo con 9.40 de cambio."
(reemplazando "Nombre del artículo" y "9.40" según corresponda)

Si el artículo se selecciona correctamente y no hay cambio, devuelve:
"Entregando Nombre del artículo"

Si se selecciona un artículo inválido (código no existente), devuelve:
"¡Selección inválida! : Dinero en la máquina = 11.20"
(donde "11.20" es el dinero actual en la máquina)

Si una selección es exitosa, se debe actualizar la cantidad disponible de ese artículo.

La máquina nunca se queda sin dinero (por simplicidad), pero deberás llevar un control interno del dinero total en la máquina (esto no se prueba en los test).

El cambio siempre se da con 2 decimales, por ejemplo: 7.00
 */