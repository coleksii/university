package our.best.university.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import our.best.university.entity.base.AbstractEntity;

@Getter
@Setter
@AllArgsConstructor

public class Department extends AbstractEntity {

    @NotNull
    @NotEmpty
    private String name;

    private Lector head;
}
