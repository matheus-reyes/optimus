package br.com.cobli.optimus.service

import br.com.cobli.optimus.model.User
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(private final var users: List<User>) {

    init {
        val user = User(
            id = UUID.fromString("163945ed-6af4-4c00-933c-65152a5ae9e7"),
            name = "Anderson",
            email = "anderson@email.com",
        )
        users = listOf(user)
    }

    fun getUserById(id: UUID): User {
        return users.stream().filter { user ->
            user.id == id
        }.findFirst().get()
    }
}
