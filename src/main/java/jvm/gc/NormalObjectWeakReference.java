package jvm.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author leon
 * @date 2019-03-01
 */
public class NormalObjectWeakReference extends WeakReference<NormalObject> {
    public String name;

    public NormalObjectWeakReference(NormalObject referent, ReferenceQueue<? super NormalObject> q) {
        super(referent, q);
        this.name = referent.name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing NormalObjectWeakReference: " + name);
    }
}
