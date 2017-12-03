package ch.uzh.ifi.seal.log;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<String> messages;

    public Logger() {
        messages = new ArrayList<>();
    }

    public void log(String message) {
        this.messages.add(message);
    }
}
