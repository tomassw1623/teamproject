package org.crm.crmproject.dto.upload;

import lombok.Builder;

@Builder
public class UploadResultDTO {

    private String uuid;
    private String fileName;
    private boolean img;
    public String getLink(){
        if(img){
            return "s_"+uuid+"_"+fileName;//이미지인 경우 섬네일
        }else {
            return uuid+"_"+fileName    ;
        }
    }
}
