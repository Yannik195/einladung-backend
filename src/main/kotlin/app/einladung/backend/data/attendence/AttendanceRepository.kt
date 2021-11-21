package app.einladung.backend.data.attendence

import org.springframework.data.jpa.repository.JpaRepository

interface AttendanceRepository : JpaRepository<Attendance, Long> {
}