import java.util.HashMap;
import java.util.Set;

/**
 * HashMap
 */
public class HashMapa {
    public static void main(String[] args) {
        HashMap<String, String> tracklist = new HashMap<String, String>();
         tracklist.put ("Days","Dreams");
         tracklist.put ("like a stone", "audioslave");
         tracklist.put ("'cause i'am a man","Tame impala");
         tracklist.put ("Ghost ship","Blur");
         
         Set<String> keys = tracklist.keySet();
         for(String key : keys) {
             System.out.println(tracklist.get(key)+" - "+ key);
        }
    }
}