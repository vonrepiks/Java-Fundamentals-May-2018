package event_implementation;

public class EventNameChange {

    private String nameChanged;

    public EventNameChange(String nameChanged) {
        this.nameChanged = nameChanged;
    }

    public String getNameChanged() {
        return this.nameChanged;
    }
}
