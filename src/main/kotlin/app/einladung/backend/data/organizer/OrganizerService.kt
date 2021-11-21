package app.einladung.backend.data.organizer

import org.springframework.stereotype.Service

@Service
class OrganizerService(val organizerRepository: OrganizerRepository) {

    fun getOrganizers(): List<Organizer> {
        return organizerRepository.findAll()
    }

    fun addOrganizer(organizer: Organizer): List<Organizer> {
        organizerRepository.save(organizer).id
        return organizerRepository.findAll()
    }

    fun deleteOrganizer(id: Long): List<Organizer> {
        if(!organizerRepository.existsById(id)) {
            throw IllegalStateException("Organizer with id $id does not exist")
        }
        organizerRepository.deleteById(id)
        return organizerRepository.findAll()
    }

}