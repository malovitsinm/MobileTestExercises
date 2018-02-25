package entities.web;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PanelContent {
    @SerializedName("blockLocator")
    private String blockLocator;
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String bodyContent;
    @SerializedName("links")
    private List<String> linkList;
}
