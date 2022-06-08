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
    
Cada una de las clases fue documentada, espero no haberme pasado ninguna por alto. Cada método fue testeado con casos borde y de consistencia. 