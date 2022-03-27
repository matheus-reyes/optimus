package br.com.cobli.optimus.repository

import br.com.cobli.optimus.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID>
