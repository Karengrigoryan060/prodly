package pojos.branch;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MergeBranchParams {
    @SerializedName("base")
    private String base;
    @SerializedName("head")
    private String head;
    @SerializedName("commit_message")
    private String commitMessage;
}
