package br.com.cobli.optimus.service

import br.com.cobli.optimus.model.User
import br.com.cobli.optimus.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(private val userRepository: UserRepository) : UserDetailsService {

    fun getUserById(id: UUID): User {
        return userRepository.getById(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(user)
    }
}
