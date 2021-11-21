package app.einladung.backend.data.organizer

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
)