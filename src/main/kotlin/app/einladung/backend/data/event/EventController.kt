package app.einladung.backend.data.event

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/event")
class EventController(val eventService: EventService) {

    @GetMapping
    fun getEvents(): List<Event> {
        return eventService.getEvents()
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