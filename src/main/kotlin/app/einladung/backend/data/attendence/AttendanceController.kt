package app.einladung.backend.data.attendence

import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("/api/v1/attendance")
class AttendanceController(val attendanceService: AttendanceService) {

    @GetMapping
    fun getAttendances(): List<Attendance> {
        return attendanceService.getAttendances()
    }

    @PostMapping("/event/{event_Id}/attendee/{attendee_Id}")
    fun addAttendance(@PathVariable("event_Id") eventId: Long, @PathVariable("attendee_Id") attendeeId: Long): List<Attendance> {
        return attendanceService.addAttendance(eventId, attendeeId)
    }

    @DeleteMapping("/{attendanceId}")
    fun deleteAttendance(@PathVariable attendanceId: Long): List<Attendance> {
        return attendanceService.deleteAttendance(attendanceId)
    }
}