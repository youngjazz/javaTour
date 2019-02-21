package json;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * todo
 *
 * @author leon
 * @since 2019-01-10
 */

@Data
public class YongChengConfigDTO implements Serializable {
    private String userName;
    private String password;
    private List<AgentInfo> agentInfos = new ArrayList<>();

    public YongChengConfigDTO() {
    }

    public YongChengConfigDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public YongChengConfigDTO(String userName, String password, List<AgentInfo> agentInfos) {
        this.userName = userName;
        this.password = password;
        this.agentInfos = agentInfos;
    }
}