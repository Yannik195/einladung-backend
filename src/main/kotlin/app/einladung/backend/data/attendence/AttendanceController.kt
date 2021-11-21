package app.einladung.backend.data.attendence

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/attendance")
class AttendanceController(val attendanceService: AttendanceService) {

    @GetMapping
    fun getAttendances(): List<Attendance> {
        return attendanceService.getAttendances()
    }

    @PostMapping
    fun addAttendance(@RequestBody attendance: Attendance): List<Attendance> {
        return attendanceService.addAttendance(attendance)
    }

    @DeleteMapping("/{attendanceId}")
    fun deleteAttendance(@PathVariable attendanceId: Long): List<Attendance> {
        return attendanceService.deleteAttendance(attendanceId)
    }
}