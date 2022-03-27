package br.com.cobli.optimus.service

import br.com.cobli.optimus.model.User
import br.com.cobli.optimus.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(private val userRepository: UserRepository) {

    fun getUserById(id: UUID): User {
        return userRepository.getById(id)
    }
}
