package org.crm.crmproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.crm.crmproject.dto.upload.UploadFileDTO;
import org.crm.crmproject.dto.upload.UploadResultDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@Log4j2
public class UpdownController {

    @Value("/Users/th/Desktop/testPART6")
    private String uploadPath;

    @Operation(summary = "파일 등록", description = "POST 방식으로 파일을 등록합니다.")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<UploadResultDTO> upload(@RequestParam("files") List<MultipartFile> files) {

        if (files != null && !files.isEmpty()) {
            List<UploadResultDTO> list = new ArrayList<>();

            files.forEach(multipartFile -> {
                String originalName = multipartFile.getOriginalFilename();
                log.info(originalName);

                String uuid = UUID.randomUUID().toString();
                Path savePath = Paths.get(uploadPath, uuid + "_" + originalName);
                boolean image = false;

                try {
                    multipartFile.transferTo(savePath);

                    //이미지 파일의 종류라면
                    if(Files.probeContentType(savePath).startsWith("image")){

                        image = true;

                        File thumbFile = new File(uploadPath, "s_" + uuid+"_"+ originalName);

                        Thumbnailator.createThumbnail(savePath.toFile(), thumbFile, 200,200); // 썸네일 표기??
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                list.add(UploadResultDTO.builder()
                        .uuid(uuid)
                        .fileName(originalName)
                        .img(image).build()
                );
            });
            return list;
        }
        return null;
    }

    //첨부파일 삭제 메서드
    @Operation(summary = "view 파일",description = "GET방식으로 첨부파일 조회")
    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewFileGET(@PathVariable String fileName){
        Resource resource = new FileSystemResource(uploadPath+File.separator+fileName);
        HttpHeaders headers = new HttpHeaders();

        try {
            headers.add("Content-Type",Files.probeContentType(resource.getFile().toPath()));
        } catch (Exception e) {
            log.error("Error occurred while determining the content type of the file", e);
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    //첨부파일 삭제 메서드
    @Operation(summary = "remove삭제",description = "DELETE방식으로 파일 삭제")
@DeleteMapping("/remove/{fileName}")
public Map<String,Boolean> removeFile(@PathVariable String fileName){

    Resource resource = new FileSystemResource(uploadPath+File.separator+fileName);

    Map<String,Boolean> resultMap = new HashMap<>();
    boolean removed = false;

    try {
        String contentType =Files.probeContentType(resource.getFile().toPath());
        removed = resource.getFile().delete();

        //섬네일이 존재한다면
        if(contentType.startsWith("image")){
            File thumbnaFile = new File (uploadPath+File.separator+"s_"+fileName);
            thumbnaFile.delete();
        }
    }catch (Exception e){
        log.error(e.getMessage());
    }
    resultMap.put("result",removed);
    return  resultMap;
}
}
