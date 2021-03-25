package domain.slackNoti;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Parameter {
    private String channel;
    private String username;
    private String text;
    @JsonProperty("attachments")
    private List<Attachment> attachments;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
