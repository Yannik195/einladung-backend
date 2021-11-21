package app.einladung.backend.data.attendee

import app.einladung.backend.data.attendence.Attendance
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "Attendee")
@Table(name = "attendee")
class Attendee(
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
        @OneToMany(mappedBy = "attendee")
        var attendencies: Set<Attendance>,
)