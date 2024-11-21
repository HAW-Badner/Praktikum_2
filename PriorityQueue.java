/*  Programm            : PriotityQueue.java
    Autoren             : Sönke Baumgarten, Sven Andris
    Letzte Änderung     : 21.11.2024
 */

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class PriorityQueue implements Iterable{

    // attributes
    private int size;                       // how many objects are stored currently
    private Comparable[] elements;          // the array of _comparable_ objects

    // constructor
    public PriorityQueue()     // initialises all attributes
    {
        this.size = 0;
        this.elements = new Comparable[2];
    }

    // methods
    @SuppressWarnings("unchecked")
    public Comparable get()   // returns the largest element stored
    {
        Comparable biggest = this.elements[0];                      // speichere das erste Element aus dem Array.
        int index = 0;                                              // Index des größten Elements.
        for(int i = 1; i < size; i++)
        {     
            if(this.elements[i].compareTo(biggest) > 0)          // Wenn das aktuelle Element größer ist als das bisher größte...
            {
                biggest = this.elements[i];                      // ... speiche neuen größten Wert...
                index = i;                                       // ... und passe Index an.
            }
        }
        // Lösche größten Wert aus Queue
        this.elements[index] = this.elements[this.size-1];          // Schiebe letztes Element in Queue auf Platz des größten Elements.
        this.elements[this.size-1] = null;                          // Setze letztes Element des Arrays auf NULL.                          
        this.size--;                                                // Verringere die Anzahl der Elemente um 1, da größter Wert gelöscht.        
        
        if (this.elements.length > 2){      // prüfe, ob Array noch länger als 2 ist
            if (((double)this.size / (double)this.elements.length) < 0.25){             // Wenn weniger als 25 Prozent im Array...
                Comparable[] tempElements = new Comparable[this.elements.length / 2];   // ... erstelle neues Array mit halber Länge
                for (int i = 0; i < tempElements.length; i++){                          // ... kopiere Werte in das neue Array
                    tempElements[i] = this.elements[i];
                }
                this.elements = tempElements;
            }
        }

        
        return biggest;
    }

    public void put(Comparable c) // add an object to the queue
    {
        if (this.elements.length == this.size){         // Ist Array voll...
            Comparable[] tempElements = new Comparable[this.elements.length * 2];   // ... erstelle neues Array mit doppelter Länge
            for (int i = 0; i < this.elements.length; i++){                         // ... kopiere Werte in das neue Array
                tempElements[i] = this.elements[i];
            }
            this.elements = tempElements;                                           // temporäres Array in elements kopieren 
        }


        if(size < this.elements.length){                // Schreibe das neue Element an die erste freie Stelle in der Queue.
            this.elements[size] = c;
            this.size++;                                // Erhöhe die Anzahl der Elemente.
        }
        else{
            System.out.println("Kein Platz");
        }        
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
    public Iterator<Comparable> iterator() {            // Anonyme Klasse Iterator
        return new Iterator<Comparable>() {                 
            int ind = 0;                                // Laufvariable für Array index
            
            @Override
            public boolean hasNext() {
                return ind < getSize();                 // Wenn der Index kleiner ist als size, dann gibts ein nächstes Objekt
            }

            @Override
            public Comparable next() {                  
                    Comparable obj = elements[ind];     // Schreibe aktuelles Objekt aus Array in Objekt
                    ind++;                              // gehe zu nächsten Stelle im Array
                    return obj; 
            }
        };
    }
  

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

}
