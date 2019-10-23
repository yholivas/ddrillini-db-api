package club.ddrillini.api.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/fileserver")
public class FileUploadController {
    String uploadDir = java.lang.System.getenv("HOME") + "/projects/data-store/";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam(value = "upload") MultipartFile file)
        throws IOException {
        String fileExtension = getFileExtension(file);
        String filename = getRandomString();

        File targetFile = getTargetFile(fileExtension, filename);

        file.transferTo(targetFile);

        return filename;
    }

    /*
    @RequestMapping(value = "/upload/{fileId}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getFile(@PathVariable("fileId") String fileId)
        throws IOException {
    }
    */

    private String getRandomString() {
        return new Random().nextInt(999999) + "_" + System.currentTimeMillis();
    }

    private File getTargetFile(String fileExtension, String fileName) {
        File targetFile = new File(uploadDir + fileName + fileExtension);
        return targetFile;
    }

    private String getFileExtension(MultipartFile inFile) {
        String fileExtension = inFile.getOriginalFilename()
            .substring(inFile.getOriginalFilename().lastIndexOf('.'));
        return fileExtension;
    }
}
