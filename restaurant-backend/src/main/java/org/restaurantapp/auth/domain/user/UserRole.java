package org.restaurantapp.auth.domain.user;

import jakarta.persistence.*;
import lombok.*;
import org.restaurantapp.auth.domain.role.Role;

@Builder
@Getter
@Entity
@Table(name = "user_role")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
}
