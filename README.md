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

Diagrama Casos de Uso:
![Diagrama_casos_de_uso](https://github.com/krsconnie/ProyectoBuses/assets/109244120/dc03fe0f-12b6-497d-85d9-1e02f29d12cd)


Interfaz:
![image](https://github.com/krsconnie/ProyectoBuses/assets/109244120/e10e9438-7151-462b-b016-9dd3b4723f09)

Cambios realizados:
>>1) Actualización del diagrama UML, ofreciendo una posible solución/futura implementación de la clase CancelarReserva.

>>2) Creación del diseño de VentanaReservarAsiento, requiere ajustes la visualización del ArrayList

>>3) Creación e implementación de la nueva clase visual VentanaSeleccionarAsiento, asientos representados y dispuestos.

>>4) En Ventana Principal se agregaron distintas ventanas y se inicializaron junto a la llamada del constructor para que estén pre-existentes pero invisibles hasta que su uso sea necesario. Esto facilita el traspaso de información entre ventanas.

>>5) Enum Recorrido: Se modificó la Enum para evitar el error "No enum constant org.example.Bus.Recorrido.LosAngeles_Concepcion".

>>6) En VentanaReservarAsiento y VentanaCancelarReserva se agregaron métodos para el traspaso de los ArrayList modificados entre las ventanas.

>>7) En SistemaReservas se agregó el método PagarPasaje() al sistema de reservas, se agregó el método CancelarPasaje() y se creó la excepción AsientoNoReservadoException para manejar situaciones cuando se intenta cancelar un asiento que no ha sido reservado.

>>8) En VentanaPrincipal y SistemaReservas se agregó la clase SistemaReservas a las ventanas ReservarAsiento y CancelarReserva para permitir su interacción con el sistema de reservas. También se implementó el traspaso de los ArrayList modificados entre las ventanas.

>>9)Se agregó la documentación faltante en el código.




