import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;


import com.google.cloud.firestore.WriteResult;


public class Deque {

    private ArrayDeque<Object> arrayDeque = new ArrayDeque<Object>();

    Deque()
    {
        arrayDeque.add(7);
        arrayDeque.add(8);
        arrayDeque.add(9);
        arrayDeque.add(10);
        arrayDeque.add(11);
        arrayDeque.add(19);

    }

    public ArrayDeque<Object> getArrayDeque() {
        return arrayDeque;
    }

    public void addDataBase(DocumentReference documentReference) throws Exception{
        Map<String , Object> data = new HashMap<String, Object>();
        int N = arrayDeque.size();
        Object[] dequeArr = arrayDeque.toArray();
        for(int i = 0; i < N; i++){
            data.put((i + 1) + " element" , dequeArr[i]);
        }
        ApiFuture<WriteResult> result = documentReference.set(data);
        result.get().getUpdateTime();
    }
}

