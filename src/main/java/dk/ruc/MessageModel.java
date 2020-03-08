package dk.ruc;

public final class MessageModel {
    private String displayName;
    private long timestamp;
    private String text;

    public MessageModel(String displayName, long timestamp, String text) {
        this.displayName = displayName;
        this.timestamp = timestamp;
        this.text = text;
    }

    public String getDisplayName() {
        return displayName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getText() {
        return text;
    }
}
