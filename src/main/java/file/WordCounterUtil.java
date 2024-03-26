package file;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WordCounterUtil {

    private final static Logger LOGGER = LogManager.getLogger(WordCounterUtil.class);

    public static void main(String[] args) throws IOException {
        File file = new File("src/test/resources/filename.txt");
        String contents = FileUtils.readFileToString(file, "UTF-8");
        int result = Arrays.asList(contents.split("[\\s@&.?$\"+-]+")).stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet()).size();
        FileUtils.writeStringToFile(file, String.valueOf(result), true);
    }
}
