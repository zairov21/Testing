package entities;


import lombok.Data;

@Data
public class RequestBody {

    private String name_tag;
    private String description;
    private String category_title;
    private String category_description;
    private boolean flag;
    private int product_price;
    private int service_type_id;
    private int category_id;
    private int remind_before_day;
}
