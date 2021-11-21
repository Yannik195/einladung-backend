package app.einladung.backend.data.event

import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("/api/v1/event")
class EventController(val eventService: EventService) {

    @GetMapping
    fun getEvents(): List<Event> {
        return eventService.getEvents()
    }

    @GetMapping("/{eventId}")
    fun getEvent(@PathVariable eventId: Long): Optional<Event> {
        return eventService.getEvent(eventId)
    }


    @PostMapping
    fun addEvent(@RequestBody event: Event): List<Event> {
        return eventService.addEvent(event)
    }

    @DeleteMapping("/{eventId}")
    fun deleteEvent(@PathVariable("eventId") eventId: Long): List<Event> {
        return eventService.deleteEvent(eventId)
    }
}