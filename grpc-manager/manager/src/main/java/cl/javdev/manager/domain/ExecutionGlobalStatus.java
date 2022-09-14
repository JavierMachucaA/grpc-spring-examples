package cl.javdev.manager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExecutionGlobalStatus implements Serializable {
    private boolean runRead ;

    private boolean runReadAspect;

    private boolean runNormalizer;

    private boolean runPurgeRRS;

    private boolean runPrugeO;

    private boolean runUpdateUsers;
}