package app.einladung.backend.data.attendee

import org.springframework.data.jpa.repository.JpaRepository

interface AttendeeRepository : JpaRepository<Attendee, Long> {
}