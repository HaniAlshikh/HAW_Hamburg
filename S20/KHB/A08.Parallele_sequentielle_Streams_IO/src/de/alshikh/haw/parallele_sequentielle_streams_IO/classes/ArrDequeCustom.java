package de.alshikh.haw.parallele_sequentielle_streams_IO.classes;

import java.io.IOException;
import java.io.ObjectInputValidation;
import java.io.Serializable;

/**********************************************************************
 *
 * showcasing the basic implementation of custom Serializable on ArrDeque
 *
 * @author Hani Alshikh
 *
 ************************************************************************/
public class ArrDequeCustom<E> extends ArrDeque<E>
        implements Serializable //, ObjectInputValidation
{

    public ArrDequeCustom(int size) {
        super(size);
    }

    public ArrDequeCustom() {
        super();
    }

    private static final long serialVersionUID = 5888241769701361418L;

    // we could also validate object state here
    //@Override
    //public void validateObject() {
    //    System.out.println("Validating...");
    //}

    /**
     * save this arrDeque to a stream (serialize it)
     *
     * @param s the stream
     * @throws IOException if an I/O error occurs
     * @serialData The current size ({@code int}) of the arrDeque,
     * followed by all of its elements in first-to-last order.
     */
    private void writeObject(java.io.ObjectOutputStream s)
            throws IOException {
        // ensure that object is in desired state.
        // checkState();

        // use java default serialization mechanism
        // The class of each serializable object is encoded including the class
        // name and signature of the class, the values of the object's fields and arrays,
        // and the closure of any other objects referenced from the initial objects.
        s.defaultWriteObject();
        // Write out size
        s.writeInt(size());
        // Write out elements in first-to-last order.
        for (int i = 0, j = head, size = size(); i < size; i++, j = inc(j, es.length)) {
            s.writeObject(es[i]);
        }
    }

    /**
     * Reconstitutes this arrDeque from a stream (deserializes it).
     *
     * @param s the stream
     * @throws ClassNotFoundException if the class of a serialized object
     *         could not be found
     * @throws IOException if an I/O error occurs
     */
    private void readObject(java.io.ObjectInputStream s)
            throws IOException, ClassNotFoundException {

        // The objects must be read back from the corresponding ObjectInputstream
        // with the same types and in the same order as they were written.

        // use java default deserialization mechanism
        s.defaultReadObject();

        // ensure that object state has not been corrupted or tampered with malicious code
        //checkState();
        //s.registerValidation(this, 0);
        //SharedSecrets.getJavaObjectInputStreamAccess().checkArray(s, Object[].class, size + 1);

        // Read in size and allocate array
        int size = s.readInt();
        es = new Object[Math.max(size, 1)];

        // set tail to last, which means arrDeque is full after deserializing
        this.tail = size;

        // Read in all elements in the proper order.
        for (int i = 0; i < size; i++)
            es[i] = s.readObject();
    }

    // we don't support this case...

    // For serializable objects, the readObjectNoData method allows a class
    // to control the initialization of its own fields in the event that a subclass
    // instance is deserialized and the serialization stream does not list
    // the class in question as a superclass of the deserialized object.
    // This may occur in cases where the receiving party uses a different
    // version of the deserialized instance's class than the sending party,
    // and the receiver's version extends classes that are not extended by the sender's version.
    // This may also occur if the serialization stream has been tampered; hence,
    // readObjectNoData is useful for initializing deserialized
    // objects properly despite a "hostile" or incomplete source stream.

    //private void readObjectNoData() throws ObjectStreamException;

}

