package hash_code;

import controller.App;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class Decrypt {

    public String goDecrypt(String hash, String filepath) {

        try {

            InputStream inputStream = App.class.getResourceAsStream(filepath);

            Yaml yaml = new Yaml();

            Map<String, Map<String, String>> yamlData = yaml.load(inputStream);

            if (yamlData.containsKey("Dictionary")) {
                Map<String, String> dictionary = yamlData.get("Dictionary");
                if (dictionary.containsKey(hash)) {
                    return dictionary.get(hash);
                }
            }

            return "Not found";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }

    }

}
