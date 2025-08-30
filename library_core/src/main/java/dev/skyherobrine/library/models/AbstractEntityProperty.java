package dev.skyherobrine.library.models;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Version;

import java.util.Date;
import java.util.Objects;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
public abstract class AbstractEntityProperty {

    @Id @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private Date updatedAt;

    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "updated_by", nullable = false, insertable = false)
    private String updatedBy;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntityProperty that = (AbstractEntityProperty) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCreatedBy(), that.getCreatedBy()) && Objects.equals(getUpdatedBy(), that.getUpdatedBy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreatedBy(), getUpdatedBy());
    }
}
