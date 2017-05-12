package JMockData.testBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 2017/4/16.
 */
public class MockDemoBeanSelfRefData {
    private String id;
    private String aString;
    private Integer aInteger;
    private Date aDate;
    private MockDemoBeanSelfRefData parent;
    private Map<MockDemoBeanSelfRefData,MockDemoBeanSelfRefData> parentMap;
    private MockDemoBeanSelfRefData[] parentArray;
    private List<MockDemoBeanSelfRefData> list;
    private List<MockDemoBeanSelfRefData[]> listArray;
    private List<List<MockDemoBeanSelfRefData[]>> listListArray;
    private List<MockDemoBeanSelfRefData>[] arrayList;
    private Map<MockDemoBeanSelfRefData,MockDemoBeanSelfRefData[]> mapArray;
    private Map<MockDemoBeanSelfRefData,List<MockDemoBeanSelfRefData>> mapList;
    private Map<MockDemoBeanSelfRefData,List<MockDemoBeanSelfRefData[]>> mapListArray;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public Integer getaInteger() {
        return aInteger;
    }

    public void setaInteger(Integer aInteger) {
        this.aInteger = aInteger;
    }

    public Date getaDate() {
        return aDate;
    }

    public void setaDate(Date aDate) {
        this.aDate = aDate;
    }

    public MockDemoBeanSelfRefData getParent() {
        return parent;
    }

    public void setParent(MockDemoBeanSelfRefData parent) {
        this.parent = parent;
    }

    public Map<MockDemoBeanSelfRefData, MockDemoBeanSelfRefData> getParentMap() {
        return parentMap;
    }

    public void setParentMap(Map<MockDemoBeanSelfRefData, MockDemoBeanSelfRefData> parentMap) {
        this.parentMap = parentMap;
    }

    public MockDemoBeanSelfRefData[] getParentArray() {
        return parentArray;
    }

    public void setParentArray(MockDemoBeanSelfRefData[] parentArray) {
        this.parentArray = parentArray;
    }

    public List<MockDemoBeanSelfRefData> getList() {
        return list;
    }

    public void setList(List<MockDemoBeanSelfRefData> list) {
        this.list = list;
    }

    public List<MockDemoBeanSelfRefData[]> getListArray() {
        return listArray;
    }

    public void setListArray(List<MockDemoBeanSelfRefData[]> listArray) {
        this.listArray = listArray;
    }

    public List<List<MockDemoBeanSelfRefData[]>> getListListArray() {
        return listListArray;
    }

    public void setListListArray(List<List<MockDemoBeanSelfRefData[]>> listListArray) {
        this.listListArray = listListArray;
    }

    public List<MockDemoBeanSelfRefData>[] getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<MockDemoBeanSelfRefData>[] arrayList) {
        this.arrayList = arrayList;
    }

    public Map<MockDemoBeanSelfRefData, MockDemoBeanSelfRefData[]> getMapArray() {
        return mapArray;
    }

    public void setMapArray(Map<MockDemoBeanSelfRefData, MockDemoBeanSelfRefData[]> mapArray) {
        this.mapArray = mapArray;
    }

    public Map<MockDemoBeanSelfRefData, List<MockDemoBeanSelfRefData>> getMapList() {
        return mapList;
    }

    public void setMapList(Map<MockDemoBeanSelfRefData, List<MockDemoBeanSelfRefData>> mapList) {
        this.mapList = mapList;
    }

    public Map<MockDemoBeanSelfRefData, List<MockDemoBeanSelfRefData[]>> getMapListArray() {
        return mapListArray;
    }

    public void setMapListArray(Map<MockDemoBeanSelfRefData, List<MockDemoBeanSelfRefData[]>> mapListArray) {
        this.mapListArray = mapListArray;
    }
}
