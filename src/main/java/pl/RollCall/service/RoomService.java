package pl.RollCall.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.RollCall.exceptions.RoomNotFoundException;
import pl.RollCall.model.Room;
import pl.RollCall.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Room room, Long id) {
        Room roomToUpdate = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
        roomToUpdate.setId(room.getId());
        roomToUpdate.setName(room.getName());
        roomToUpdate.setOwner(room.getOwner());
        roomToUpdate.setUserList(room.getUserList());
        return roomRepository.save(roomToUpdate);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
