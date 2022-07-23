<!-- 1.0.3-b1 -->
# 99.7% Citric Liquid

Base code for CC3002's *99.7% Citric Juice* Project.

The project consists in creating a (simplified) clone of the game **100% Orange Juice**
developed by [Orange_Juice](http://daidai.moo.jp) and distributed by 
[Fruitbat Factory](https://fruitbatfactory.com).
-----------
Se implementó el esqueleto del modelo del proyecto con las siguientes clases:
* Se creó la interfase IFighter, la cual representa a los personajes que pueden estar
 en una batalla. Estos son los principales (Player), enemigos salvajes(WildUnit) y jefes (BossUnit).
  
La justificación de esta interfase y clase Fighter es puesto que ambos personajes ( Player y Enemigos)
tienen comportamientos parecidos, sobretodo al momento de una batalla. Pueden ambos obtener
estrellas, lanzar dados o perder vida. Es por eso que asumí una buena práctica de programación
esta jerarquía, imaginando que se pueden utilizar como un mismo tipo mas adelante en el controlador 
con las batallas.

La clase Player tiene sus propios métodos que no pueden utilizar los enemigos, como por
ejemplo el conteo de victorias en batallas.

Fue creada la estructura jerárquica de los enemigos a pesar de no tener métodos distintos a los de Player, esto pues
es claro que es una buena práctica para la extensibilidad del código, sobretodo en el momento de las interacciones con otros
personajes, teniendo ataques especiales que otros no tienen, o teniendo una debilidad ante algún personaje específico por ejemplo. Cada uno
de los tipos de enemigos fue creado con su respectiva clase e inicializado con sus estadísticas particulares en sus constructores.

Se implementó el esqueleto del tablero del proyecto con las siguientes clases:
* Se creó la interfase IPanels, la cual representa a todos los tipos de paneles que se pueden encontrar, esto para instanciarlos a todos en la clase
AbstractPanel al momento de guardar los paneles siguientes al panel actual, que pueden ser de cualquier tipo de ellos. La case es abstracta puesto que posee el método ***activate***
  que se implementa de manera distinta en cada uno de los paneles que extienden de esta:
  * Para los paneles ***Home, Bonus, Drop*** este método genera los efectos específicos que tiene cada panel al momento de finalizar el turno (norma check, sumer o quitar estrellas).
  * Para los paneles ***Boss, Draw, Encounter, Neutral*** este método solo printea lo que sucedería, puesto que aún no ha sido implementado. Para algunos se adelantaron métodos que servirán en el futuro.
    
-------------- 
Cambios en tarea 2:

(pre-entrega 1)

Se crearon los estados del juego lo mas atómicos posibles, tomando en cuenta cada uno de los eventos que pueden suceder en un turno de un jugador, inclusive si no está en su propio turno y le toca batallar con otro jugador

Los estados fueron implementados con base al state pattern, y los cambios de estados fueron controlador con excepciones para cambios no permitidos

(pre-entrega 2)

El controlador del juego fue implementado con los métodos básicos pedidos en esta entrega:

* Crear paneles
* Crear jugadores, wild units y boss units. En el caso de los jugadores, también debe ser capaz de ubicarlos en algún panel.
*  Asignarle a cada panel uno o más paneles siguientes.
*  Obtener todos los paneles del tablero.
*  Saber cuando un jugador gana llegando a la norma máxima
*  Definir el objetivo para aumentar de norma para un jugador (estrellas o victorias)
*  Definir el home panel de un jugador
*  Obtener el capítulo actual del juego
*  Obtener el jugador que es dueño del turno
*  Terminar el turno del jugador actual
*  Realizar un norma check y norma clear cuando un jugador cae en un home panel
*  Detener el movimiento de un jugador si este:
    * Pasa por su home panel
    * Pasa por un panel en el que haya otro jugador
    * Cae en un panel que tiene más de un panel siguiente
    
En específico esta parte fue implementada con Handlers que desencadenaban acciones al ocurrir estos casos especificos para trabajarlos correctamente.

Lamentablemente no me alcanzó el tiempo para tener todos los test necesarios.

