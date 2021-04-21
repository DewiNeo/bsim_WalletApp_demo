package org.bsim.walletapp_demo.io.irepository;

import org.bsim.walletapp_demo.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
