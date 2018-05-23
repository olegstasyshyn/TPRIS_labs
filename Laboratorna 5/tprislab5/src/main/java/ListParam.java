import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ListParam {

    private ArrayList<Object> list = new ArrayList<Object>();

    public ArrayList<Object> getListParam() {
        return list;
    }

    ListParam(){

        /*for(int i = 0; i < 2000; i++){
            list.add((char)Math.random() * 10 + 50);
        }*/

        list.add("b");
        list.add("l");
        list.add("m");
        list.add("n");
        list.add("c");
        list.add("z");
    }

    public void addDataBase(DocumentReference documentReference) {
        try {
            Map<String, Object> data = new HashMap<String, Object>();
            int N = list.size();
            Object[] dequeArr = list.toArray();
            for (int i = 0; i < N; i++) {
                data.put((i + 1) + " element", dequeArr[i]);
            }
            ApiFuture<WriteResult> result = documentReference.set(data);
            result.get().getUpdateTime();
        }catch(InterruptedException interrupted){
            interrupted.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}
