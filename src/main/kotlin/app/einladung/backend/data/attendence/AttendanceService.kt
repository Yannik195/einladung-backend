package app.einladung.backend.data.attendence

import org.springframework.stereotype.Service

@Service
class AttendanceService(val attendanceRepository: AttendanceRepository) {

    fun getAttendances(): List<Attendance> {
        return attendanceRepository.findAll()
    }

    fun addAttendance(attendance: Attendance): List<Attendance> {
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