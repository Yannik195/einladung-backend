package app.einladung.backend.data.organizer

import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("/api/v1/organizer")
class OrganizerController(val organizerService: OrganizerService) {

    @GetMapping
    fun getOrganizers(): List<Organizer> {
        return organizerService.getOrganizers()
    }

    @PostMapping
    fun addOrganizer(@RequestBody organizer: Organizer): List<Organizer> {
        return organizerService.addOrganizer(organizer)
    }

    @DeleteMapping("/{organizerId}")
    fun deleteOrganizer(@PathVariable("organizerId") organizerId: Long): List<Organizer> {
        return organizerService.deleteOrganizer(organizerId)
    }
}