package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomResponse {

    private String id;
    private String name_tag;
    private String creation_date;
    private int category_id;
    private String category_title;
    private String category_description;
    private boolean flag;
    private String created;
    private int product_id;
    private String product_title;
    private  int product_price;



}
