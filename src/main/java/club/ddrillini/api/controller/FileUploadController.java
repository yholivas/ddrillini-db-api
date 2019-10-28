/*
 * Copyright 2019 Daniel Olivas
 * This file is part of the DDRIllini Online DB API.

 * The DDRIllini Online DB API is free software: you can redistribute it
 * and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.

 * The DDRIllini Online DB API is distributed in the hope that it will
 * be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See
 * the GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with The DDRIllini Online DB API. If not, see
 * <https://www.gnu.org/licenses/>.
 */

package club.ddrillini.api.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Random;

import org.springframework.http.MediaType;
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

        return targetFile.getName();
    }

    @RequestMapping(value = "/download/{banner}", method = RequestMethod.GET, 
        produces = MediaType.IMAGE_PNG_VALUE)
    public String getFile(@PathVariable("banner") String banner)
        throws IOException {
        byte[] file = Files.readAllBytes(Paths.get(uploadDir + banner));

        return Base64.getEncoder().encodeToString(file);
    }

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
