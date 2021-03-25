package pl.RollCall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.RollCall.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
