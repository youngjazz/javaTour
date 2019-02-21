package json;

import lombok.Data;

import java.io.Serializable;

/**
 * todo
 *
 * @author leon
 * @since 2019-01-10
 */
@Data
public class AgentInfo implements Serializable {
    private String deptCode;
    private String provinceCode;
    private String cityCode;
    private String areaCode;
    private String agentCode;
    private String agentName;
    private String conferCode;
    private String operatorCode;
    private String salesmanNo;
    private String qlfNo;
    private String agentType;

    public AgentInfo() {
    }
}