package app.einladung.backend.data.organizer

import org.springframework.data.jpa.repository.JpaRepository

interface OrganizerRepository : JpaRepository<Organizer, Long> {
}