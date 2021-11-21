package app.einladung.backend.data.event

import app.einladung.backend.data.attendence.Attendance
import app.einladung.backend.data.organizer.Organizer
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "Event")
@Table(name = "event")
class Event(
        @Id
        @SequenceGenerator(
                name = "event_sequence",
                sequenceName = "event_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "event_sequence"
        )
        var id: Long?,
        var name: String,
        @JsonIgnore
        @OneToMany(mappedBy = "event")
        var attendencies: Set<Attendance>,
        @ManyToOne
        @JoinColumn(name = "organizer_Id")
        var organizer: Organizer

)