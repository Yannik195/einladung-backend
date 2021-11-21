package app.einladung.backend.data

import app.einladung.backend.data.attendee.Attendee
import app.einladung.backend.data.attendee.AttendeeRepository
import app.einladung.backend.data.attendence.Attendance
import app.einladung.backend.data.attendence.AttendanceRepository
import app.einladung.backend.data.event.Event
import app.einladung.backend.data.event.EventRepository
import app.einladung.backend.data.organizer.Organizer
import app.einladung.backend.data.organizer.OrganizerRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataConfig {
    @Bean
    fun addData(
            attendeeRepository: AttendeeRepository,
            eventRepository: EventRepository,
            organizerRepository: OrganizerRepository,
            attendanceRepository: AttendanceRepository,
    ): CommandLineRunner {
        return CommandLineRunner { args ->
            addAttendees(attendeeRepository)
            addOrganizers(organizerRepository)
            addEvents(eventRepository, organizerRepository)
            addAttendances(attendanceRepository, eventRepository, attendeeRepository)
        }
    }

    fun addAttendees(attendeeRepository: AttendeeRepository) {
        val yannik = Attendee(null, "Yannik", "yannik@mail.de", emptySet())
        val miriam = Attendee(null, "Miriam", "miriam@mail.de", emptySet())
        val anna = Attendee(null, "Anna", "anna@mail.de", emptySet())
        attendeeRepository.save(yannik)
        attendeeRepository.save(miriam)
        attendeeRepository.save(anna)
    }

    fun addOrganizers(organizerRepository: OrganizerRepository) {
        val organizerManuel = Organizer(null, "Manuel", "manuel@mail.de", "01787359845", emptySet())
        val organizerVivienne = Organizer(null, "Vivienne", "vivienne@mail.de", "017638438749", emptySet())
        organizerRepository.save(organizerManuel)
        organizerRepository.save(organizerVivienne)
    }

    fun addEvents(eventRepository: EventRepository, organizerRepository: OrganizerRepository) {
        val event = Event(null, "Silvester 2022", emptySet(), organizerRepository.getById(1))
        eventRepository.save(event)
    }

    fun addAttendances(attendanceRepository: AttendanceRepository, eventRepository: EventRepository, attendeeRepository: AttendeeRepository) {
        val attendance = Attendance(null, eventRepository.getById(1), attendeeRepository.getById(1))
        attendanceRepository.save(attendance)
    }
}