/*  Programm            : PriotityQueue.java
    Autoren             : Sönke Baumgarten, Sven Andris
    Letzte Änderung     : 20.11.2024
 */

@SuppressWarnings("rawtypes")
public class PriorityQueue implements Comparable{

    // attributes
    private int size;                   // how many objects are stored currently
    private Comparable[] elements;      // the array of _comparable_ objects

    // constructor
    public PriorityQueue(int queuesize) // initialises all attributes
    {
        this.size = 0;
        this.elements = new Comparable[queuesize];
    }

    // methods
    @SuppressWarnings("unchecked")
    public Comparable get()   // returns the largest element stored
    {
        Comparable biggest = this.elements[0];                      // speichere das erste Element aus dem Array.
        int index = 0;                                              // Index des größten Elements.
        for(int otto = 1; otto < size; otto++)
        {     
            if(this.elements[otto].compareTo(biggest) > 0)          // Wenn das aktuelle Element größer ist als das bisher größte...
            {
                biggest = this.elements[otto];                      // ... speiche neuen größten Wert...
                index = otto;                                       // ... und passe Index an.
            }
        }
        // Lösche größten Wert aus Queue
        this.elements[index] = this.elements[this.size-1];          // Schiebe letztes Element in Queue auf Platz des größten Elements.
        this.elements[this.size-1] = null;                          // Setze letztes Element des Arrays auf NULL.                          
        this.size--;                                                // Verringere die Anzahl der Elemente um 1, da größter Wert gelöscht.        
        return biggest;
    }

    public void put(Comparable c) // add an object to the queue
    {
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

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    public static void main(String[] args) {
        PriorityQueue Queue = new PriorityQueue(5);
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
    }
}
