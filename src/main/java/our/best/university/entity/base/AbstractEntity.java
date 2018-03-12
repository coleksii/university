package our.best.university.entity.base;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.Min;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public abstract class AbstractEntity {

    /**
     * Unique entity identifier
     */
    @NotNull
    @Min(value = 1)
    private long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
