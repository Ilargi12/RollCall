package pl.RollCall.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "myAccount")
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Room> roomsOwner;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "accounts")
    private List<Room> rooms;
}
