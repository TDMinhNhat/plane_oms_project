package dev.tdminhnhat.service.repositories;

import dev.tdminhnhat.service.entities.User;
import dev.tdminhnhat.service.models.qo.UserQO;
import dev.tdminhnhat.service.models.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);

    @Query("""
        SELECT new dev.tdminhnhat.service.models.vo.UserVO(
            u.description, u.createdAt, u.updatedAt, u.firstName, u.lastName, u.sex,
            u.address, u.birthDate, u.phoneNumber, u.avatar, u.email, u.username, u.verify,
            u.role) FROM User u
        WHERE (#{#filter.userId()} IS NULL OR u.userId = #{#filter.userId()})
        AND (#{#filter.firstName()} IS NULL OR u.firstName = #{#filter.firstName()})
        AND (#{#filter.lastName()} IS NULL OR u.lastName = #{#filter.lastName()})
        AND (#{#filter.sex()} IS NULL OR u.sex = #{#filter.sex()})
        AND (#{#filter.birthDate()} IS NULL OR u.birthDate = #{#filter.birthDate()})
        AND (#{#filter.phoneNumber()} IS NULL OR u.phoneNumber = #{#filter.phoneNumber()})
        AND (#{#filter.email()} IS NULL OR u.email = #{#filter.email()})
        AND (#{#filter.username()} IS NULL OR u.username = #{#filter.username()})
        AND (#{#filter.verify()} IS NULL OR u.verify = #{#filter.verify()})
        AND (#{#filter.roleName()} IS NULL OR u.role.roleName = #{#filter.roleName()})
        ORDER BY u.updatedAt DESC, u.createdAt DESC
    """)
    Page<UserVO> getAllUsersByFilter(@Param("filter") UserQO filter, Pageable pageable);
}
