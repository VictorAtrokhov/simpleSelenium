package victor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Victor
 */
public class Util
{
    private static final Map<String, String> contextMap = new HashMap<>();

    public static void put(String key, String value) {
        contextMap.put(key, value);
    }

    public static String get(String key) {
        return contextMap.get(key);
    }

    public static void generateRandomEmail()
    {
        Date currentDate = new Date();
        long milliseconds = currentDate.getTime();
        Random random = new Random(milliseconds);
        String email = "user" +random.nextInt() + "@fake.com";
        put("email" ,email);
    }

}
