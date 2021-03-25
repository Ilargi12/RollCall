package pl.RollCall.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.RollCall.exceptions.RoomNotFoundException;
import pl.RollCall.model.Room;
import pl.RollCall.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public List<Room> getAll(){
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    public Room getOne(@PathVariable Long id){
        return roomService.getRoomById(id).
                orElseThrow(() -> new RoomNotFoundException(id));
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room){
        return roomService.createRoom(room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@RequestBody Room room, @PathVariable Long id){
        return roomService.updateRoom(room, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id){
        roomService.deleteRoom(id);
    }





}
