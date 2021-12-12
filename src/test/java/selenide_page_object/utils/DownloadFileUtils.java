package selenide_page_object.utils;

import com.codeborne.selenide.Selenide;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static selenide_page_object.utils.config.WebConfig.WEB_CONFIG;

public class DownloadFileUtils {
    private static final String DOWNLOAD_FOLDER_PATH = Paths.get(System.getProperty("user.dir"), WEB_CONFIG.getDownloadsPath()).toString();

    public static boolean isFileDownloaded(final String fileName) {
        if (!WEB_CONFIG.isRemote()) {
            return Files.exists(Paths.get(WEB_CONFIG.getDownloadsPath(), fileName));
        } else {
            return executeJavaScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"" + fileName + "\"}}");
        }
    }

    public static boolean isFileDownloaded(final String fileName, final int timeout) {
        int counter = timeout;
        while (counter > 0 && !isFileDownloaded(fileName)) {
            Selenide.sleep(1000);
            counter--;
        }
        return isFileDownloaded(fileName);
    }

    public static void deleteFileIfExists(final String fileName) {
        if (!WEB_CONFIG.isRemote()) {
            try {
                Files.deleteIfExists(Paths.get(WEB_CONFIG.getDownloadsPath(), fileName));
            } catch (IOException e) {
            }
        }
    }

    public static void cleanDownloadsDirectory() {
        if (!WEB_CONFIG.isRemote()) {
            try {
                FileUtils.cleanDirectory(new File(DOWNLOAD_FOLDER_PATH));
            } catch (IOException e) {
            }
        }
    }
}
