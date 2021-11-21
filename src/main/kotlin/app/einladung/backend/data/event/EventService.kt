package app.einladung.backend.data.event

import org.springframework.stereotype.Service
import java.util.*

@Service
class EventService(val eventRepository: EventRepository) {

    fun getEvents(): List<Event> {
        return eventRepository.findAll()
    }

    fun getEvent(id: Long): Optional<Event> {
        if (!eventRepository.existsById(id)) {
            throw IllegalStateException("Event with id $id does not exist")
        }
        return eventRepository.findById(id)
    }

    fun addEvent(event: Event): List<Event> {
        eventRepository.save(event)
        return eventRepository.findAll()
    }

    fun deleteEvent(id: Long): List<Event> {
        if(!eventRepository.existsById(id)) {
            throw IllegalStateException("Event with id $id does not exist")
        }
        eventRepository.deleteById(id)
        return eventRepository.findAll()
    }
}