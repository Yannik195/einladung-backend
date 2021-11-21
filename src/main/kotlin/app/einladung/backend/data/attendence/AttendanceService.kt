package app.einladung.backend.data.attendence

import app.einladung.backend.data.attendee.AttendeeRepository
import app.einladung.backend.data.event.EventRepository
import org.springframework.stereotype.Service

@Service
class AttendanceService(val attendanceRepository: AttendanceRepository, val eventRepository: EventRepository, val attendeeRepository: AttendeeRepository) {

    fun getAttendances(): List<Attendance> {
        return attendanceRepository.findAll()
    }

    fun addAttendance(eventId: Long, attendeeId: Long): List<Attendance> {
        val attendance = Attendance(null, eventRepository.getById(eventId), attendeeRepository.getById(attendeeId))
        attendanceRepository.save(attendance)
        return attendanceRepository.findAll()
    }

    fun deleteAttendance(id: Long): List<Attendance> {
        if(!attendanceRepository.existsById(id)) {
            throw IllegalStateException("Attendance with id $id does not exist")
        }
        attendanceRepository.deleteById(id)
        return attendanceRepository.findAll()
    }
}