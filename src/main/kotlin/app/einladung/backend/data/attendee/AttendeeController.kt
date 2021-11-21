package app.einladung.backend.data.attendee

import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping(path = arrayOf("api/v1/attendee"))
class AttendeeController(val attendeeService: AttendeeService) {

    @GetMapping
    fun getAttendees(): List<Attendee> {
        return attendeeService.getAttendees()
    }

    @PostMapping
    fun addAttendee(@RequestBody attendee: Attendee): List<Attendee> {
        return attendeeService.addAttendee(attendee)
    }

    @DeleteMapping("/{attendeeId}")
    fun deleteAttendee(@PathVariable("attendeeId") attendeeId: Long): List<Attendee> {
        return attendeeService.deleteAttendee(attendeeId)
    }

    @PutMapping("/{attendeeId}")
    fun updateAttendee(
            @PathVariable("attendeeId") attendeeId: Long,
            @RequestParam(required = false) name: String,
            @RequestParam(required = false) email: String,
    ): List<Attendee> {
        return attendeeService.updateAttendee(attendeeId, name, email)
    }
}
