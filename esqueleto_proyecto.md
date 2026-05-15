Cada horario puede verse como una lista de grafos no dirigidos, de manera que cada día tiene un grafo ponderado asignado.
Cada vértice es una clase y las aristas que cada vértice se pondera con las horas que se paran cada clase.
De manera que:
Lunes {(clase de 8:00am a 10:00pm) <--(peso:4)--> (clase de 2:00pm a 3:00pm) <--(peso:1)--> (clase de 4:00pm a 6:00pm}


\-----------------------------------------------------------------------------------------------------------------------------------------

cada materia tiene n grupos de clase (C7B, C7A... etc.) y cada grupo

tiene clases en horas especificas (C7B tiene clase los lunes de 2pm a 

4pm...).

&#x20;       

al formarse un horario se cumple que:

* &#x09;cada estudiante tiene registradas las horas de clase de cada materia

&#x09;que matriculo en las correspondientes horas de cada grupo de clase

&#x20;       

* &#x09;las horas de clase registradas de cada grupo de clase no se 

&#x09;superponen entre ellas.

\-----------------------------------------------------------------------------------------------------------------------------------------

se leería entonces de un documento externo:



* las materias que hay y los grupos de clase de cada materia.



* el horario que tiene el usuario. 

\-----------------------------------------------------------------------------------------------------------------------------------------

Posteriormente: 

* se recibiría del usuario la condición deseada (tener libres los martes... etc.).
* se computan los cambios necesarios de grupos de clase para tener el horario deseado.
* se imprime en pantalla los cambios requeridos o la imposibilidad de cumplir la condición.

&#x20;               

&#x20;       

&#x20;       

&#x20;           

