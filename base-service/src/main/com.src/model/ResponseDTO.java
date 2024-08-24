package model;


import com.google.gson.Gson;
import exception.CustomException;
import lombok.Data;

import java.util.Date;

@Data
public class ResponseDTO {
    private long requestId;
    private String at;
    private CustomException error;

    private String message;
    private Object data;

    public ResponseDTO(long requestId, Date at, CustomException error, Object data) {
        this.requestId = requestId;
        this.at = String.valueOf(at);
        this.error = error;
        this.data = data;
    }

    public ResponseDTO(long requestId, Date at, String message, String data) {
        this.requestId = requestId;
        this.at = String.valueOf(at);
        this.message = message;
        this.data = data;
    }


    @Override
    public String toString() {
        String strResponse = new Gson().toJson(this);
        return strResponse.length() < 1000 ?
                strResponse :
                strResponse.substring(0, 1000) + "...";
    }

    public ResponseDTO() {
        super();
    }

}
