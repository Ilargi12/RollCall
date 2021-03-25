package pl.RollCall.exceptions;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Long id){
        super("Room with ID : " + id + " does not exist!");
    }
}
