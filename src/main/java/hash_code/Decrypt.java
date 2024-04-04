package hash_code;

import controller.App;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

public class Decrypt {

    /**
     * Decrypts a given SHA-256 hash by searching for a corresponding value in a YAML dictionary file.
     *
     * @param hash     The SHA-256 hash to decrypt.
     * @param filepath The file path to the YAML dictionary file.
     * @return The decrypted value if found in the dictionary, "Not found" if not found, or "Error" in case of an exception.
     */

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
