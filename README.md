# Getting Started

### How to remove duplicate objects in a List<Object> without equals/hashcode?

####Step 1: Tạo model CustomerInfo
```java
public class CustomerInfo {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CustomerInfo(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
```
####Step 2: Tạo equals/hashcode? ( vào model CustomerInfo chọn chuột trái -> Generate -> equar() and hasCode())
```java
public class CustomerInfo {
    ...
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerInfo that = (CustomerInfo) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
```
####Step 2: Dùng stream() loại bộ duplicate object
```java
List<CustomerInfo> customerInfosUnique = customerInfos.stream().distinct().collect(Collectors.toList());
```
* [Link github source code:](https://github.com/somethingsit/removeDublicateObject)
