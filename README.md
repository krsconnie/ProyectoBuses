# ProyectoBuses: Proyecto del ramo de Programación II
Consiste en hacer un sistema de reserva de asientos de buses.


Integrantes:

-Matias Alonso Muñoz Sotomayor @Matatatatatata

-Constanza Fabiola Cristinich Ananias @krsconnie

Especificaciones del proyecto:

>>1)El sistema permite al personal de una empresa de autobuses elegir y reservar
asientos de forma conveniente por su cliente.

>>2)Los usuarios pueden visualizar una representación gráfica de los asientos
disponibles en el bus y seleccionar los que deseen ocupar.

>>3)El sistema muestra la información detallada sobre cada asiento, como ubicación,
número y categoría.

>>4)Una vez que los susarios seleccionan los asientos deseados, se verifica la 
disponibilidad y permite confirmar la reserva mostrando el precio a pagar. 
**En caso de algún asiento ya esté reservado por otro pasajero, se informa al 
usuario para que pueda elegir otro asiento disponible.** 

>>5)El personal debe confirmar el pago (no lo gestiona el sistema) lo que reserva 
los asientos.

>>6)El sistema gestiona varios tipos de buses (1 o 2 pisos, categorias, etc).

>>7)El sistema cuenta con un menú que permite seleccionar el autobus en función
de su horario y recorrido.


Patrones de Diseño usados:
>>State: El patrón de diseño State ayuda a un objeto a comportarse de diferentes maneras según su estado actual.
Se usa en el Objeto Asiento, para definir cuando esta disponible o reservado, dependiendo de eso se comportará de una manera distinta.

Interfaz:
![image](https://github.com/krsconnie/ProyectoBuses/assets/109244120/e10e9438-7151-462b-b016-9dd3b4723f09)

