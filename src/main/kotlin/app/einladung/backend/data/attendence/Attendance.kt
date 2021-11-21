package app.einladung.backend.data.attendence

import app.einladung.backend.data.event.Event
import app.einladung.backend.data.attendee.Attendee
import javax.persistence.*

@Entity(name = "Attendance")
@Table(name = "attendance")
class Attendance(
    @Id
    @SequenceGenerator(
        name = "attendance_sequence",
        sequenceName = "attendance_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "attendance_sequence"
    )
    var id: Long?,
    @ManyToOne
    @JoinColumn(name = "event_id")
    var event: Event,
    @ManyToOne
    @JoinColumn(name = "attendee_id")
    var attendee: Attendee,
)