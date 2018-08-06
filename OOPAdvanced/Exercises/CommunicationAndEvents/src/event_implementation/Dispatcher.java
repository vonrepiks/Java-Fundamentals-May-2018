package event_implementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private String name;

    private List<NameChangeListener> nameChangeListeners;

    public Dispatcher() {
        this.nameChangeListeners = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
        EventNameChange event = new EventNameChange(name);
        this.fireNameChangeEvent(event);
    }

    public void addNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListeners.add(nameChangeListener);
    }

    public void removeNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListeners.remove(nameChangeListener);
    }

    public void fireNameChangeEvent(EventNameChange event) {
        for (NameChangeListener nameChangeListener : this.nameChangeListeners) {
            nameChangeListener.handleChangedName(event);
        }
    }
}
