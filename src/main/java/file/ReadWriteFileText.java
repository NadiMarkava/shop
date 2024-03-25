package file;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class ReadWriteFileText {

    private final static Logger LOGGER = LogManager.getLogger(ReadWriteFileText.class);

    public static void main(String[] args) throws IOException {

    final File FILE = new File("filename.txt");
    String contents = FileUtils.readFileToString(FILE, "UTF-8");
    int items = new HashSet<String>(Arrays.asList(contents.split(" "))).size();
    LOGGER.info(contents);
    FileUtils.writeStringToFile(FILE, String.valueOf(items), true);
    }
}
