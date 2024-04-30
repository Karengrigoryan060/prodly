package pojos.content;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Content {
    @SerializedName("name")
    private String name;
    @SerializedName("path")
    private String path;
    @SerializedName("sha")
    private String sha;
    @SerializedName("size")
    private Integer size;
    @SerializedName("url")
    private String url;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("git_url")
    private String gitUrl;
    @SerializedName("download_url")
    private String downloadUrl;
    @SerializedName("type")
    private String type;
    @SerializedName("content")
    private String content;
    @SerializedName("encoding")
    private String encoding;
    @SerializedName("_links")
    private Links links;
}
