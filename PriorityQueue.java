/*  Programm            : PriotityQueue.java
    Autoren             : Sönke Baumgarten, Sven Andris
    Letzte Änderung     : 21.11.2024
 */

import java.util.Iterator;
@SuppressWarnings("unchecked")

public class PriorityQueue<T extends Comparable<T>> implements Iterable<T>{ // Es ist eine Klasse "T", welche wir nicht kennen...
                                                                            // ... aber sie muss ein Interface implementieren, nämlich "Comparable von "T".
                                                                            // Die Iteratorklasse liefert auch "T" zurück.
    // attributes
    private int size;                       // how many objects are stored currently
    private T[] elements;                   // the array of _comparable_ objects - es sollen jetzt T-Objekte abgespeichert werden

    // constructor
    public PriorityQueue()     // initialises all attributes
    {
        this.size = 0;
        this.elements = (T[])new Comparable[2]; // Caste auf T-Array, da "elements" von der Klasse T ist. "Ugly-Cast", geht nicht anders.
    }

    // methods
    public T get()   // returns the largest element stored - Liefert jetzt ein T-Objekt
    {
        T biggest = this.elements[0];                       // speichere das erste Element aus dem Array.
        int index = 0;                                      // Index des größten Elements.
        for(int i = 1; i < size; i++)
        {     
            if(this.elements[i].compareTo(biggest) > 0)     // Wenn das aktuelle Element größer ist als das bisher größte...
            {
                biggest = this.elements[i];                 // ... speiche neuen größten Wert...
                index = i;                                  // ... und passe Index an.
            }
        }
        // Lösche größten Wert aus Queue
        this.elements[index] = this.elements[this.size-1];      // Schiebe letztes Element in Queue auf Platz des größten Elements.
        this.elements[this.size-1] = null;                      // Setze letztes Element des Arrays auf NULL.                          
        this.size--;                                            // Verringere die Anzahl der Elemente um 1, da größter Wert gelöscht.        
        
        if (this.elements.length > 2){      // prüfe, ob Array noch länger als 2 ist
            if (((double)this.size / (double)this.elements.length) < 0.25){             // Wenn weniger als 25 Prozent im Array...
                T[] tempElements = (T[])new Comparable[this.elements.length / 2];       // ... erstelle neues Array mit halber Länge. "Ugly-Cast"
                for (int i = 0; i < tempElements.length; i++){                          // ... kopiere Werte in das neue Array
                    tempElements[i] = this.elements[i];
                }
                this.elements = tempElements;
            }
        } 
        return biggest;
    }

    public void put(T c) // add an object to the queue - Erwarten ein T-Objekt
    {
        if (this.elements.length == this.size){         // Ist Array voll...
            T[] tempElements = (T[])new Comparable[this.elements.length * 2];   // ... erstelle neues Array mit doppelter Länge. "Ugly-Cast"
            for (int i = 0; i < this.elements.length; i++){                     // ... kopiere Werte in das neue Array
                tempElements[i] = this.elements[i];
            }
            this.elements = tempElements;                                       // temporäres Array in elements kopieren 
        }
        this.elements[size] = c;    // Schreibe das neue Element an die erste freie Stelle in der Queue.
        this.size++;                // Erhöhe die Anzahl der Elemente.
    }
    public int getSize()  // how many elements are stored currently
    {
        return this.size;
    }
    public int getQueuesize() // size of the queue currently (total lenght of array)
    {
        return this.elements.length;
    }

    // Gehe durch das Elements-Array und gib jede Stelle nacheinander aus, ohne diese zu löschen
    @Override
    public Iterator<T> iterator() {            // Anonyme Klasse Iterator
        return new Iterator<T>() {                 
            int ind = 0;                                // Laufvariable für Array index
            
            @Override
            public boolean hasNext() {
                return ind < getSize();                 // Wenn der Index kleiner ist als size, dann gibts ein nächstes Objekt
            }

            @Override
            public T next() {                  
                    T obj = elements[ind];     // Schreibe aktuelles Objekt aus Array in Objekt
                    ind++;                              // gehe zu nächsten Stelle im Array
                    return obj; 
            }
        };
    }
  
/*
    public static void main(String[] args) {
        PriorityQueue Queue = new PriorityQueue();
        Queue.put(8);
        Queue.put(1);
        Queue.put(9);
        Queue.put(4);
        Queue.put(2);

        for(int i  = 0; i< Queue.elements.length; i++){
            System.out.print(Queue.elements[i]);
        }
        System.out.println();

        System.out.println(Queue.get());
        for(int i  = 0; i< Queue.elements.length; i++){
            System.out.print(Queue.elements[i]);
        }
        System.out.println();

        System.out.println(Queue.get());
        for(int i  = 0; i< Queue.elements.length; i++){
            System.out.print(Queue.elements[i]);
        }
        System.out.println();

        System.out.println(Queue.get());
        for(int i  = 0; i< Queue.elements.length; i++){
            System.out.print(Queue.elements[i]);
        }
        System.out.println();

        System.out.println(Queue.get());
        for(int i  = 0; i< Queue.elements.length; i++){
            System.out.print(Queue.elements[i]);
        }
        System.out.println();

        System.out.println(Queue.get());
        for(int i  = 0; i< Queue.elements.length; i++){
            System.out.print(Queue.elements[i]);
        }
        System.out.println();

        Queue.put(3);
        Queue.put(4);
        for(int i  = 0; i< Queue.elements.length; i++){
            System.out.print(Queue.elements[i]);
        }
        System.out.println();

    }
*/
}
