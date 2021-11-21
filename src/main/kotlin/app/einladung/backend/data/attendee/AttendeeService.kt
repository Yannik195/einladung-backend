package app.einladung.backend.data.attendee

import org.springframework.stereotype.Service

@Service
class AttendeeService(val attendeeRepository: AttendeeRepository) {

    fun getAttendees(): List<Attendee> {
        return attendeeRepository.findAll()
    }

    fun addAttendee(attendee: Attendee): List<Attendee> {
        attendeeRepository.save(attendee)
        return attendeeRepository.findAll()
    }

    fun deleteAttendee(id: Long): List<Attendee> {
        if(!attendeeRepository.existsById(id)) {
            throw IllegalStateException("Student with id $id does not exist")
        }
        attendeeRepository.deleteById(id)
        return attendeeRepository.findAll()
    }

    fun updateAttendee(id: Long, name: String, email: String): List<Attendee> {
        return attendeeRepository.findAll()
    }
}