package contracts;

import exeptions.DuplicateModelException;

import java.util.Collection;

public interface Race {

    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats();

    void addParticipant(Boat boat) throws DuplicateModelException;

    Collection<Boat> getParticipants();
}
