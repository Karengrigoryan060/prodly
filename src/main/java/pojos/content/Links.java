package pojos.content;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Links {
    @SerializedName("self")
    private String self;
    @SerializedName("git")
    private String git;
    @SerializedName("html")
    private String html;
}
