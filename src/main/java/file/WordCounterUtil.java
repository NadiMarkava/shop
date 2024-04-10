package file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounterUtil {

    public static void main(String[] args) throws IOException {
        File file = new File("src/test/resources/filename.txt");
        String count = "Count: ";
        List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
        List<String> updatedLines = lines.stream()
                .filter(line -> !line.contains(count))
                .collect(Collectors.toList());
        FileUtils.writeLines(file, updatedLines, false);
        String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        int result = Arrays.asList(contents.split("[\\s@&.?$\"+-]+")).stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet()).size();
        String total = StringUtils.join(count, result, "\n");
        FileUtils.writeStringToFile(file, total, StandardCharsets.UTF_8, true);
    }
}
