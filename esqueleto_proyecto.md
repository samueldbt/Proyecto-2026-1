Cada horario puede verse como una lista de grafos no dirigidos, de manera que cada día tiene un grafo ponderado asignado.
Cada vértice es un grupo de clase y las aristas es la compatibilidad entre grupos distintos, por ejemplo dos grupos estaran conectados si no se chocan en sus horarios y pueden estar dentro de un mismo horario academico.
De manera que:
Lunes {(clase de 8:00am a 10:00pm) <--(peso:4)--> (clase de 2:00pm a 3:00pm) <--(peso:1)--> (clase de 4:00pm a 6:00pm}\
El peso esta calculado por el costo de combinar ambos grupos, considerando el tiempo entre ambas clases, preferencias del usuario, etc...

\----------------------------------------------------------------------------------------------------------------------------------

Cada materia tiene n grupos de clase (C7B, C7A... etc.) y cada grupo tiene clases en horas especificas (C7B tiene clase los lunes de 2pm a 4pm...).



&#x09;Las materias son listas de grupos de clase.\
&#x09;cada grupo de clase se declararía como una class grupoDeClase.\
&#x09;cada grupoDeClase tendría unas horas determinadas de clase en unos días determinados (El horario de clase de cada grupo es pre establecido).\
&#x09;cada grupoDeClase tendría un salón/es y edificio/s determinado/s.\
&#x09;cada grupoDeClase tendría un profesor/es determinado/s.

&#x09;

&#x20;

al formarse un horario valido se cumple que:
* &#x09;cada estudiante tiene registradas las horas de clase de cada materia\
&#x09;que tiene exactamente 1 grupo de cada materia matriculada
&#x09;que matriculo en las correspondientes horas de cada grupo de clase
&#x20;

* &#x09;las horas de clase registradas de cada grupo de clase no se superponen entre ellas.

\----------------------------------------------------------------------------------------------------------------------------------

se leería entonces de un documento externo:



* las materias que hay y los grupos de clase de cada materia.



* el horario que tiene el usuario.

\----------------------------------------------------------------------------------------------------------------------------------

Posteriormente:

* se recibiría del usuario la condición deseada (tener libres los martes... etc.).
* se computan los cambios necesarios de grupos de clase para tener el horario deseado.
* se imprime en pantalla los cambios requeridos o la imposibilidad de cumplir la condición.

&#x20;

&#x20;

&#x20;

&#x20;

