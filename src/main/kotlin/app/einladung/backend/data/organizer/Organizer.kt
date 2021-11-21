package app.einladung.backend.data.organizer

import app.einladung.backend.data.event.Event
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "Organizer")
@Table(name = "organizer")
class Organizer(
        @Id
        @SequenceGenerator(
                name = "organizer_sequence",
                sequenceName = "organizer_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "organizer_sequence"
        )
        var id: Long?,
        var name: String,
        var email: String,
        var phone: String,
        @JsonIgnore
        @OneToMany(mappedBy = "organizer")
        var events: Set<Event>
)