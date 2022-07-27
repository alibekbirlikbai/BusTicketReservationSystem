package kz.iitu.itse1903.birlikbai.model.jms;

public class Send {

    private String to;
    private String body;

    public Send() {
    }

    public Send(String to, String body) {
        this.to = to;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return String.format("Message{to=%s, body=%s}", getTo(), getBody());
    }

}
